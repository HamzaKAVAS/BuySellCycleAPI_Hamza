Feature: As an administrator, I want to access all customer addresses through the API connection.


  Scenario:TC-1 Accessing all customer addresses with valid authorization
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/allAddressList" path parameters.
    * The api user sends a GET request and saves the returned response.
    * The api user verifies that the status code is 200.
    * The api user verifies that the "message" information in the response body is "success".

    @test40
  Scenario Outline:TC-2 Verifying the address details for id(x) in the response body
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/allAddressList" path parameters.
    * The api user sends a GET request and saves the returned response.
    * The api user verifies the information in the response body for the entry with the specified <dataIndex> index, including: <id>, <customer_id>, "<name>","<email>", "<phone>", "<address>", "<city>", "<state>", "<country>", "<postal_code>".

    Examples:
      | dataIndex  | id |  customer_id | name    | email             | phone          | address         | city     | state  | country | postal_code |
      |   0        |  1  |  5          | ra_name  | ra_mail@gmail.com |0123456789123456| DE              | 18744    | 1357   | 82      | 45857       |


  Scenario:TC-3 Failing to access all customer addresses with invalid authorization
    * The api user constructs the base url with the "invalid" token.
    * The api user sets "api/profile/allAddressList" path parameters.
    * The api user sends a GET request and saves the returned response.
    * The api user verifies that the status code is 401.
    * The api user verifies that the "message" information in the response body is "Unauthenticated.".

