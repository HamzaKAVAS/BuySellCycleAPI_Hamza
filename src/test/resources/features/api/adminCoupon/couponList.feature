Feature: [API_US027] As an administrator I would like to be able to access coupon information via an API connection.

  Scenario Outline: [API_US027 => TC_01] When a GET request with valid authorization information is sent to the /api/coupon/couponList endpoint,
  the returned status code should be 200, the message information should be "success",
  and the id(x) information (title, coupon_code, start_date, end_date) in the response body should be verified.

    Given The api user constructs the base url with the "admin" token.
    And The api user sets "api/coupon/couponList" path parameters.
    And The api user sends a GET request and saves the returned response.
    Then The api user verifies that the status code is 200.
    Then The api user verifies that the "message" information in the response body is "success".
    Then The api user verifies the information in the response body for the entry with the specified <dataIndex> index, including "<title>","<coupon_code>","<start_date>" and "<end_date>".

    Examples:
      | dataIndex   | title         | coupon_code | start_date | end_date   |
      | 0           | Orderder    | ordered     | 2025-04-04 | 2025-04-30 |

  Scenario: [API_US027 => TC_02] When a GET request with invalid authorization information is sent to
  the /api/coupon/couponList endpoint, it should be verified that the status code
  returned is 401 and the message is “Unauthenticated.”.

    Given The api user constructs the base url with the "invalid" token.
    And The api user sets "api/coupon/couponList" path parameters.
    Then The api user sends a GET request, saves the returned response, and verifies that the status code is '401' with the reason phrase Unauthorized.