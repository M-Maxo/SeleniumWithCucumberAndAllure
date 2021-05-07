@severity=critical

Feature: Search for product
	I want to check if Guest user or registered user can search for product 
	
	Scenario Outline: Search For Product
	Given  i write name of product in search from excelsheet "<SheetName>" , <RowNumber>
	Then guest user can show  product info "<SheetName>" , <RowNumber>
	
	Given registered user need to login
	When user enter his credential from excelsheet "<SheetName>" , <RowNumber>
	And write product name and search from excelsheet "<SheetName>" , <RowNumber>
	Then registered user can show product info "<SheetName>" , <RowNumber>
	
	
	Examples:
	| SheetName | RowNumber |
	| data     |     0      |
