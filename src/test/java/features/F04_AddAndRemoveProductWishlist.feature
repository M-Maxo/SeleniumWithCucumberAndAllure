@severity=critical

Feature: Add and Remove product wishlist
	I want to add product to wishlist and remove it
	
	Scenario Outline: Add and Remove product wishlist
		Given user search for product "<productName>"
		When user in product details page click on add to wishlist button
		And click on remove button
		Then make sure wishlist is empty "<empty>"
		
		
	Examples:
	| productName              |      empty             |
  | Apple MacBook Pro 13-inch| The wishlist is empty! |
		
		
		
		
