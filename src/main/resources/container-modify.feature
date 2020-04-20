Feature: Modification of a shopping cart

  Scenario: Modify shopping cart
    Given Shopping cart is empty
    When  Add a new product to shopping cart
    And   Set category to telecommunications
    Then  Shopping cart contains 1 item