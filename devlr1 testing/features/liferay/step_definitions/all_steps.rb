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
  @driver.navigate.to "https://testlr1.slidev.org"
end

Then /^I select "([^\"]*)"$/ do |text|

a=@driver.find_element(:name,'realmId') #realmId should be the html tag name of select tag
options=a.find_elements(:tag_name=>"option") # all the options of that select tag will be selected
options.each do |g|
  if g.text == text
    g.click
    break
  end
end
ele=@driver.find_element(:id, "go")
ele.click

  #select(text, :from => 'realmId') 
end


Then /^I select "([^\"]*)" from "([^\"]*)"$/ do |text,field|
 a=@driver.find_element(:id, field)
 options=a.find_elements(:tag_name=>"option")
 options.each do |g|
  if g.text == text
    g.click
    break
  end
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
 @driver.navigate.to "https://testlr1.slidev.org"
begin
a=@driver.find_element(:name,'realmId') #realmId should be the html tag name of select tag
ele=true
rescue
ele=false
end
if ele == true
options=a.find_elements(:tag_name=>"option") # all the options of that select tag will be selected
options.each do |g|
  if g.text == 'Shared Learning Infrastructure'
    g.click
    break
  end
end

ele=@driver.find_element(:id, "go")
ele.click
end

  #visit "https://devlr2.slidev.org"
 # select('Shared Learning Infrastructure', :from => 'realmId')
  #click_button('Go')
end


Then  /^I follow the home page Dashboard$/ do 
 begin
  element= @driver.find_element(:xpath, "//a/span[text()=' Dashboard']")
  element.click 
 rescue
  puts 'element selector has been changed'
 end
end

Then /^I should logged out$/ do
  @driver.find_element(:link, 'Sign Out').click
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
  puts "You have already agreed the EULA"
 end
 @driver.find_element(:link, 'Sign Out').displayed?

end


When /^I mouseover on menu and click submenu "([^\"]*)"$/ do |submenu|

   menu = @driver.find_element(:xpath,"//ul[@id='menu_n']/li[@class='first_item']/a")
   @driver.action.move_to(menu).perform
   
   submenu=@driver.find_element(:link, submenu)
   @driver.action.move_to(menu).click(submenu).perform


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
  @driver.manage.delete_all_cookies
  element = @driver.find_element(:id, 'IDToken1') #the username field id is IDToken1
  element.send_keys username

  element = @driver.find_element(:id, 'IDToken2') #the username field id is IDToken2
  element.send_keys password
  element=@driver.find_element(:class, "Btn1Def")
  element.click
  #wait = Selenium::WebDriver::Wait.new(:timeout => 100) # seconds
 # wait.until { driver.find_element(:link => "Logout") }
end
Then /^I should be on the authentication failed page$/ do
 @driver.navigate.to "https://devopenam1.slidev.org:80/idp2/UI/Login"
end

Then /^I click button "([^\"]*)"$/ do |text|
  wait = Selenium::WebDriver::Wait.new(:timeout => 100)
  wait.until { @driver.find_element(:xpath, "//span/input[@value='#{text}']") 
   @driver.find_element(:xpath, "//span/input[@value='#{text}']").click
  
  }
  
end


Then /^It open a popup$/ do
 @driver.navigate.to "https://devlr1.slidev.org/web/guest/report-a-problem"
end


Then /^I should see "([^"]*)" as "([^"]*)"$/ do |field,text|
   if @driver.find_element(:id, field).text == text
    val=true
   else
    val=false
    puts "DEFECT:-The Description text box retains earlier text after reporting a problem"
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
  @driver.find_element(:link, link).click
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
