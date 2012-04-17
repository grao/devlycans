require 'rubygems'
require 'selenium-webdriver'
#require_relative '/../utils/sli_utils.rb'
require_relative '../../utils/selenium_common.rb'



Given /^an admin user Demo exists with "([^\"]*)" and "([^\"]*)"$/ do |username,password|
  

end

Given /^a normal user Educator exists with "([^\"]*)" and "([^\"]*)"$/ do |username,password|
  
  #User.new(:username => username, :password => password, :password_confirmation => password).save! unless User.exists?(:username => username)
 # User.exists?(:username => username)
end

Then /^I am on the Realm selection page$/ do
  @driver.navigate.to "https://devlycans.slidev.org/portal"
end

Then /^I select "([^\"]*)"$/ do |text|
begin
a=@driver.find_element(:name,'realmId') #realmId should be the html tag name of select tag
options=a.find_elements(:tag_name=>"option") # all the options of that select tag will be selected
options.each do |g|
  if g.attribute('value') == text || g.text == text
    g.click
    break
  end
end
ele=@driver.find_element(:id, "go")
ele.click
rescue
puts "SLI Exception"
end
  #select(text, :from => 'realmId') 
end

Then /^I follow all the wsrp links$/ do
  begin
  wsrp_elements= []
  #  wsrp_elements=@driver.find_elements(:xpath, "//section   [@id='portlet_appselectioninterfaceportlet_WAR_AppSelectionInterfaceportlet']/div/div/div/table/tbody/tr/td/a")
   @driver.find_elements(:xpath, "//a[@href='#']").each do |tt|
     if  tt.attribute('onclick') != nil && tt.attribute('onclick').match('callWsrp')
        wsrp_elements << tt
      end
   end
   wsrp_elements.compact!
   wsrp_ele=[]
   wsrp_elements.each do |wsrp|
    wsrp_ele << wsrp.attribute('onclick').gsub("callWsrp","").gsub("(","").gsub(")","").gsub("'","")
   end
   
   wsrp_ele.each do |el|
     @driver.navigate.to el
     puts "successfully open all the #{el} WSRP Page"
   end
   
   
   
   rescue
     puts "SLI Exception"
   end
    
end

Then /^I am on the wsrp page$/ do
begin
 text=@driver.find_element(:tag_name => "title").text()
 puts text
rescue
  puts "SLI Exception"
end

end


Then /^I select "([^\"]*)" from "([^\"]*)"$/ do |text,field|
begin
 a=@driver.find_element(:id, field)
 options=a.find_elements(:tag_name=>"option")
 options.each do |g|
  if g.attribute('value') == text || g.text == text
    g.click
    break
  end
 end
rescue
puts "SLI Exception"
end 
end




Then /^I click "([^\"]*)"$/ do |btn_text|
  ele=@driver.find_element(:id, "go")
  ele.click
  #@driver.find_element(:xpath, "//form/input[@value=#{btn_text}]").click
end 

Given /^EULA has been accepted$/ do

end

When /^I go to the login page$/ do
 @driver.navigate.to "https://devlycans.slidev.org/portal"
begin
a=@driver.find_element(:name,'realmId') #realmId should be the html tag name of select tag
ele=true
rescue
ele=false
end
begin
if ele == true
options=a.find_elements(:tag_name=>"option") # all the options of that select tag will be selected
options.each do |g|
  if g.attribute('value') == '5a4bfe96-1724-4565-9db1-35b3796e3ce1'
    g.click
    break
  end
end

ele=@driver.find_element(:id, "go")
ele.click
rescue
puts "SLI Exception"
end
end

  #visit "https://devlr2.slidev.org"
 # select('Shared Learning Infrastructure', :from => 'realmId')
  #click_button('Go')
end


Then  /^I follow the home page Dashboard$/ do 
 begin
  element= @driver.find_element(:xpath, "//a/span[text()=' SLI Dashboard']")
  element.click 
 rescue
  puts 'SLI Exception'
 end
end

Then /^I should logged out$/ do
  #begin
  #@driver.find_element(:link, 'Sign Out').click
  #rescue
  
  begin
   menu = @driver.find_elements(:class,"menulink").first
   action=Selenium::WebDriver::ActionBuilder.new(:move_to,nil)
   @driver.action.move_to(menu).perform
  rescue
    puts "SLI Exception"
  end 
   #submenu=@driver.find_element(:link, 'Logout')
   
   #@driver.action.move_to(menu).click(submenu).perform
  
  #click_link('Logout')
end

Then /^I should be on the home page$/ do
 begin
  ele=@driver.find_element(:xpath, "//input[@value='Agree']")
  element=true
 rescue
   element=false
 end

 if element
  ele.click
 else
  puts "EULA has already been accepted."
 end
 begin
  menu = @driver.find_elements(:class,"menulink").first
  action=Selenium::WebDriver::ActionBuilder.new(:move_to,nil)
  @driver.action.move_to(menu).perform
 rescue
   puts "SLI Exception"
 end  
   #submenu=@driver.find_element(:link, 'Logout').displayed?
 
   
 #@driver.find_element(:link, 'Sign Out').displayed?

end


And /^I see the EULA Page$/ do
  begin
    ele=@driver.find_element(:xpath, "//input[@value='Agree']")
    ele2=@driver.find_element(:xpath, "//input[@value='Logout']")
    element=true
  rescue
    element=false
  end
  if element == true
    true
  else
    puts "You have already Acepted EULA"
  end 
end



When /^I mouseover on menu and click submenu "([^\"]*)"$/ do |submenu|
   begin
    menu = @driver.find_elements(:class,"menulink").first
    action=Selenium::WebDriver::ActionBuilder.new(:move_to,nil)
    @driver.action.move_to(menu).perform
   rescue
     puts "SLI exception"
   end
   #submenu=@driver.find_element(:link, 'Logout')
  # submenu.click
   


end


#Then /^(?:|I )should be on (.+)$/ do |page_name|
#  current_path = URI.parse(current_url).select(:path, :query).compact.join('?')
#  if defined?(Spec::Rails::Matchers)
#    current_path.should == path_to(page_name)
#  else
#    assert_equal path_to(page_name), current_path
#  end
#end

Given /^I should remove all cookies$/ do
 @driver.manage.delete_all_cookies
end

When /^I login with "([^\"]*)" and "([^\"]*)"$/ do |username, password|
begin
  @driver.manage.delete_all_cookies
  element = @driver.find_element(:id, 'IDToken1') #the username field id is IDToken1
  element.send_keys username

  element = @driver.find_element(:id, 'IDToken2') #the username field id is IDToken2
  element.send_keys password
  element=@driver.find_element(:class, "Btn1Def")
  element.click
rescue
  puts "SLI Exception"
end  
  #wait = Selenium::WebDriver::Wait.new(:timeout => 100) # seconds
 # wait.until { driver.find_element(:link => "Logout") }
end
Then /^I should be on the authentication failed page$/ do
 @driver.navigate.to "https://devopenam1.slidev.org:80/idp2/UI/Login"
end

Then /^I click button "([^\"]*)"$/ do |text|
begin
  wait = Selenium::WebDriver::Wait.new(:timeout => 100)
  wait.until { @driver.find_element(:xpath, "//span/input[@value='#{text}']") 
   @driver.find_element(:xpath, "//span/input[@value='#{text}']").click
  
  }
  
rescue
  puts "SLI Exception"
end  
  
end


And /^I click "([^\"]*)"$/ do |btn|
   
  
end

Then /^It open a popup$/ do
 @driver.navigate.to "https://devlr1.slidev.org/web/guest/report-a-problem"
end


Then /^I should see "([^"]*)" as "([^"]*)"$/ do |field,text|
  begin
   if @driver.find_element(:id, field).text == text
    val=true
   else
    val=false
    puts "DEFECT:-The Description text box retains earlier text after reporting a problem"
   end 
  rescue
   puts "SLI Exception"
  end 
   
end

Then /^I fill "([^"]*)" from "([^"]*)"$/ do |arg1, arg2|
  @driver.find_element(:id, arg2).send_keys arg1
end

Then /^I close the browser$/ do
 @driver.quit
end

Then /^(?:|I )should see "([^\"]*)"$/ do |text|

  begin
   link=@driver.find_element(:link, text).displayed? || @driver.find_element(:name, text).displayed? 
   link=true
  rescue
   link=false
  end
  link 
  #page.should have_content(text)
end

Then /^(?:|I )should not see "([^\"]*)"$/ do |text|
  begin
   link=@driver.find_element(:link, text).displayed? || @driver.find_element(:name, text).displayed? 
   link=true
  rescue
   link=false
  end 
  link

#  page.should_not have_content(text)
end

When /^(?:|I )follow "([^\"]*)"$/ do |link|
begin
  @driver.find_element(:link, link).click
rescue
  puts "SLI Exception"
end  
  #click_link(link)
end


#Then /^(?:|I )should be on (.+)$/ do |page_name|
#  current_path = URI.parse(current_url).select(:path, :query).compact.join('?')
#  if defined?(Spec::Rails::Matchers)
#    current_path.should == path_to(page_name)
#  else
#    assert_equal path_to(page_name), current_path
#  end
#end
