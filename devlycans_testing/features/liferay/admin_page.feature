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
    
  Scenario:check Non admin user and check admin page
    Given I have an open web browser
    Then I am on the Realm selection page
    Then I select "4cb03fa0-83ad-46e2-a936-09ab31af377e"
    #Then I click "Go"
    When I login with "linda.kim" and "linda.kim1234"
    Then I should be on the home page
    Then I should not see "Admin" 
