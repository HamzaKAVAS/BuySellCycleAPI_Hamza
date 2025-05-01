package manage.Yelda;

public class Coupon_Products {

    private String coupon_products = "SELECT coupon_id, COUNT(*) AS product_count FROM coupon_products GROUP BY coupon_id";

    public String getCoupon_products() {
        return coupon_products;
    }
}
