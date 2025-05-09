Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Log Activity Database Testing

    Given (log_activity) SQL query is prepared and executed.
    When (log_activity) is verified.
    Then Database connection is terminated.