package stepdefinitions;

import config_Requirements.ConfigLoader;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

public class US27_28_29_30_31_Stepdefinitions {

    Response response;
    JsonPath jsonPath;
    String exceptionMesaj;
    ConfigLoader configLoader = new ConfigLoader();
    JSONObject jsonObject;
    HashMap requestBody;


    @Then("The api user verifies the information in the response body for the entry with the specified {string} id, including {string},{string},{string} ve {string}.")
    public void theApiUserVerifiesTheInformationInTheResponseBodyForTheEntryWithTheSpecifiedIdIncludingVe(String arg0, String arg1, String arg2, String arg3, String arg4) {
    }
}
