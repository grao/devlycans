Feature: title
  In order to keep control of website information the expectation of the results 
  for admin uses should see admin page


  Scenario:check admin user and go to admin page
    Given I have an open web browser
    When I go to the login page
    When I login with "demo" and "changeit"
    Then I should see "Admin"
    Then I follow "Admin"
    Then I should be on the admin page
