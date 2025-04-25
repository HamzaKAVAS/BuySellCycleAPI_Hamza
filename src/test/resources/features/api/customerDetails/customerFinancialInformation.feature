Feature: US_03 As a customer, I should be able to access the customer's financial information through the API connection.

  @smoke
  Scenario Outline: Verify status 200 and "success" message on valid GET request to /api/profile/get-customer-data
    * The api user constructs the base url with the "customer" token.
    # Api kullanicisi "customer" token ile base urli olusturur
    * The api user sets "api/profile/get-customer-data" path parameters.
    # Api kullanicisi "api/customerGetUser" path parametrelerini olusturur
    * The api user sends a GET request and saves the returned response.
    # Api kullanicisi GET request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "success".
    # Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * The api user validates the contents of the customersDetails data  <wallet_running_balance>, <wallet_pending_balance>, <total_coupon>, <total_wishlist>, <total_cancel_order>.
    # Api kullanicisi response bodydeki customerDetails datalarının "<wallet_running_balance>", "<wallet_pending_balance>", "<email>" içeriklerini doğrular.


    Examples:
      | wallet_running_balance | wallet_pending_balance | total_coupon | total_wishlist   | total_cancel_order |
      |        200             |           0            |       0      |        12        |         0          |


  @smoke
  Scenario: Ensure 401 status and "Unauthenticated." message when using invalid token
    * The api user constructs the base url with the "invalid" token.
      # Api kullanicisi "invalid" token ile base urli olusturur
    * The api user sets "api/profile/get-customer-data" path parameters.
      # Api kullanicisi "api/customerGetUser" path parametrelerini olusturur
    * The api user sends a GET request and saves the returned response.
      # Api kullanicisi GET request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 401.
      # Api kullanicisi status codeun 401 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "Unauthenticated.".
      # Api kullanicisi response bodydeki message bilgisinin "Unauthenticated." oldugunu dogrular