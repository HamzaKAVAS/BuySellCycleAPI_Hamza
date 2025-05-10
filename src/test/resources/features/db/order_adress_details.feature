Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Order Address Details Database Testing

    Given (order_address_details) SQL query is prepared and executed.
    When (order_address_details) is verified.
    Then Database connection is terminated.