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
import utilities.API_Utilities.TestDatas.TestDataHamza;

import java.util.HashMap;

public class US27_28_29_30_31_Stepdefinitions {

    Response response;
    JsonPath jsonPath;
    String exceptionMesaj;
    ConfigLoader configLoader = new ConfigLoader();
    JSONObject jsonObject;
    TestDataHamza testDataHamza = new TestDataHamza();
    HashMap requestBody;

    @Then("The api user verifies the information in the response body for the entry with the specified {int} index, including {string},{string},{string} and {string}.")
    public void theApiUserVerifiesTheInformationInTheResponseBodyForTheEntryWithTheSpecifiedIdIncludingAnd(int index, String title, String coupon_code, String start_date, String end_date) {
        API_Methods.assertBody("coupons[" + index + "].title", title);
        API_Methods.assertBody("coupons[" + index + "].coupon_code", coupon_code);
        API_Methods.assertBody("coupons[" + index + "].start_date", start_date);
        API_Methods.assertBody("coupons[" + index + "].end_date", end_date);
    }

    @And("The api user prepares a GET request body to send to the api couponDetails endpoint containing the information {int}.")
    public void theApiUserPreparesAGETRequestBodyToSendToTheApiCouponDetailsEndpointContainingTheInformationId(int id) {
        requestBody = testDataHamza.getBodyUS28(id);
        System.out.println("Get Body " + requestBody);
    }

    @Then("The api user validates the contents of the couponDetails data {int}, {string}, {string}, {int},{string},{string},{int},{int},{int},{string},{int},{string},{int},{int},{string},{string} and {string} in the response body.")
    public void theApiUserValidatesTheContentsOfTheCouponDetailsDataIdCoupon_typeDiscountDiscount_typeMinimum_shoppingCreated_byIs_expireIs_multiple_buyAndInTheResponseBody(int id,String title, String coupon_code,int coupon_type,String start_date, String end_date,int discount,int discount_type,int minimum_shopping ,String maximum_discount,int created_by ,String updated_by,int is_expire,int is_multiple_buy, String multiple_buy_limit, String created_at, String updated_at) {
        API_Methods.assertBody("couponDetails[0].id", id);
        API_Methods.assertBody("couponDetails[0].title", title);
        API_Methods.assertBody("couponDetails[0].coupon_code", coupon_code);
        API_Methods.assertBody("couponDetails[0].coupon_type", coupon_type);
        API_Methods.assertBody("couponDetails[0].start_date", start_date);
        API_Methods.assertBody("couponDetails[0].end_date", end_date);
        API_Methods.assertBody("couponDetails[0].discount", discount);
        API_Methods.assertBody("couponDetails[0].discount_type", discount_type);
        API_Methods.assertBody("couponDetails[0].minimum_shopping", minimum_shopping);
        API_Methods.assertBody("couponDetails[0].maximum_discount", maximum_discount);
        API_Methods.assertBody("couponDetails[0].created_by", created_by);
        API_Methods.assertBody("couponDetails[0].updated_by", updated_by);
        API_Methods.assertBody("couponDetails[0].is_expire", is_expire);
        API_Methods.assertBody("couponDetails[0].is_multiple_buy", is_multiple_buy);
        API_Methods.assertBody("couponDetails[0].multiple_buy_limit", multiple_buy_limit);
        API_Methods.assertBody("couponDetails[0].created_at", created_at);
        API_Methods.assertBody("couponDetails[0].updated_at", updated_at);
    }

}
