@severity=critical


Feature: Add and Remove Product To Cart
 I want to check if i can add product to cart and remove it
 
 Scenario Outline: Add and Remove Product To Cart
 Given user can search for product "<productName>"
 When after redirect to product details i click on add to cart
 And make sure about product price "<productPrice>"
 Then i click on remove label 
 
 
 
 Examples:

 | productName               | productPrice |
 | Apple MacBook Pro 13-inch | $3,600.00    | 