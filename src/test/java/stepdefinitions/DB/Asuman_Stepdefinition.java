package stepdefinitions.DB;

import helperDB.JDBC_Structure_Methods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static helperDB.JDBC_Structure_Methods.*;
import static org.junit.Assert.assertTrue;

public class Asuman_Stepdefinition {


    public Asuman_Stepdefinition() throws SQLException {
    }


    @When("A query is prepared to calculate the sum of amount where type is 'Referral' and id between 10 and 20 in wallet_balances")
    public void runSumQuery() throws SQLException {
        String query = "SELECT SUM(amount) AS total_amount FROM wallet_balances WHERE type = 'Referral' AND id BETWEEN 10 AND 20";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
    }

    @Then("The total amount result should be {double}")
    public void verifyTotalAmount(double expectedAmount) throws SQLException {
        if (resultSet.next()) {
            double actualAmount = resultSet.getDouble("total_amount");
            Assert.assertEquals(expectedAmount, actualAmount, 0.001);
        }

    }


    @When("a query is prepared to list unique note values grouped by day from attendances table")
    public void query_for_unique_notes_by_day() throws SQLException {
        String query = """
        SELECT 
            DATE(created_at) AS day, 
            GROUP_CONCAT(DISTINCT note ORDER BY note SEPARATOR ', ') AS unique_notes 
        FROM attendances 
        GROUP BY DATE(created_at)
    """;

        if (JDBC_Structure_Methods.statement == null) {
            JDBC_Structure_Methods.statement = JDBC_Structure_Methods.connection.createStatement();
        }

        JDBC_Structure_Methods.resultSet = JDBC_Structure_Methods.statement.executeQuery(query);
    }

    @Then("the query should return distinct note values for each day")
    public void validate_unique_notes_per_day() throws SQLException {
        while (resultSet.next()) {
            String day = resultSet.getString("day");
            String notes = resultSet.getString("unique_notes");

            System.out.println("Day: " + day + " -> Notes: " + notes);
            // Basit doğrulama: boş değil mi?
            assert notes != null && !notes.isEmpty() : "Notes should not be empty for day: " + day;
        }
    }

    // Step 2: Execute the query to retrieve data
    @When("a query is executed to retrieve bank accounts with opening balance less than 0 for {string}")
    public void whenAQueryIsExecuted(String bankName) throws SQLException {
        // SQL sorgusunu hazırlama
        String query = "SELECT bank_name, opening_balance FROM bank_accounts WHERE bank_name = ? AND opening_balance < 0";

        // PreparedStatement kullanarak parametreli sorgu çalıştırma
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, bankName);  // Parametre olarak banka adı

        resultSet = preparedStatement.executeQuery();
    }

    // Step 3: Validate the result
    @Then("the result should include {string} with a negative opening balance")
    public void thenTheResultShouldIncludeWithANegativeOpeningBalance(String bankName) throws SQLException {
        boolean isBankFound = false;

        // Sonuçları kontrol etme
        while (resultSet.next()) {
            String bank = resultSet.getString("bank_name");
            double openingBalance = resultSet.getDouble("opening_balance");

            // Bankanın adı ve opening_balance kontrolü
            if (bank.equals(bankName) && openingBalance < 0) {
                isBankFound = true;
                break;
            }
        }

        // Sonuçları doğrulama
        assertTrue("Bank account with negative opening balance not found for " + bankName, isBankFound);
    }


}