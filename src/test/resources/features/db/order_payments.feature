@db
Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Order Payments Database Testing

    Given (order_payments) SQL query is prepared and executed.
    When (order_payments) is verified.
    Then Database connection is terminated.

