package stepdefinitions;

import config_Requirements.ConfigLoader;
import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.HolidayUpdatePojo;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.TestDatas.TestDataOguz;

import java.util.HashMap;

public class US07_08_09_10_11_API_Stepdefinitions {

    Response response;
    JsonPath jsonPath;
    String exceptionMesaj;
    ConfigLoader configLoader = new ConfigLoader();
    JSONObject jsonObject;
    HashMap requestBody;
    HolidayUpdatePojo holidayUpdatePojoRequest;
    TestDataOguz testDataOguz = new TestDataOguz();

    @Given("The api user constructs the base url with the {string} token.")
    public void the_api_user_constructs_the_base_url_with_the_token(String userType) {
        HooksAPI.setUpApi(userType);
    }

    @Given("The api user sets {string} path parameters.")
    public void the_api_user_sets_path_parameters(String pathParam) {
        API_Methods.pathParam(pathParam);
    }

    @Given("The api user sends a GET request and saves the returned response.")
    public void the_api_user_sends_a_get_request_and_saves_the_returned_response() {
        API_Methods.sendRequest("GET", null);

    }

    @Given("The api user verifies that the status code is {int}.")
    public void the_api_user_verifies_that_the_status_code_is(int code) {
        API_Methods.statusCodeAssert(code);

    }

    @Given("The api user verifies that the {string} information in the response body is {string}.")
    public void the_api_user_verifies_that_the_information_in_the_response_body_is(String key, String value) {
        API_Methods.assertBody(key, value);

    }

    @Given("The api user verifies the information in the response body for the entry with the specified {int} index, including {string} and {string}.")
    public void the_api_user_verifies_the_information_in_the_response_body_for_the_entry_with_the_specified_index_including_and(int index, String year, String name) {


    }

    @Given("The api user sends a GET request, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized.")
    public void the_api_user_sends_a_get_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized(String string) {

        try {
            API_Methods.sendRequest("GET", null);
        } catch (Exception e) {
            exceptionMesaj = e.getMessage();
        }
        System.out.println("exceptionsMesaj :" + exceptionMesaj);
        Assert.assertEquals(configLoader.getApiConfig("unauthorizedExceptionMessage"), exceptionMesaj);
    }

    @Given("The api user prepares a GET request body to send to the api holidayDetails endpoint containing the information {int}.")
    public void the_api_user_prepares_a_get_request_body_to_send_to_the_api_holiday_details_endpoint_containing_the_information(int id) {
        requestBody = testDataOguz.getBodyUS8(id);
        System.out.println("Get Body " + requestBody);

    }

    @Given("The api user sends a GET request body and saves the returned response.")
    public void the_api_user_sends_a_get_request_body_and_saves_the_returned_response() {

        API_Methods.sendRequest("GET", requestBody);
    }

    @Given("The api user validates the contents of the holidayDetails data {int}, {string}, {string}, {int}, {string}, {string} and {string} in the response body.")
    public void the_api_user_validates_the_contents_of_the_holiday_details_data_and_in_the_response_body(int id, String year, String name, int type, String date, String created_at, String updated_at) {

        API_Methods.assertBody("holidayDetails[0].id", id);
        API_Methods.assertBody("holidayDetails[0].year", year);
        API_Methods.assertBody("holidayDetails[0].name", name);
        API_Methods.assertBody("holidayDetails[0].type", type);
        API_Methods.assertBody("holidayDetails[0].date", date);
        API_Methods.assertBody("holidayDetails[0].created_at", created_at);
        API_Methods.assertBody("holidayDetails[0].updated_at", updated_at);
    }

    @Given("The api user prepares a GET request that does not contain data to the api holidayDetails endpoint.")
    public void the_api_user_prepares_a_get_request_that_does_not_contain_data_to_the_api_holiday_details_endpoint() {

        requestBody = testDataOguz.getBodyUS8_Wrong();
        System.out.println("Get Body :" + requestBody);

    }


    @Given("The api user sends a GET request, saves the returned response, and verifies that the status code is {int} with the reason phrase Not Found.")
    public void the_api_user_sends_a_get_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_not_found(int code) {

        try {
            API_Methods.sendRequest("GET", requestBody);
            API_Methods.assertBody("message", "holiday not found");
            API_Methods.statusCodeAssert(code);
        } catch (Exception e) {
            exceptionMesaj = e.getMessage();
        }
        System.out.println("exceptionsMesaj :" + exceptionMesaj);
        Assert.assertEquals(configLoader.getApiConfig("notFoundExceptionMessage"), exceptionMesaj);

    }

    @Given("The api user sends a GET request body, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized.")
    public void the_api_user_sends_a_get_request_body_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized(String string) {

    }

    @Given("The api user prepares a post request body to send to the api holidayAdd endpoint.")
    public void the_api_user_prepares_a_post_request_body_to_send_to_the_api_holiday_add_endpoint() {
        requestBody = testDataOguz.holidayAdd();
        System.out.println("Post Body :" + requestBody);
    }

    @Given("The api user sends a POST request and saves the returned response.")
    public void the_api_user_sends_a_post_request_and_saves_the_returned_response() {

        API_Methods.sendRequest("POST",requestBody);
    }

    @Given("The api user prepares a post request body containing the holiday data registered in the system to send to the api holidayAdd endpoint.")
    public void the_api_user_prepares_a_post_request_body_containing_the_holiday_data_registered_in_the_system_to_send_to_the_api_holiday_add_endpoint() {

        requestBody=testDataOguz.holidaySistemeKayitli();

    }

    @Given("The api user prepares a patch request body to send to the api holidayUpdate endpoint.")
    public void the_api_user_prepares_a_patch_request_body_to_send_to_the_api_holiday_update_endpoint() {

    }

    @Given("The api user sends a PATCH request and saves the returned response.")
    public void the_api_user_sends_a_patch_request_and_saves_the_returned_response() {

    }

    @Given("The api user verifies that the updated id information in the response body is the same as the id path parameter written in the endpoint.")
    public void the_api_user_verifies_that_the_updated_id_information_in_the_response_body_is_the_same_as_the_id_path_parameter_written_in_the_endpoint() {

    }

    @Given("The api user prepares a patch request body that matches previous records to send to the api holidayUpdate endpoint.")
    public void the_api_user_prepares_a_patch_request_body_that_matches_previous_records_to_send_to_the_api_holiday_update_endpoint() {

    }

    @Given("The api user sends a PATCH request, saves the returned response, and verifies that the status code is {string} with the reason phrase Bad Request.")
    public void the_api_user_sends_a_patch_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_bad_request(String string) {

    }

    @Given("The api user sends a PATCH request, saves the returned response, and verifies that the status code is {string} with the reason phrase Not Found.")
    public void the_api_user_sends_a_patch_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_not_found(String string) {

    }

    @Given("The api user sends a PATCH request, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized.")
    public void the_api_user_sends_a_patch_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized(String string) {

    }


    @Given("The api user name verifies that it is {string}")
    public void the_api_user_name_verifies_that_it_is(String name) {

    }

    @Given("The api user prepares a Delete request body to send to the api holidayDelete endpoint.")
    public void the_api_user_prepares_a_delete_request_body_to_send_to_the_api_holiday_delete_endpoint() {

    }

    @Given("The api user sends a DELETE request and saves the returned response.")
    public void the_api_user_sends_a_delete_request_and_saves_the_returned_response() {

    }

    @Given("The api user verifies that the Deleted id information in the response body is the same as the id information in the request body.")
    public void the_api_user_verifies_that_the_deleted_id_information_in_the_response_body_is_the_same_as_the_id_information_in_the_request_body() {

    }

    @Given("The api user sends a DELETE request, saves the returned response, and verifies that the status code is {string} with the reason phrase Unauthorized.")
    public void the_api_user_sends_a_delete_request_saves_the_returned_response_and_verifies_that_the_status_code_is_with_the_reason_phrase_unauthorized(String string) {

    }

}