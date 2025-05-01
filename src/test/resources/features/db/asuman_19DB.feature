Feature:Data Base testing

  Background: Database connectivity
    * Database connection established

  Scenario: Retrieve unique note values grouped by day
    When a query is executed to retrieve bank accounts with opening balance less than 0 for 'banka1'
    Then the result should include 'banka1' with a negative opening balance
    Then Database connection is terminated.
