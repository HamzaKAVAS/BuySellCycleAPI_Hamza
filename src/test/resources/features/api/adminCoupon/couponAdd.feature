Feature: [API_US029] As an administrator I would like to be able to create a new coupon record via API connection.

  Scenario: [API_US029 => TC_01] When a POST body with valid authorization information and required data (title, coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, is_expire, is_multiple_buy) is sent to /api/coupon/couponAdd endpoint, it should be verified that the status code returned is 201 and the message in the response body is “coupon added successfully”.

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponAdd" path parameters.
    And The api user prepares a post request body to send to the api couponAdd endpoint.
    And The api user sends a POST request and saves the returned response.
    Then The api user verifies that the status code is 201.
    Then The api user verifies that the "message" information in the response body is "coupon added successfully".

  Scenario: [API_US029 => TC_02] When a POST body containing invalid authorization information and required data (title, coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, is_expire, is_multiple_buy) is sent to /api/coupon/couponAdd endpoint, it should be verified that the status code returned is 401 and the message information in the response body is “Unauthenticated.”.

    Given The api user constructs the base url with the "invalid" token.
    And The api user sets "api/coupon/couponAdd " path parameters.
    And The api user prepares a post request body to send to the api couponAdd endpoint.
    And The api user sends a POST request and saves the returned response.
    Then The api user verifies that the status code is 401.
    Then The api user verifies that the "message" information in the response body is "Unauthenticated.".

  Scenario Outline: [API_US029 => TC_03] The API must verify that the new coupon record to be created through the API has been created. (With the added_item_id returned in the response body, the record creation can be verified by sending a GET body to the /api/coupon/couponDetails endpoint.)

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponAdd " path parameters.
    And The api user prepares a GET request body to send to the api couponDetails endpoint containing the information <id>.
    And The api user sends a GET request body and saves the returned response.
    Then The api user verifies that the status code is 200.

    Examples:
      | id  |
      | 254 |


