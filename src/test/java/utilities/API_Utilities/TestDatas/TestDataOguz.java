package utilities.API_Utilities.TestDatas;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class TestDataOguz {
    HashMap<String, Object> requestBody;

    public HashMap holidayAdd() {

        requestBody = new HashMap<>();

        Faker faker = new Faker();

        requestBody.put("year", "2018");
        requestBody.put("name", "15 Temmuz Şehit Sezgin Mert Bayramı");
        requestBody.put("date", faker.date().birthday());

        return requestBody;
    }

    public HashMap holidaySistemeKayitli() {

        requestBody = new HashMap<>();

        requestBody.put("year", "2018");
        requestBody.put("name", "15 Temmuz Şehit Sezgin Mert Bayramı");
        requestBody.put("date", "2027-04-23");

        return requestBody;
    }


    public HashMap getBodyUS8(int id) {

        requestBody = new HashMap<>();

        requestBody.put("id", id);

        return requestBody;
    }

    public HashMap getBodyUS8_Wrong() {

        requestBody = new HashMap<>();
        requestBody.put("id", 169);

        return requestBody;
    }

    public HashMap holidayUptade() {

        requestBody = new HashMap<>();

        Faker faker = new Faker();

        requestBody.put("year", "2018");
        requestBody.put("name", "Noel");
        requestBody.put("date", faker.date().birthday());

        return requestBody;
    }

    public HashMap holidayUptadeAyniVeriGonderme() {

        requestBody = new HashMap<>();

        requestBody.put("year", "2024");
        requestBody.put("name", "23Nisan Ulusal Egemenlik ve Çocuk Bayramı");
        requestBody.put("date", "2024-04-23");

        return requestBody;
    }

    public HashMap delete(int id) {

        requestBody = new HashMap<>();

        requestBody.put("id", id);

        return requestBody;
    }

    public HashMap deleteNoData() {

        requestBody = new HashMap<>();

        requestBody.put("id",null);

        return requestBody;
    }




}
