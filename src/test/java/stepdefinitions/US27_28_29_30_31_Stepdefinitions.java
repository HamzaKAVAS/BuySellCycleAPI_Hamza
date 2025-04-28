package stepdefinitions;

import config_Requirements.ConfigLoader;
import hooks.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utilities.API_Utilities.API_Methods;

import java.util.HashMap;

public class US27_28_29_30_31_Stepdefinitions {

    Response response;
    JsonPath jsonPath;
    String exceptionMesaj;
    ConfigLoader configLoader = new ConfigLoader();
    JSONObject jsonObject;
    HashMap requestBody;

    @Then("The api user verifies the information in the response body for the entry with the specified {int} index, including {string},{string},{string} and {string}.")
    public void theApiUserVerifiesTheInformationInTheResponseBodyForTheEntryWithTheSpecifiedIdIncludingAnd(int index, String title, String coupon_code, String start_date, String end_date) {
        API_Methods.assertBody("coupons[" + index + "].title", title);
        API_Methods.assertBody("coupons[" + index + "].coupon_code", coupon_code);
        API_Methods.assertBody("coupons[" + index + "].start_date", start_date);
        API_Methods.assertBody("coupons[" + index + "].end_date", end_date);
    }

}
