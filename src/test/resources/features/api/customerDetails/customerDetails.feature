Feature: US_02 As a customer, I should be able to access detailed information about the customer logging into the system via API connection.


  Scenario Outline: Verify 200 status and "success" message with valid token on /api/customerGetUser
    * The api user constructs the base url with the "customer" token.
    # Api kullanicisi "customer" token ile base urli olusturur
    * The api user sets "api/customerGetUser" path parameters.
    # Api kullanicisi "api/customerGetUser" path parametrelerini olusturur
    * The api user sends a GET request and saves the returned response.
    # Api kullanicisi GET request gonderir ve donen responsei kaydeder
    * The api user verifies that the status code is 200.
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the "message" information in the response body is "success".
    # Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * The api user validates the contents of the customersDetails data  "<first_name>", "<last_name>", "<email>".
    # Api kullanicisi response bodydeki customerDetails datalarının "<first_name>", "<last_name>", "<email>" içeriklerini doğrular.

    Examples:
      | first_name | last_name | email                      |
      | Oğuzhan    | Güçlü     | customer.oguzhan@gmail.com |



    Scenario: Ensure 401 status and "Unauthenticated." message when using invalid token
      * The api user constructs the base url with the "invalid" token.
      # Api kullanicisi "invalid" token ile base urli olusturur
      * The api user sets "api/customerGetUser" path parameters.
      # Api kullanicisi "api/customerGetUser" path parametrelerini olusturur
      * The api user sends a GET request and saves the returned response.
      # Api kullanicisi GET request gonderir ve donen responsei kaydeder
      * The api user verifies that the status code is 401.
      # Api kullanicisi status codeun 401 oldugunu dogrular
      * The api user verifies that the "message" information in the response body is "Unauthenticated.".
      # Api kullanicisi response bodydeki message bilgisinin "Unauthenticated." oldugunu dogrular

