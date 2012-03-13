Feature: title
  In order to keep control of website information the expectation of the results 
  As an normal User If you login, you should not see SLI administrator 

  Background:
    Given a normal user exists with "educator" and "educator1234"
    
    
 Scenario: Admin User Login
    When I go to the login page
    When I login as Admin with "demo" and "changeit"
    Then I should be on the home page
    #When I follow "demo"
    #Then I should see "My Account"
   # When I follow "Roles"
    Then I should see "Admin"
    Then I should logged out
