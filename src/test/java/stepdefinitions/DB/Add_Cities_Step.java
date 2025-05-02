package stepdefinitions.DB;

import io.cucumber.java.en.When;
import manage.gulay.AddCities;

import java.sql.SQLException;

import static helperDB.JDBC_Structure_Methods.getStatement;
import static helperDB.JDBC_Structure_Methods.query;

public class Add_Cities_Step {

    AddCities add_cities = new AddCities();

    @When("Add Data to Cities table query is prepared and executed on the Cities table.")
    public void add_data_to_cities_table_query_is_prepared_and_executed_on_the_cities_table() throws SQLException {
        query = add_cities.citiesInsert();
        getStatement().executeUpdate(query);

        //statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //statement.executeUpdate(QUERY02);
    }
}
