package stepdefinitions.DB;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import manage.Oguz.Transactions;
import org.junit.Assert;
import utilities.DB_Utilities.JDBCMethods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static helperDB.JDBC_Structure_Methods.*;

public class transactions_Step {

    Transactions transactions = new Transactions();

    @Given("\\(transactions) SQL query is prepared and executed.")
    public void transactions_sql_query_is_prepared_and_executed() throws SQLException {

        query = transactions.getTransactions_amount_value();
        resultSet = getStatement().executeQuery(query);

    }
    @When("\\(transactions) is verified.")
    public void transactions_is_verified() throws SQLException {

        // expected result list olusturma kismi
        List<Double> expectedResultList = new ArrayList<>();
        expectedResultList.add(19040237.55);
        expectedResultList.add(9555.00);

        // expected listeyi büyükten küçüğe sıralama
        Collections.sort(expectedResultList, Collections.reverseOrder());

        System.out.println("Expected Result List :");
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
}
