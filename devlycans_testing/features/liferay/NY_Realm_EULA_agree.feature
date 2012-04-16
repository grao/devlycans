Feature: title
Navigate to dashboard link successfully using New York Realm under 'Select an Application' page
  
  #Background:
     #Given EULA has been accepted  
 @wip
  Scenario:-User Login through New York Realm with wrong username and password
    Given I have an open web browser
    Then I am on the Realm selection page
    Then I select "4cb026a0-73be-4296-ad36-d9abf11e3757"
    #Then I click "Go"
    When I login with "mario.sanc" and "mario.sanchez"
    Then I should be on the authentication failed page
    Then I should see "Authentication failed."
    
  @wip
  Scenario:-User Login through New York Realm
    Given I have an open web browser
    Then I am on the Realm selection page
    Then I select "4cb026a0-73be-4296-ad36-d9abf11e3757"
    #Then I click "Go"
    When I login with "mario.sanchez" and "mario.sanchez1234"
    Then I should be on the home page
    Then I should see " Dashboard"
    #Then I follow the home page Dashboard
    #Then I select "4cb026a0-73be-4296-ad36-d9abf11e3757"
    #Then I click "Go"
    #Then I should see "             Select an application         "
    #Then I should see "Learning Map"
   # Then I should see "Dashboard"
    
