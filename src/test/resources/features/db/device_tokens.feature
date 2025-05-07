Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Device Tokens Database Testing

    Given (device_tokens) SQL query is prepared and executed.
    When (device_tokens) 10 data entries are verified.
    Then Database connection is terminated.