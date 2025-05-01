Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Transactions Database Testing

    Given (transactions) SQL query is prepared and executed.
    When  (transactions) is verified.
    Then  Database connection is terminated.