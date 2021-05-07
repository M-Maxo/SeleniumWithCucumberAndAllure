Feature: Add Product Review
	I want to add product review 
	Scenario Outline: Add Product Review
	Given R-user in home page
	When R-user can search for product "<productName>"
	And R-user click on add review
	Then R-user fill out review details
	Then make sure the review successfully "<reviewSuccess>"
	
	Examples:
| productName               |          reviewSuccess                | 
| Apple MacBook Pro 13-inch | Product review is successfully added. |