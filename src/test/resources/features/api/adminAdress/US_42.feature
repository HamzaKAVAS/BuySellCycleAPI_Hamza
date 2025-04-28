Feature: As an administrator, I want to add a new address for a customer using the API.

  Scenario: TC-1 Successfully add an address with valid authorization and valid data

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressAdd" path parameters.
    * The api user prepares a POST request body with the following valid fields:
      | customer_id  |
      | name         |
      | email        |
      | address      |
      | phone        |
      | city         |
      | state        |
      | country      |
      | postal_code  |
      | address_type |



    * The api user sends the POST request and saves the response
    * The api user verifies that the status code is 404.
    * The api user verifies that the "message" information in the response body is "address added successfully".

  Scenario: TC-2 Invalid email format is provided in the POST body, Add address with invalid email format (missing "@") should fail
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressAdd" path parameters.
    * The api user prepares a POST request body where the "email" field does not contain "@"
    * The api user sends the POST request and saves the response
    * The api user verifies that the status code is 404.
    * The api user verifies that the "message" information in the response body is "The email must be a valid email address.".


  Scenario: TC-3 POST request is sent without any data,Add address with missing data should return validation error
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressAdd" path parameters.
    * The api user sends an empty POST request (no data provided)
    * The api user saves the response
    * The api user verifies that the status code is 404.
    * The api user verifies that the "message" information in the response body is "The name field is required. (and 6 more errors)".


  Scenario: TC-4 Add address with invalid authorization token, Add address with invalid token should return Unauthenticated
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressAdd" path parameters.
    * The api user prepares a POST request body with all required fields
    * The api user sends the POST request and saves the response
    * The api user verifies that the status code is 404.
    * The api user verifies that the "message" information in the response body is "Unauthenticated".


  Scenario: TC-5 Verify that the address was successfully created using the returned ,Verify the newly created address using addressDetails endpoint
    * The api user retrieves the "added_item_id" from the addressAdd response
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressAdd" path parameters.
    * The api user prepares a GET request body with the "added_item_id"
    * The api user sends a GET request and saves the returned response.
    * The api user verifies that the status code is 200.
    * The api user verifies that the "message" information in the response body is "success".
    * The api user verifies that the returned address details match the originally sent data








