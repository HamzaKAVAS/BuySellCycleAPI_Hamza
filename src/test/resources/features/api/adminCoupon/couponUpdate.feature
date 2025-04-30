Feature: As an administrator, I want to be able to update coupon information with the specified id number via API connection.

  Scenario: When a PATCH request body containing the coupon id to be updated with valid authorization information and
  the required data (title, coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, is_expire, is_multiple_buy)
  is sent to the /api/coupon/couponUpdate/{id} endpoint, it must be verified that the returned status code is 202 and
  the message information in the response body is "coupon updated successfully".

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponUpdate/229" path parameters.
    And The api user prepares a patch request body to send to the api couponUpdate endpoint.
    And The api user sends a PATCH request and saves the returned response.
    Then The api user verifies that the status code is 202.
    Then The api user verifies that the "message" information in the response body is "coupon updated successfully".
    

