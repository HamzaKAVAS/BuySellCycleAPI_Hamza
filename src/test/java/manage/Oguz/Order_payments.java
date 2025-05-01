package manage.Oguz;

public class Order_payments {



    private String order_payments_select = " SELECT txn_id, MAX(amount) AS max_amount FROM order_payments WHERE txn_id != 'none' GROUP BY txn_id HAVING MAX(amount) > 9000 ORDER BY max_amount DESC ";


    // getter

    public String getOrder_payments_select() {
        return order_payments_select;
    }

}
