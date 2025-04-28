package stepdefinitions;
import config_Requirements.ConfigLoader;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import pojos.HolidayUpdatePojo;
import utilities.API_Utilities.API_Methods;
import utilities.API_Utilities.TestDatas.TestDataSezgin;

import java.util.HashMap;
import java.util.Map;


public class US_02_03_04_05_06_Stepdefinition {


    Response response;
    JsonPath jsonPath ;
    TestDataSezgin testDataSezgin = new TestDataSezgin();
    Map<String, Object> requestBody1;
    ConfigLoader configLoader = new ConfigLoader();
    JSONObject jsonObject;
    HolidayUpdatePojo holidayUpdatePojoRequest;

    @Given("The api user validates the contents of the customersDetails data  {string}, {string}, {string}.")
    public void the_api_user_validates_the_contents_of_the_holiday_details_data(String first_name, String lastName, String email) {

        API_Methods.assertBody("user.first_name",first_name);
        API_Methods.assertBody("user.last_name",lastName);
        API_Methods.assertBody("user.email",email);
    }

    @Given("The api user validates the contents of the customersDetails data  {int}, {int}, {int}, {int}, {int}.")
    public void the_api_user_validates_the_contents_of_the_customers_details_data(Integer running_balance, Integer pending_balance, Integer total_coupon, Integer total_wishlist, Integer cancel_order) {
        API_Methods.assertBody("wallet_running_balance",running_balance);
        API_Methods.assertBody("wallet_pending_balance",pending_balance);
        API_Methods.assertBody("total_coupon",total_coupon);
        API_Methods.assertBody("total_wishlist",total_wishlist);
        API_Methods.assertBody("total_cancel_order",cancel_order);
    }

    @Given("The api user prepares a post request body to send to the api customerUserInformationUpdate endpoint.")
    public void the_api_user_prepares_a_post_request_body_to_send_to_the_api_customer_user_information_update_endpoint() {
        requestBody1 = new HashMap<>();
        requestBody1.put("old_password", "Bsc.04251234");
        requestBody1.put("password", "Bsc.042512345");
        requestBody1.put("password_confirmation", "Bsc.042512345");




    }

    @Given("The api user sends a POST request and saves the returned responsed.")
    public void the_api_user_sends_a_post_request_and_saves_the_returned_responsed() {
        API_Methods.sendRequest("POST",requestBody1);
    }


}
