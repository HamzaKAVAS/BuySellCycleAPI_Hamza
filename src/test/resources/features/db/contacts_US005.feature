Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Contacts Database Testing

    Given (contacts) SQL query is prepared and executed.
    When (contacts) is verified.
    And (contacts) SQL Delete query is prepared and executed.
    Then (contacts) SQL Delete query is verified.
    Then Database connection is terminated.

