package stepdefinitions;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.API_Utilities.API_Methods;


public class US_02_03_04_05_06_Stepdefinition {


    Response response;
    JsonPath jsonPath ;

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

}
