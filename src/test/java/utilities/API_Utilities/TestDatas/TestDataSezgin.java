package utilities.API_Utilities.TestDatas;

import java.util.HashMap;

public class TestDataSezgin {
    HashMap<String, Object> requestBody;

    public HashMap holidayAdd() {

        requestBody = new HashMap<>();

        requestBody.put("year", "2026");
        requestBody.put("name", "Ulusal Egemenlik ve Çocuk Bayram");
        requestBody.put("date", "2026-04-23");

        return requestBody;
    }

}
