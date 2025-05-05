Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Validate phone number contains digit 5 in first 3 records of customer_addresses

    Given (customer_addresses) Execute SQL query to retrieve first 3 records from customer_addresses
    When (customer_addresses) Validate that each phone number contains the digit "5"
    Then Database connection is terminated.