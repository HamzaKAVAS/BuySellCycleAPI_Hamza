Feature: [API_US027] As an administrator I would like to be able to access coupon information via an API connection.

  Scenario Outline: [API_US027 => TC_01] When a GET request with valid authorization information is sent to the /api/coupon/couponList endpoint,
  the returned status code should be 200, the message information should be "success",
  and the id(x) information (title, coupon_code, start_date, end_date) in the response body should be verified.

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponList" path parameters.






    Examples:
      |  |