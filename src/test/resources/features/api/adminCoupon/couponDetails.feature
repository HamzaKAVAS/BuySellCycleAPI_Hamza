Feature: [API_US028] As an administrator, I want to access the coupon details with the specified id number via API connection.

  Scenario Outline: [API_US028 => TC_01] When a GET request body is sent to the /api/coupon/couponDetails endpoint with valid authorization information and the coupon ID whose information will be accessed, the returned status code is 200 and the message information is "success",
  and the contents of the couponDetails data (id, title, coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, created_by, updated_by, is_expire, is_multiple_buy, multiple_buy_limit, created_at, updated_at) in the response body must be verified.

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponDetails" path parameters.
    And The api user prepares a GET request body to send to the api couponDetails endpoint containing the information <id>.
    And The api user sends a GET request body and saves the returned response.
    Then The api user verifies that the status code is 200.
    Then The api user verifies that the "message" information in the response body is "success".
    Then The api user validates the contents of the couponDetails data <id>, "<title>", "<coupon_code>", <coupon_type>,"<start_date>","<end_date>",<discount>,<discount_type>,<minimum_shopping>,"<maximum_discount>",<created_by>,"<updated_by>",<is_expire>,<is_multiple_buy>,"<multiple_buy_limit>","<created_at>" and "<updated_at>" in the response body.

    Examples:
      | id  | id  | title      | coupon_code | coupon_type | start_date | end_date   | discount | discount_type | minimum_shopping | maximum_discount | created_by | updated_by | is_expire | is_multiple_buy | multiple_buy_limit | created_at                  | updated_at                  |
      | 226 | 226 | April Sale | OFF10AP     | 2           | 2025-04-04 | 2025-04-30 | 10       | 0             | 200              | null             | 1          | null       | 0         | 1               | 5                  | 2025-04-04T11:27:55.000000Z | 2025-04-04T11:27:55.000000Z |

  Scenario: [API_US028 => TC_02] When a GET request with valid authorization information and no data (coupon id) is sent to the /api/coupon/couponDetails endpoint, it should be verified that the returned status code is 404 and the message information in the response body is "coupon not found".

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponDetails " path parameters.
    And The api user prepares a GET request that does not contain data to the api couponDetails endpoint.
    Then The api user sends a GET request, saves the returned response, and verifies that the status code is 404 with the reason phrase Not Found.

  Scenario Outline: [API_US028 => TC_03] When a GET body containing an incorrect (non-existent) coupon id is sent, it should be verified that the returned status code is 404 and the message information in the response body is "coupon not found".

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponDetails" path parameters.
    And The api user prepares a GET request body to send to the api couponDetails endpoint containing the information <id>.
    Then The api user sends a GET request, saves the returned response, and verifies that the status code is 404 with the reason phrase Not Found.

    Examples:
      | id   |
      | 9568 |

  Scenario Outline: [API_US028 => TC_04] When a GET request body is sent to the /api/coupon/couponDetails endpoint with invalid authorization information and the coupon id whose details are to be accessed, it should be verified that the status code returned is 401 and the message information is “Unauthenticated.”.

    Given The api user constructs the base url with the "invalid" token.
    And The api user sets "api/coupon/couponDetails" path parameters.
    And The api user prepares a GET request body to send to the api couponDetails endpoint containing the information <id>.
    Then The api user sends a GET request body, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized.

    Examples:
      | id |
      | 3  |



