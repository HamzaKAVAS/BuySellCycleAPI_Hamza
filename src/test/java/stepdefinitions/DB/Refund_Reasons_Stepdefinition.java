package stepdefinitions.DB;

import io.cucumber.java.en.*;
import manage.hamza.Refund_reasons;

import java.sql.SQLException;

import static helperDB.JDBC_Structure_Methods.*;

public class Refund_Reasons_Stepdefinition {

    Refund_reasons refundReasons = new Refund_reasons();

    @And("\\(refund_reasons) SQL query is prepared and executed.")
    public void refund_reasons_sql_query_is_prepared_and_executed() throws SQLException {

        query = refundReasons.getRefund_reasons_select();
        resultSet = getStatement().executeQuery(query);
    }

    @Then("\\(refund_reasons) is verified.")
    public void refund_reasons_is_verified() throws SQLException {


    }
}
