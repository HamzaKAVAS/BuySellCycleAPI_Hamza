package stepdefinitions.DB;

import helperDB.JDBC_Structure_Methods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manage.Yelda.Contacts;
import org.junit.Assert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class contacts_005_Step {

    Contacts contacts = new Contacts();
    String query;
    int rowsAffected;
    int rowsDeleted;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Given("\\(contacts) SQL query is prepared and executed.")
    public void contacts_sql_query_is_prepared_and_executed() throws SQLException {

        //query = "INSERT INTO contacts (id, name, email, query_type, message) VALUES (?, ?, ?, ?, ?)";
        query=contacts.getContacts();
        preparedStatement = JDBC_Structure_Methods.getPraperedStatement(query);

        preparedStatement.setInt(1, 156);
        preparedStatement.setString(2, "Yeldaa");
        preparedStatement.setString(3, "yeldaa@yelda");
        preparedStatement.setInt(4, 4);
        preparedStatement.setString(5, "Helloo");

        rowsAffected = preparedStatement.executeUpdate();
        System.out.println("INSERT işleminde etkilenen satır sayısı: " + rowsAffected);

    }
    @When("\\(contacts) is verified.")
    public void contacts_is_verified() throws SQLException {
        int expectedRowCount = 1;
        Assert.assertEquals(expectedRowCount, rowsAffected);

    }
    @When("\\(contacts) SQL Delete query is prepared and executed.")
    public void contacts_sql_delete_query_is_prepared_and_executed() throws SQLException {
        query = contacts.getContactsDelete();  //DELETE FROM contacts WHERE id=?;
        preparedStatement = JDBC_Structure_Methods.getPraperedStatement(query);
        preparedStatement.setInt(1, 156);
        rowsDeleted = preparedStatement.executeUpdate();
        System.out.println("DELETE işleminde etkilenen satır sayısı: " + rowsDeleted);

    }
    @Then("\\(contacts) SQL Delete query is verified.")
    public void contacts_sql_delete_query_is_verified() throws SQLException {

        String selectQuery = "SELECT * FROM contacts WHERE id = 156";
        preparedStatement = JDBC_Structure_Methods.getPraperedStatement(selectQuery);
        resultSet = preparedStatement.executeQuery();
        Assert.assertFalse("Data not found after insert!", resultSet.next());
    }





}
