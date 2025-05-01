package stepdefinitions.DB;

import helperDB.JDBC_Structure_Methods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import manage.Yelda.Coupon_Products;
import org.junit.Assert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Coupon_ProductsStep {

    Coupon_Products coupon_products = new Coupon_Products();
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    @Given("\\(coupon_products) SQL query is prepared and executed.")
    public void coupon_products_sql_query_is_prepared_and_executed() throws SQLException {

        query=coupon_products.getCoupon_products();
        preparedStatement = JDBC_Structure_Methods.getPraperedStatement(query);
        resultSet = preparedStatement.executeQuery();

    }
    @When("\\(coupon_products) is verified.")
    public void coupon_products_is_verified() throws SQLException {
        System.out.println("Kuponlara ait ürün sayıları:");
        boolean found = false;

        while (resultSet.next()) {
            found = true;
            int couponId = resultSet.getInt("coupon_id");
            int productCount = resultSet.getInt("product_count");

            System.out.println("coupon ID: " + couponId + " | Ürün Sayısı: " + productCount);
            Assert.assertTrue("Ürün sayısı negatif olamaz!", productCount >= 0);
        }

        Assert.assertTrue("Hiç kupon verisi bulunamadı!", found);

    }
}
