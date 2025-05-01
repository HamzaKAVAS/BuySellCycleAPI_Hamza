package stepdefinitions.DB;

import helperDB.JDBC_Structure_Methods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manage.Yelda.Digital_gift_cards;
import org.junit.Assert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Digital_gift_cards_Step {

    Digital_gift_cards digital_gift_cards = new Digital_gift_cards();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String query;
    int rowsAffected;

    @Given("\\(digital_gift_cards) SQL query is prepared and executed.")
    public void digital_gift_cards_sql_query_is_prepared_and_executed() throws SQLException {

        query = digital_gift_cards.getDigital_gift_cards();
        preparedStatement = JDBC_Structure_Methods.getPraperedStatement(query);

        preparedStatement.setInt(1,444);
        preparedStatement.setString(2,"barbie");
        preparedStatement.setString(3,"jouet");
        preparedStatement.setString(4,"https://barbie.com");
        preparedStatement.setString(5,"https://jeuxbarbie.com");
        preparedStatement.setString(6,"2025-05-02 02:02:02");
        preparedStatement.setString(7,"2025-05-10 05:05:05");

        rowsAffected = preparedStatement.executeUpdate();
        System.out.println("INSERT işleminde etkilenen satır sayısı: " + rowsAffected);
    }
    @When("\\(digital_gift_cards) is verified.")
    public void digital_gift_cards_is_verified() {

        int expectedRowCount = 1;
        Assert.assertEquals(expectedRowCount, rowsAffected);

    }
    @When("\\(digital_gift_cards) SQL Delete query is prepared and executed.")
    public void digital_gift_cards_sql_delete_query_is_prepared_and_executed() throws SQLException {

        query = digital_gift_cards.getDigital_gift_cardsDelete();
        preparedStatement = JDBC_Structure_Methods.getPraperedStatement(query);

        preparedStatement.setInt(1, 444);

        rowsAffected = preparedStatement.executeUpdate();
        System.out.println("DELETE işleminde etkilenen satır sayısı: " + rowsAffected);

    }
    @Then("\\(digital_gift_cards) SQL Delete query is verified.")
    public void digital_gift_cards_sql_delete_query_is_verified() throws SQLException {

        query = digital_gift_cards.getDigital_gift_cardsSelect();
        preparedStatement = JDBC_Structure_Methods.getPraperedStatement(query);
        preparedStatement.setInt(1, 444);
        resultSet = preparedStatement.executeQuery();

    }
}
