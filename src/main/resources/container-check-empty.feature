Feature: Check shopping cart consistency

  Scenario: Check that shopping cart is empty all the time
    Given Shopping cart is empty
    When  Wait 5 seconds
    Then  Shopping cart is empty