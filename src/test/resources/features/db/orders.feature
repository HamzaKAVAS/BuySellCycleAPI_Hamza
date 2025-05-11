Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Calculate and verify the average grand_total where is_paid is 1
    When I calculate the average grand_total for paid orders
    Then I verify the average is correctly calculated and print the value