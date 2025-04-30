Feature: [API_US030] As an administrator, I want to be able to update coupon information with the specified id number via API connection.

  Scenario: [API_US030 => TC_01] When a PATCH request body containing the coupon id to be updated with valid authorization information and
  the required data (title, coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, is_expire, is_multiple_buy)
  is sent to the /api/coupon/couponUpdate/{id} endpoint, it must be verified that the returned status code is 202 and
  the message information in the response body is "coupon updated successfully".

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponUpdate/229" path parameters.
    And The api user prepares a patch request body to send to the api couponUpdate endpoint.
    And The api user sends a PATCH request and saves the returned response.
    Then The api user verifies that the status code is 202.
    Then The api user verifies that the "message" information in the response body is "coupon updated successfully".

  Scenario: [API_US030 => TC_02] When a PATCH body containing the coupon id to be updated with valid authorization information and holiday data
  (title, coupon_code, coupon_type, start_date, end_date, discount) matching previous records is sent to the /api/coupon/couponUpdate/{id} endpoint, it should be verified that
  the returned status code is 400 and the message information in the response body is "duplicate coupon request".

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponUpdate/230" path parameters.
    And The api user prepares a patch request body that matches previous records to send to the api couponUpdate endpoint.
    Then The api user sends a PATCH request, saves the returned response, and verifies that the status code is '400' with the reason phrase Bad Request.

  Scenario: [API_US030 => TC_03] When a PATCH request body (title, coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, is_expire, is_multiple_buy)
  containing valid authorization information and an incorrect (non-existent) coupon id is sent to the /api/coupon/couponUpdate/{id} endpoint,
  it should be verified that the returned status code is 404 and the message information in the response body is "coupon not found".

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponUpdate/5789" path parameters.
    And The api user prepares a patch request body to send to the api couponUpdate endpoint.
    Then The api user sends a PATCH request, saves the returned response, and verifies that the status code is '404' with the reason phrase Not Found.

  Scenario: [API_US030 => TC_04] When a PATCH request body is sent to the endpoint /api/coupon/couponUpdate/{id} containing
  the coupon id to be updated with invalid authorization information and the required data (title, coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, is_expire, is_multiple_buy),
  the status code returned is 401 and the message in the response body is “Unauthenticated. “ should be verified.

    Given The api user constructs the base url with the "invalid" token.
    And The api user sets "api/holidayUpdate/229" path parameters.
    And The api user prepares a patch request body to send to the api couponUpdate endpoint.
    Then The api user sends a PATCH request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized.






