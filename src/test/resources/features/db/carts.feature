Feature: Calculating total amount for carts marked as buy now before a specific date

  Background: Database connectivity
    * Database connection established

  Scenario: Calculate the total amount for buy-now carts created before 2024-03-30
    When I calculate the total amount of buy-now carts before "2024-03-30"
    Then I print the total amount
    Then Database connection is terminated.