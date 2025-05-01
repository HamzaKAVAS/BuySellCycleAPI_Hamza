package manage.Oguz;

public class Transactions {

    // getter
    public String getTransactions_amount_value() {
        return transactions_amount_value;
    }




    private String transactions_amount_value = "SELECT payment_method, SUM(amount) AS total_amount FROM transactions GROUP BY payment_method HAVING SUM(amount) > 7000 ORDER BY total_amount DESC;\n";
}
