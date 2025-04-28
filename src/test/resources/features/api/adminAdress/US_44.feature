Feature: As an administrator, I want to be able to delete a customer's address by using the API with the address ID.

  Scenario:TC-1 Successfully deleting an address, Deleting an address with valid authorization and address ID
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/deleteAddress" path parameters.
    * The API user sends a DELETE request with a valid address ID
    * The api user verifies that the status code is 202.
    * The api user verifies that the "message" information in the response body is "address deleted successfully".



  Scenario:TC-2 Sending a DELETE request without address ID
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/deleteAddress" path parameters.
    * The API user sends a DELETE request without an address ID
    * The api user verifies that the status code is 422.
    * The api user verifies that the "message" information in the response body is "The id field is required.".




  Scenario:TC-3 Sending a DELETE request with a non-existent address ID
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/deleteAddress" path parameters.
    * The API user sends a DELETE request with a non-existent address ID
    * The api user verifies that the status code is 404.
    * The api user verifies that the "message" information in the response body is "address not found".



  Scenario:TC-4 Sending a DELETE request with invalid authorization
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/deleteAddress" path parameters.
    * The API user sends a DELETE request with a valid address ID
    * The api user verifies that the status code is 401.
    * The api user verifies that the "message" information in the response body is "Unauthenticated.".
