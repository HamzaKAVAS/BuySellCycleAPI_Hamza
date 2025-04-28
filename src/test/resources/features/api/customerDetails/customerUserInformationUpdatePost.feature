Feature: US_04 As a customer I should be able to edit my user information via API connection.

  @Test1
  Scenario: Verify password change works with correct old and new password

    * The api user constructs the base url with the "customer" token.
    # API kullanıcısı "customer" token ile base URL'i oluşturur
    * The api user sets "api/change-password" path parameters.
    # API kullanıcısı "api/change-password" path parametrelerini oluşturur
    * The api user prepares a post request body to send to the api customerUserInformationUpdate endpoint.
    # API kullanıcısı "change-password" endpointine göndermek için bir POST request body hazırlar
    * The api user sends a POST request and saves the returned responsed.
    # API kullanıcısı POST request gönderir ve dönen response'ı kaydeder
    * The api user verifies that the status code is 200.
    # API kullanıcısı status code'un 200 olduğunu doğrular
    * The api user verifies that the "message" information in the response body is "password change successfully".
    # API kullanıcısı response body'deki "message" bilgisinin "Password changed successfully" olduğunu doğrular


