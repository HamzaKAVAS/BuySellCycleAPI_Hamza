

Feature: Data Base Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Calculate sum of amount for Referral type between id 10 and 20
    When A query is prepared to calculate the sum of amount where type is 'Referral' and id between 10 and 20 in wallet_balances
    Then The total amount result should be 10.00
    Then Database connection is terminated.



