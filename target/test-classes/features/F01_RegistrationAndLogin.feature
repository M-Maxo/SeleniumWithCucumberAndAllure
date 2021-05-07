@severity=blocker
Feature: User Registration Login 
	I want to check that the user can register and login.
	
	Scenario Outline: User Registration
	Given The user in main home page
	When I click on register link
	And I get user info from excelsheet "<SheetName>" , <RowNumber>
	Then The registration page displayed successfully
	
	Given click on login link
	When I entered login info from excelsheet "<SheetName>" , <RowNumber>
	Then User can logout
	 	
	
	Examples:
	| SheetName | RowNumber |
	| data     |     0      | 
	
	
	
	