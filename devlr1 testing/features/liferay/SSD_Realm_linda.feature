Feature: title
Navigate to dashboard link successfully using New York Realm under 'Select an Application' page
  
 
 Scenario:-User Login through SSD Realm with wrong username and password
    Given I have an open web browser
    Then I am on the Realm selection page
    Then I select "Sunset School District 4526"
    #Then I click "Go"
    When I login with "linda" and "linda.kim"
    Then I should be on the authentication failed page
    Then I should see "Authentication failed."
    
  
  Scenario:-User Login through SSD Realm
    Given I have an open web browser
    Then I am on the Realm selection page
    Then I select "Sunset School District 4526"
    #Then I click "Go"
    When I login with "linda.kim" and "linda.kim1234"
    Then I should be on the home page
    Then I should see " Dashboard"
    Then I follow the home page Dashboard
    Then I select "Sunset School District 4526"
    #Then I click "Go"
    #Then I should see "             Select an application         "
    Then I should see "Learning Map"
    Then I should see "Dashboard"
    Then I follow "Dashboard"
    Then I select "Daybreak School District 4529" from "edOrgSelect"
    Then I select "East Daybreak Junior High" from "schoolSelect"
    Then I select "7th Grade English" from "courseSelect"
    Then I select "7th Grade English - Sec. 3" from "sectionSelect"
    Then I should see "ISAT Reading"
     
