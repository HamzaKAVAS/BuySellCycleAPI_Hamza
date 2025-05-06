Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Validate first 5 delivery_processes names are in expected reverse order

    Given (delivery_processes) Execute SQL query to retrieve first 5 records from delivery_processes
    When  (delivery_processes) Validate names are in reverse order: Shipped, Recieved, Processing, Pending, Delivered
    Then  Database connection is terminated.