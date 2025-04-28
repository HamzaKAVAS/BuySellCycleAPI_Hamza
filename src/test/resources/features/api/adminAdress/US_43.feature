Feature: As an administrator, I want to update an existing customer address using the specified address ID via API.

  Scenario: TC-1 Successfully updating an address with valid token, valid address ID, and correct customer_id
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressUpdate/{id}" path parameters.
    * The API user prepares a PATCH request body including:
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
    * The API user sends the PATCH request and saves the response
    * The api user verifies that the status code is 202.
    * The api user verifies that the "message" information in the response body is "address updated successfully".


  Scenario: TC-2 Updating with a non-existent address ID should return 404

    * The api user constructs the base url with the "admin" token.
    * The API user sets the "api/profile/addressUpdate/{id}" path with an invalid address ID
    * The API user prepares a valid PATCH request body with correct fields
    * The API user sends the PATCH request and saves the response
    * The api user verifies that the status code is 404.
    * The api user verifies that the "message" information in the response body is "address not found".


  Scenario: TC-3 Updating with incorrect customer_id for a valid address ID should return 404

    * The api user constructs the base url with the "admin" token.
    * The API user sets the "api/profile/addressUpdate/{id}" path with a valid address ID
    * The API user prepares a PATCH request body with incorrect customer_id
    * The API user sends the PATCH request and saves the response
    * The api user verifies that the status code is 404.
    * The api user verifies that the "message" information in the response body is "address not found".



  Scenario: TC-4 Updating with invalid email format should return 422
    * The api user constructs the base url with the "admin" token.
    * The API user sets the "api/profile/addressUpdate/{id}" path with a valid address ID
    * The API user prepares a PATCH request body with an email that does not include "@"
    * The API user sends the PATCH request and saves the response
    * The api user verifies that the status code is 422.
    * The api user verifies that the "message" information in the response body is "The email must be a valid email address.".



  Scenario: TC-5 Sending a PATCH request without any data should return 422

    * The api user constructs the base url with the "admin" token.
    * The API user sets the "api/profile/addressUpdate/{id}" path with a valid address ID
    * The API user sends a PATCH request with an empty body
    * The api user verifies that the status code is 422.
    * The api user verifies that the "message" information in the response body is "The name field is required. (and 6 more errors)".



  Scenario: TC-6 Updating with invalid token should return 401
    * The API user constructs the base URL with an invalid token
    * The API user sets the "api/profile/addressUpdate/{id}" path with a valid address ID
    * The API user prepares a PATCH request body with valid data including correct customer_id
    * The API user sends the PATCH request and saves the response
    * The api user verifies that the status code is 401.
    * The api user verifies that the "message" information in the response body is "Unauthenticated".


  Scenario: TC-7 The updated_id in the response body should match the path parameter ID

    * The api user constructs the base url with the "admin" token.
    * The API user sets the "api/profile/addressUpdate/{id}" path with a valid address ID
    * The API user prepares a valid PATCH request body
    * The API user sends the PATCH request and saves the response
    * The API user verifies that the "updated_id" in the response body matches the address ID used in the path



  Scenario: TC-8 Verifying the updated data using addressDetails endpoint

    * The api user constructs the base url with the "admin" token.
    * The API user sends a GET request to "api/profile/addressDetails" with the updated_id from the previous response
    * The API user verifies that the status code is 200
    * The API user verifies that the response contains the updated address data