Feature: Data Base testing

  Background: Database connectivity
    * Database connection established

  Scenario: Retrieve unique note values grouped by day
    When a query is prepared to list unique note values grouped by day from attendances table
    Then the query should return distinct note values for each day
    Then Database connection is terminated.

