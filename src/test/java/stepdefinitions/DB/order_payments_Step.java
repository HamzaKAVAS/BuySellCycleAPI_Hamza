package stepdefinitions.DB;

import helperDB.JDBC_Structure_Methods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manage.Oguz.Order_payments;
import org.junit.Assert;
import utilities.DB_Utilities.JDBCMethods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helperDB.JDBC_Structure_Methods.*;


public class order_payments_Step {

    Order_payments orderPayments=new Order_payments();

    @Given("Database connection established")
    public void database_connection_established() {

        JDBC_Structure_Methods.createConnection();


    }

    @Given("\\(order_payments) SQL query is prepared and executed.")
    public void order_payments_sql_query_is_prepared_and_executed() throws SQLException {

        query = orderPayments.getOrder_payments_select();
        resultSet = getStatement().executeQuery(query);
    }

    @When("\\(order_payments) is verified.")
    public void order_payments_is_verified() throws SQLException {


        // expected result list olusturma kismi
        List<Double> expectedResultList = new ArrayList<>();
        expectedResultList.add(23125.00);
        expectedResultList.add(23125.00);
        expectedResultList.add(18850.00);
        expectedResultList.add(15430.00);
        expectedResultList.add(15190.00);
        expectedResultList.add(13720.00);
        expectedResultList.add(10300.00);
        expectedResultList.add(9490.45);
        expectedResultList.add(9445.00);
        expectedResultList.add(9445.00);
        expectedResultList.add(9445.00);
        expectedResultList.add(9445.00);

     // expected listeyi büyükten küçüğe sıralama
        Collections.sort(expectedResultList, Collections.reverseOrder());

        System.out.println("Expected Result List : ");
        JDBCMethods.ListeyiYazdirmaMethodu(expectedResultList);

      // actual result list olusturma kismi
        List<Double> actualResultList = new ArrayList<>();
        while (resultSet.next()) {
            actualResultList.add(resultSet.getDouble(2));
        }
        System.out.println("Actual Result List : ");
        JDBCMethods.ListeyiYazdirmaMethodu(actualResultList);

        Assert.assertEquals(expectedResultList,actualResultList);


    }

    @Then("Database connection is terminated.")
    public void database_connection_is_terminated() {

        JDBC_Structure_Methods.closeConnection();


    }

}
