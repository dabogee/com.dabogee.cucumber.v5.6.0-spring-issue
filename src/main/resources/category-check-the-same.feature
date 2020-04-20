Feature: Modification of a shopping cart

  Scenario: Check that category is not changed during test
    Given Set category to financial
    When  Wait 6 seconds
    Then  Current category is financial