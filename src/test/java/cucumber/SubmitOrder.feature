
@tag
Feature: Purchase Order form Ecommerce Website
  I want to use this template for my feature file

Background
Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password<password>
    When I add product <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the Confirmation Page

    Examples: 
      | name		                    | password 		| productName   |
      | sumitnegi2072002@gmail.com  | Sumit*@1344 | IPHONE 13 PRO |
      
