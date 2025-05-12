Feature: In the orders table, list the data that does not contain "customer" in customer_email data and whose sub_total is less than 2000 in reverse order of "order_number".

  Background: Database connectivity
    Given Database connection established

  Scenario: In the orders table, list the data that does not contain "customer" in customer_email data and whose sub_total is less than 2000 in reverse order of "order_number".
    When a SQL query is prepared on the Orders table.
    Then SQL query is executed on the Orders table and the data is listed.
    Then Database connection is terminated.