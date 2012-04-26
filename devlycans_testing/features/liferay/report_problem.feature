Feature: title
  In order to keep control of website information the expectation of the results 
  for report a problem it should have to work 

  #Background:
    #Given a normal user exists with "educator" and "educator1234"
  @wip  
  Scenario:Report a problem submission for SLI normal User
    Given I have an open web browser
    When I go to the login page
    When I login with "educator" and "educator1234"
    Then I should be on the home page
    When I mouseover on menu and click submenu "Report a problem"
    #Then It open a popup
    #Then I select "problem1" from "_1_WAR_webformportlet_INSTANCE_5SN4WTq6xBVJ_field1"
    #Then I fill "Some test Problems" from "_1_WAR_webformportlet_INSTANCE_5SN4WTq6xBVJ_field2"
    #Then I click button "Report A Problem"
    #Then I should see "The form information was sent successfully."
   
   @wip
   Scenario:Report a problem non happy submission for SLI normal User
    Given I have an open web browser
    When I go to the login page
    When I login with "educator" and "educator1234"
    Then I should be on the home page
    When I mouseover on menu and click submenu "Report a problem"
    #Then It open a popup
    #Then I click button "Report A Problem"
    #Then I should not see "The form information was sent successfully."
    
  Scenario:Report a problem cancelation for SLI admin User for Happy submission
    Given I have an open web browser
    When I go to the login page
    When I login with "demo" and "changeit"
    Then I should be on the home page
    When I mouseover on menu and click submenu "Report a problem"
    #When I follow "Report a Problem"
    Then It open a popup
    And I select the "Incorrect Data" 
    Then I fill "Some test Problems" from "_1_WAR_webformportlet_INSTANCE_kxDp6zzr4xIr_field2"
    Then I click button "Report a Problem"
    Then I should see "Thankyou for submitting"
  
  
  Scenario:Report a problem submission for SLI admin User for non Happy submission or blank submission
    Given I have an open web browser
    When I go to the login page
    When I login with "demo" and "changeit"
    Then I should be on the home page
    When I mouseover on menu and click submenu "Report a problem"
    #When I follow "Report a Problem"
    Then It open a popup
    
    Then I fill "Some test Problems" from "_1_WAR_webformportlet_INSTANCE_kxDp6zzr4xIr_field2"
    Then I click button "Report a Problem"
    Then I should see "This field is mandatory." 
   
   
   
    #Then I should see "_1_WAR_webformportlet_INSTANCE_5SN4WTq6xBVJ_field2" as ""
  @wip 
   Scenario:Report a problem happy cancelation for SLI admin User
    Given I have an open web browser
    When I go to the login page
    When I login with "demo" and "changeit"
    Then I should be on the home page
    When I mouseover on menu and click submenu "Report a problem"
    #Then It open a popup
    #Then I select "problem1" from "_1_WAR_webformportlet_INSTANCE_kxDp6zzr4xIr_field1"
    #Then I fill "Some test Problems" from "_1_WAR_webformportlet_INSTANCE_5SN4WTq6xBVJ_field2"
    #Then I click button "Cancel"
    #Then I should see "_1_WAR_webformportlet_INSTANCE_5SN4WTq6xBVJ_field2" as ""
    
   @wip
   Scenario:Report a problem non happy submission for SLI admin User
    Given I have an open web browser
    When I go to the login page
    When I login with "demo" and "changeit"
    Then I should be on the home page
    When I mouseover on menu and click submenu "Report a problem"
    #Then It open a popup
    #Then I click button "Report A Problem"
    #Then I should not see "The form information was sent successfully." 
     
    @wip
    Scenario: Report a problem happy submission for New York Realm User
     Given I have an open web browser
     Then I am on the Realm selection page
     Then I select "4cb026a0-73be-4296-ad36-d9abf11e3757"
     When I login with "mario.sanchez" and "mario.sanchez1234"
     Then I should be on the home page
     When I mouseover on menu and click submenu "Report a problem"
     #When I follow "Report a Problem"
     #Then It open a popup
     #Then I select "problem1" from "_1_WAR_webformportlet_INSTANCE_5SN4WTq6xBVJ_field1"
     #Then I fill "Some test Problems" from "_1_WAR_webformportlet_INSTANCE_5SN4WTq6xBVJ_field2"
     #Then I click button "Report A Problem"
    #Then I should see "The form information was sent successfully."
     
    @wip
    Scenario: Report a problem non happy submission for New York Realm User
     Given I have an open web browser
     Then I am on the Realm selection page
     Then I select "4cb026a0-73be-4296-ad36-d9abf11e3757"
     When I login with "mario.sanchez" and "mario.sanchez1234"
     Then I should be on the home page
     When I mouseover on menu and click submenu "Report a problem"
     #When I follow "Report a Problem"
     #Then It open a popup
    # Then I click button "Report A Problem"
    # Then I should not see "The form information was sent successfully." 
     
