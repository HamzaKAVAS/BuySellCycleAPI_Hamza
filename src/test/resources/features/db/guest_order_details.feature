Feature: Database Testing

  Background: Database connectivity
    * Database connection established

  Scenario: Count total orders and update shipping name in guest_order_details

    Given (guest_order_details) Execute SQL query to retrieve total number of orders
    When  (guest_order_details) Update shipping name in guest_order_details
    Then  Database connection is terminated.