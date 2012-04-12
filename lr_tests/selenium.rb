require 'rubygems'
require 'selenium-webdriver'#run the file ruby selenium.rb 'Name of your selection releam' 'username' 'password'

#driver = Selenium::WebDriver.for :firefox
profile = Selenium::WebDriver::Firefox::Profile.new
profile['network.http.prompt-temp-redirect'] = false
driver = Selenium::WebDriver.for :firefox, :profile => profile

driver.navigate.to "https://devlr2.slidev.org"
a=driver.find_element(:name,'realmId') #realmId should be the html tag name of select tag
options=a.find_elements(:tag_name=>"option") # all the options of that select tag will be selected
options.each do |g|
  if g.text == ARGV[0]
    g.click
    break
  end
end
ele=driver.find_element(:id, "go")
ele.click
if (ARGV[1] == "demo" && ARGV[2] == "changeit")  || (ARGV[1] == "educator" && ARGV[2] == "educator1234") || (ARGV[1] == "mario.sanchez" && ARGV[2] == "mario.sanchez1234" ) || (ARGV[1] == "jdoe" && ARGV[2] == "jdoe1234") 
  element = driver.find_element(:id, 'IDToken1') #the username field id is IDToken1
  element.send_keys ARGV[1]

  element = driver.find_element(:id, 'IDToken2') #the username field id is IDToken2
  element.send_keys ARGV[2]


  element=driver.find_element(:class, "Btn1Def")
  element.click
  begin
  set=driver.find_element(:xpath, "//span/input[@value='Agree']").displayed?
  set=true
  rescue
  set=false
  end
  if set
  driver.find_element(:xpath, "//span/input[@value='Agree']").click

  end
  wait = Selenium::WebDriver::Wait.new(:timeout => 100) # seconds
  wait.until { driver.find_element(:link => "Report a problem") }
  element1=driver.find_element(:link, "Report a problem")
  element1.click
  element=driver.find_element(:id, "_1_WAR_webformportlet_INSTANCE_FzH4hF7yJhCX_field2")
  element.send_keys "test Report"
  element=driver.find_element(:class, "aui-button-input-submit")
  element.click
  #if ARGV[1] == "demo"
  #  wait = Selenium::WebDriver::Wait.new(:timeout => 100) # seconds
   # wait.until { driver.find_element(:link => "Admin") }
   # element=driver.find_element(:link, 'Admin')
   # element.click
  #end
  wait = Selenium::WebDriver::Wait.new(:timeout => 100) # seconds
  wait.until { driver.find_element(:link => "Sign Out") }
  element=driver.find_element(:link, 'Sign Out')
  element.click
else
  puts "Authentication Failed"

end


