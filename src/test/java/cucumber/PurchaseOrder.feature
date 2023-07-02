Feature: PurchaseOrder

  Background:
    Given I landed on Ecommerce page

  Scenario Outline: Successfully purchase order
    Given Logged in with username <name> and password <password>
    When User add product <productName> to cart
    And User checkout <productName> and submit order
    Then User redirected to thankyou page

    Examples:
      | name                  | password    | productName |
      | rahulshetty@gmail.com | Iamking@000 | ZARA COAT 3 |


  #Database
  #Validation Data from Database
  #Get Data for credentials

  #Reusable Steps

  #Reporting

  #Implement using CS/HR m2

  #