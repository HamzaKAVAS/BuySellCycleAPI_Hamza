package stepdefinitions;

import config_Requirements.ConfigLoader;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pojos.AdressUpdatePojo;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.TestDatas.TestDataYelda;

import java.util.HashMap;
import java.util.Map;

public class US_40_41_42_43_44_API_Stepdefinitions {

    HashMap<String, Object> requestBody;
    TestDataYelda testdataYelda = new TestDataYelda();
    String exceptionMesaj;
    ConfigLoader configLoader = new ConfigLoader();
    AdressUpdatePojo adressUpdatePojoRequest = new AdressUpdatePojo();

    @Given("The api user verifies the information in the response body for the entry with the specified {int} index, including: {int}, {int}, {string},{string}, {string}, {string}, {string}, {string}, {string}, {string}.")
    public void the_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified_index_including(int index, int id,int customer_id, String name, String email, String phone, String address, String city, String state, String country, String postal_code) {

        API_Methods.assertBody("addresses [" + index + "].id", id);
        API_Methods.assertBody("addresses [" + index + "].customer_id", customer_id);
        API_Methods.assertBody("addresses [" + index + "].name", name);
        API_Methods.assertBody("addresses [" + index + "].email", email);
        API_Methods.assertBody("addresses [" + index + "].phone", phone);
        API_Methods.assertBody("addresses [" + index + "].address", address);
        API_Methods.assertBody("addresses [" + index + "].city", city);
        API_Methods.assertBody("addresses [" + index + "].state", state);
        API_Methods.assertBody("addresses [" + index + "].country", country);
        API_Methods.assertBody("addresses [" + index + "].postal_code", postal_code);


    }
    @Given("The api user prepares a GET request body to send to the api addressDetails endpoint containing the information {int}.")
    public void the_api_user_prepares_a_get_request_body_to_send_to_the_api_address_details_endpoint_containing_the_information(int id) {

        requestBody= testdataYelda.AdressAdmin();
        System.out.println("get Body = " + requestBody);

        API_Methods.sendRequest("GET", requestBody);
    }

    @Given("The api user verifies the information in the response body for the entry with the specified {int} index, including: {int}, {int}, {string},{string}.")
    public void the_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified_index_including(int dataIndex, int is_shipping_default, int is_billing_default, String created_at, String updated_at) {

        API_Methods.assertBody("addresses [" + dataIndex + "].is_shipping_default", is_shipping_default);
        API_Methods.assertBody("addresses [" + dataIndex + "].is_billing_default", is_billing_default);
        API_Methods.assertBody("addresses [" + dataIndex + "].created_at", created_at);
        API_Methods.assertBody("addresses [" + dataIndex + "].updated_at", updated_at);
    }

    @Given("The api user prepares a POST request body with the following valid fields:")
    public void the_api_user_prepares_a_post_request_body_with_the_following_valid_fields(io.cucumber.datatable.DataTable dataTable) {

        requestBody= testdataYelda.AdressAdminPost();
        System.out.println("Post Body = " + requestBody);
    }

    @Given("The api user sends the POST request and saves the response")
    public void the_api_user_sends_the_post_request_and_saves_the_response() {

        API_Methods.sendRequest("POST", requestBody);

    }
    @Given("The api user prepares a POST request body where the {string} field does not contain {string}")
    public void the_api_user_prepares_a_post_request_body_where_the_field_does_not_contain(String string, String string2) {

        requestBody= testdataYelda.AdressAdminPost422();
        System.out.println("Post Body = " + requestBody);

    }

    @Given("The api user sends an empty POST request \\(no data provided)")
    public void the_api_user_sends_an_empty_post_request_no_data_provided() {

        requestBody= testdataYelda.AdressAdminPostNoData();
        System.out.println("Post Body = " + requestBody);

    }
    @Given("The api user prepares a POST request body with all required fields")
    public void the_api_user_prepares_a_post_request_body_with_all_required_fields() {

        try {
            requestBody= testdataYelda.AdressAdminPost();
        } catch (Exception e) {
            exceptionMesaj = e.getMessage();
        }
        System.out.println("exceptionMesaj : " + exceptionMesaj);
        Assert.assertEquals(configLoader.getApiConfig("unauthorizedExceptionMessage"), exceptionMesaj);
    }

    @Given("The api user creates a GET request with {int} for the addressDetails endpoint.")
    public void the_api_user_creates_a_get_request_with_for_the_address_details_endpoint(int id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        API_Methods.sendRequest("GET", params);

    }

    @Given("The API user prepares a PATCH request body send to thr api addressUpdate endpoint.")
    public void the_api_user_prepares_a_patch_request_body_send_to_thr_api_address_update_endpoint() {

        Map<String, Object> requestBody = testdataYelda.AdressAdminPatch();

        // Sadece gerekli alanları değiştir
        requestBody.put("name", "Doga");         // Yeni isim buraya
        requestBody.put("phone", "5551224785");      // Yeni telefon buraya

        // Body kontrolü (loglama)
        System.out.println("Güncellenmiş PATCH Request Body: " + requestBody);

        // PATCH isteğini gönder
        API_Methods.sendRequest("PATCH", requestBody);
    }

    @Given("The API user prepares a valid PATCH request body with correct fields")
    public void the_api_user_prepares_a_valid_patch_request_body_with_correct_fields() {


        try {
            requestBody= testdataYelda.AdressAdminPatch();
        } catch (Exception e) {
            exceptionMesaj = e.getMessage();
        }
        System.out.println("exceptionMesaj : " + exceptionMesaj);
        Assert.assertEquals(configLoader.getApiConfig("notFoundExceptionMessage"), exceptionMesaj);

    }

    @Given("The API user prepares a PATCH request body with incorrect customer_id")
    public void the_api_user_prepares_a_patch_request_body_with_incorrect_customer_id() {

        Map<String, Object> requestBody = testdataYelda.AdressAdminPatchIncorrect();
        API_Methods.sendRequest("PATCH", requestBody);

    }

    @Given("The API user prepares a PATCH request body with an email that does not include {string}")
    public void the_api_user_prepares_a_patch_request_body_with_an_email_that_does_not_include(String string) {

        Map<String, Object> requestBody = testdataYelda.AdressAdminPatch();

        // Sadece gerekli alanları değiştir
        requestBody.put("email", "Dorukbuysellcycle.com");

        // Body kontrolü (loglama)
        System.out.println("Güncellenmiş PATCH Request Body: " + requestBody);

        // PATCH isteğini gönder
        API_Methods.sendRequest("PATCH", requestBody);

    }

    @Given("The API user sends a PATCH request with an empty body")
    public void the_api_user_sends_a_patch_request_with_an_empty_body() {

        Map<String, Object> emptyBody = new HashMap<>(); // tamamen boş
        System.out.println("Boş PATCH Request Body: " + emptyBody);
        API_Methods.sendRequest("PATCH", emptyBody);

    }

    @Given("The api user sends a PATCH request, saves the returned response and verifies that the status code is {string} with the reason phrase Unauthorized.")
    public void the_api_user_sends_a_patch_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized(String string) {

        Map<String, Object> requestBody = new HashMap<>();

        try {
            API_Methods.sendRequest("PATCH", requestBody);
        } catch (Exception e) {
            exceptionMesaj = e.getMessage(); // burada hata mesajını alıyorsun
        }

        System.out.println("exceptionMesaj : " + exceptionMesaj);

        Assert.assertEquals(
                configLoader.getApiConfig("unauthorizedExceptionMessage"), // → "status code: 401, reason phrase: Unauthorized"
                exceptionMesaj
        );

    }






















    @Given("The API user sends a DELETE request with a valid address ID")
    public void the_api_user_sends_a_delete_request_with_a_valid_address_id() {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 547);
        System.out.println("Delete Body : " + requestBody);
        API_Methods.sendRequest("DELETE", requestBody);

    }
    @Given("The API user sends a DELETE request without an address ID")
    public void the_api_user_sends_a_delete_request_without_an_address_id() {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", null);
        System.out.println("Delete Body : " + requestBody);
        API_Methods.sendRequest("DELETE", requestBody);
    }
    @Given("The API user sends a DELETE request with a non-existent address ID")
    public void the_api_user_sends_a_delete_request_with_a_non_existent_address_id() {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 999);
        System.out.println("Delete Body : " + requestBody);
        API_Methods.sendRequest("DELETE", requestBody);
    }

}








