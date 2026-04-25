@test
Feature: Login functionality
	
  Scenario: Valid login test
    Given user is on login page "https://the-internet.herokuapp.com/login"
    When user enters username "tomsmith" and password "SuperSecretPassword!"
    And user clicks login button
    Then user should be logged in successfully
    
	Scenario: Valid login test on Swag Labs
 		Given user is on login page "https://www.saucedemo.com/"
 		When user enters the username "<username>" and password "<password>"
 		And user clicks on Login button
 		Then user should be logged into home page successfully
 		
 		Examples: 
 				| username      | password     |
 				| standard_user | secret_sauce |
 				| problem_user	| secret_sauce |