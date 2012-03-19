
Given /^an admin user Demo exists with "([^\"]*)" and "([^\"]*)"$/ do
  
  User.new(:username => username, :password => password, :password_confirmation => password).save! unless User.exists?(:username => username)
  User.find_by_username('demo').update_attribute(:admin, 1)
end

Given /^a normal user Educator exists with "([^\"]*)" and "([^\"]*)"$/ do
  
  User.new(:username => username, :password => password, :password_confirmation => password).save! unless User.exists?(:username => username)
end

When /^I go to the login page$/ do
  visit "https://devlr1.slidev.org"
  select('Shared Learning Infrastructure', :from => 'realmId')
  click_button('Go')
end

Then /^We have to accept EULA$/ do

end

Then /^I should logged out$/ do
  click_link('Logout')
end

Then /^I should be on the home page$/ do
  
  #      response.should contain('Logout')
  page.should have_content('Logout')

end



#Then /^(?:|I )should be on (.+)$/ do |page_name|
#  current_path = URI.parse(current_url).select(:path, :query).compact.join('?')
#  if defined?(Spec::Rails::Matchers)
#    current_path.should == path_to(page_name)
#  else
#    assert_equal path_to(page_name), current_path
#  end
#end


When /^I login as Admin with "([^\"]*)" and "([^\"]*)"$/ do |username, password|
  
  visit "https://devlr1.slidev.org"
  fill_in "IDToken1", :with=>username
  fill_in "IDToken2", :with=>password
  click_button "Log In"
end

When /^I login as Normal with "([^\"]*)" and "([^\"]*)"$/ do |username, password|
  
  visit "https://devlr1.slidev.org"
  fill_in "IDToken1", :with=>username
  fill_in "IDToken2", :with=>password
  click_button "Log In"
end


Then /^(?:|I )should see "([^\"]*)"$/ do |text|
  page.should have_content(text)
end

Then /^(?:|I )should not see "([^\"]*)"$/ do |text|
  page.should_not have_content(text)
end
When /^(?:|I )follow "([^\"]*)"$/ do |link|
  click_link(link)
end

#Then /^(?:|I )should be on (.+)$/ do |page_name|
#  current_path = URI.parse(current_url).select(:path, :query).compact.join('?')
#  if defined?(Spec::Rails::Matchers)
#    current_path.should == path_to(page_name)
#  else
#    assert_equal path_to(page_name), current_path
#  end
#end
