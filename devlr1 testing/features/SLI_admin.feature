Feature: title
  In order to keep control of website information the expectation of the results 
  As an admin
  If you Login you should see SLI Administrator and as an normal User If you login, you should not see SLI administrator 

  Background:

    Given an admin user exists with "demo" and "changeit"
    

Scenario: Admin User Login
    When I go to the login page
    When I login with "demo" and "changeit"
    Then I should be on the home page
    Then I should see "Admin"
    Then I should logged out

  
