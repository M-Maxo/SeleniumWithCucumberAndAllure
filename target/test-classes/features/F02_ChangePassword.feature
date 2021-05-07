@severity=blocker

Feature: Change Password
	I want to check if user can login with new password.
	
	Scenario Outline: Change Password
	Given I click on login link
	When User enter login info from excelsheet "<SheetName>" , <RowNumber>
	And Click on my acc page
	And Click on change password
	And User entered passwords from excelsheet "<SheetName>" , <RowNumber>
	Then user click on logout
	
	Given i click Login link
	When I enter login info from excelsheet "<SheetName>" , <RowNumber>
	Then user click logout link
	
	
	Examples:
	| SheetName | RowNumber |
	| data     |     0      |