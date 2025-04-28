package utilities.API_Utilities.TestDatas;

import java.util.HashMap;

public class TestDataYelda {

    HashMap<String, Object> requestBody;

    public HashMap AdressAdmin() {

        requestBody = new HashMap<>();

        requestBody.put("id", "1");

        return requestBody;
    }

    /*
    {
      "customer_id": 26,
      "name": "Yelda",
      "email": "yelda@buysellcycle.com",
      "address": "autzs",
      "phone": "55487456560",
      "city": "59010",
      "state": "43",
      "country": "1",
      "postal_code": "38000",
      "address_type":"11"
    }
     */
    HashMap<String, Object> requestBodyPost;

    public HashMap AdressAdminPost() {

        requestBody = new HashMap<>();

        requestBody.put("customer_id", "626");
        requestBody.put("name", "melda");
        requestBody.put("email", "melda@buysellcycle.com");
        requestBody.put("address", "autzs");
        requestBody.put("phone", "55487456560");
        requestBody.put("city", "59010");
        requestBody.put("state", "43");
        requestBody.put("country", "1");
        requestBody.put("postal_code", "38000");
        requestBody.put("address_type", "11");

        return requestBody;
    }

    public HashMap AdressAdminPost422() {

        requestBody = new HashMap<>();

        requestBody.put("customer_id", "999");
        requestBody.put("name", "Ada");
        requestBody.put("email", "adabuysellcycle.com");
        requestBody.put("address", "autzs");
        requestBody.put("phone", "55487456560");
        requestBody.put("city", "59010");
        requestBody.put("state", "44");
        requestBody.put("country", "1");
        requestBody.put("postal_code", "38000");
        requestBody.put("address_type", "11");

        return requestBody;
    }

    public HashMap AdressAdminPostNoData() {

        requestBody = new HashMap<>();
        return requestBody;
    }



    /*
    {
  "customer_id": 626,
      "name": "Doruk",
      "email": "Doruk@buysellcycle.com",
      "address": "autzs",
      "phone": "554874789",
      "city": "59010",
      "state": "43",
      "country": "1",
      "postal_code": "38000",
      "address_type":"15"

}
     */

    public HashMap AdressAdminPatch() {

        requestBody = new HashMap<>();

        requestBody.put("customer_id", "626");
        requestBody.put("name", "Doruk");
        requestBody.put("email", "Doruk@buysellcycle.com");
        requestBody.put("address", "autzs");
        requestBody.put("phone", "554874789");
        requestBody.put("city", "59010");
        requestBody.put("state", "43");
        requestBody.put("country", "1");
        requestBody.put("postal_code", "38000");
        requestBody.put("address_type", "15");

        return requestBody;

    }

    public HashMap AdressAdminPatchIncorrect() {

        requestBody = new HashMap<>();
        requestBody.put("name", "Doruk");
        requestBody.put("email", "Doruk@buysellcycle.com");
        requestBody.put("address", "autzs");
        requestBody.put("phone", "554874789");
        requestBody.put("city", "59010");
        requestBody.put("state", "43");
        requestBody.put("country", "1");
        requestBody.put("postal_code", "38000");
        requestBody.put("address_type", "15");

        return requestBody;

    }

    public HashMap AdressAdminPatchNoData() {

        return requestBody;

    }




}
