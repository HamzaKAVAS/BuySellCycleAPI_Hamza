Feature: As an administrator, I want to retrieve a customer's address details using the API.

  @US41
  Scenario Outline: When a GET request is sent to the /api/profile/addressDetails endpoint with valid authorization,
  it should be verified that the status code is 200, the message is 'success', and the year and name of id(x)
  in the response body are correct.

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressDetails" path parameters.
    * The api user prepares a GET request body to send to the api addressDetails endpoint containing the information <id>.
    * The api user verifies that the status code is 200.
    * The api user verifies that the "message" information in the response body is "success".
    * The api user verifies the information in the response body for the entry with the specified <dataIndex> index, including: <is_shipping_default>, <is_billing_default>, "<created_at>","<updated_at>".

    Examples:
      |dataIndex  | id | is_shipping_default | is_billing_default | created_at                  | updated_at                  |
      |0         | 1   | 0                   | 0                  | 2024-02-11T07:49:48.000000Z | 2024-03-27T11:21:10.000000Z |


  Scenario: TC-2 Send a request with valid token but without address ID
    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/profile/addressDetails" path parameters.
    * The api user sends a GET request and saves the returned response.
    * The api user verifies that the status code is 404.
    * The api user verifies that the "message" information in the response body is "address not found".


  Scenario: TC-3 Send a request with invalid token ,Unauthenticated access with invalid token
    * The api user constructs the base url with the "invalid" token.
    * The api user sets "api/profile/addressDetails" path parameters.
    #* The api user prepares a GET request body including a valid address ID.
    * The api user sends a GET request body and saves the returned response.
    * The api user verifies that the status code is 401.
    * The api user verifies that the "message" information in the response body is "Unauthenticated.".