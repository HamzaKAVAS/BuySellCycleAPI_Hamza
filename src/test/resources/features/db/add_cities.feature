Feature: Add a data containing the values (id,name,state_id,status,created_at) to the cities table. verify that the data has been added from the cities table.

  Background: Database connectivity
    Given Database connection established

  Scenario: Add a data containing the values (id,name,state_id,status,created_at) to the cities table. verify that the data has been added from the cities table.
    When Add Data to Cities table query is prepared and executed on the Cities table.
    Then Verify that the data has been added to the cities table.
    Then Database connection is terminated.