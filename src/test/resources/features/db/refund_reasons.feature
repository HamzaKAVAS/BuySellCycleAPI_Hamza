@RR
Feature: Database Testing

  Background: Database connectivity
    Given Database connection established

  Scenario: Refund Reasons Database Testing

    And (refund_reasons) SQL query is prepared and executed.
    Then (refund_reasons) is verified.
    And Database connection is terminated.