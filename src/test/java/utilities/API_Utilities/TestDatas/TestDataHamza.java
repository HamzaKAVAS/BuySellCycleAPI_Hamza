package utilities.API_Utilities.TestDatas;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class TestDataHamza {
    HashMap<String, Object> requestBody;

    public HashMap getBodyUS28(int id) {
        requestBody = new HashMap<>();
        requestBody.put("id", id);
        return requestBody;
    }

    public HashMap getBodyUS28_Wrong() {
        requestBody = new HashMap<>();
        requestBody.put("id", 169);
        return requestBody;
    }

    public HashMap couponAdd() {
        requestBody = new HashMap<>();
        requestBody.put("title", "Merhaba");
        requestBody.put("coupon_code", "Herkese Selam");
        requestBody.put("coupon_type", 3);
        requestBody.put("start_date", "2021-11-18");
        requestBody.put("end_date", "2021-11-21");
        requestBody.put("discount", 10);
        requestBody.put("discount_type", 0);
        requestBody.put("minimum_shopping", 1);
        requestBody.put("maximum_discount", null);
        requestBody.put("is_expire", 0);
        requestBody.put("is_multiple_buy", 2);
        return requestBody;
    }

    public HashMap couponUptade() {
        requestBody = new HashMap<>();
        Faker faker = new Faker();
        requestBody.put("title", "Team148");
        requestBody.put("coupon_code", "Geometri");
        requestBody.put("start_date", faker.date().birthday());
        return requestBody;
    }
}
