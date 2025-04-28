package utilities.API_Utilities.TestDatas;

import java.util.HashMap;

public class TestDataHamza {
    HashMap<String, Object> requestBody;

    public HashMap getBodyUS28(int id) {
        requestBody = new HashMap<>();
        requestBody.put("id", id);
        return requestBody;
    }
}
