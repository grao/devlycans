Feature: title
  In order to keep control of website information the expectation of the results 
  As an admin
  If you Login and as an normal User If you login 

  Background:

    Given an admin user exists with "demo" and "changeit"
    Given a normal user exists with "educator" and "educator1234"

Scenario: Admin User Login
    When I go to the login page
    When I login as Admin with "demo" and "changeit"
    Then I should be on the home page
    When I follow "demo"
    Then I should see "My Account"
    When I follow "Roles"
    Then I should see "SLI Administrator"
    Then I should logged out

  Scenario: Normal User Login

    Then I go to the login page
    When I login as Normal with "educator" and "educator1234"
    Then I should be on the home page
    When I follow "Some Educator"
    Then I should see "My Account"
    When I follow "Roles"
    
    Then I should not see "SLI Administrator"
    Then I should logged out
