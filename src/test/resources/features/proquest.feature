@web
Feature: QA Simulation Tests

  @tcSimulation1
  Scenario: Verify user is able to save the titles of all the results on the first page to a text file
  
    Given User is on google page
    When user searches for "ProQuest"
    Then the user is able to save the titles of all the results on the first page to a text file
    
  @tcSimulation2
  Scenario: Verify user is able to take a screenshot of the ProQuest search results
  
    Given User is on google page
    When user searches for "ProQuest"
    When user clicks on "ProQuest | Databases, EBooks and Technology for Research" website fom the results
    And search for "QA" in the top nav
    Then user takes a screenshot

