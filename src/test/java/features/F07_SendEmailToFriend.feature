Feature: Send Email To friend
	I want to send Email with my friend which contains product details
	Scenario Outline: Send Email To friend
	Given iam in home page and search for product "<productName>"
	When i click on friend email
	Then fill out friend information and send the email
	Then make sure email sent succefully "<successMsg>"
	
	Examples:
 
	| productName                |         successMsg         |
	| Apple MacBook Pro 13-inch  | Your message has been sent.|