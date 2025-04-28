Feature: [API_US028] As an administrator, I want to access the coupon details with the specified id number via API connection.

  Scenario Outline: [API_US028 => TC_01] When a GET request body is sent to the /api/coupon/couponDetails endpoint with valid authorization information and the coupon ID whose information will be accessed, the returned status code is 200 and the message information is "success",
  and the contents of the couponDetails data (id, title, coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, created_by, updated_by, is_expire, is_multiple_buy, multiple_buy_limit, created_at, updated_at) in the response body must be verified.

    Given The api user constructs the base url with the "admin" token.



    Examples:
      |  |