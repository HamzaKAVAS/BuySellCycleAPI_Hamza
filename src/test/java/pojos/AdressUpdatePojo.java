package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AdressUpdatePojo {


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class HolidayUpdatePojo {

    /*         {
                 "id": 551,
                 "customer_id": 626,

                 }
                 {
  "customer_id": 26,
  "name": "Aleyna",
  "email": "aleyna@buysellcycle.com",
  "address": "Turkey",
  "phone": "5432568891",
  "city": "Almus",
  "state": "Tokat",
  "country": "Turkey",
  "postal_code": "38000",
  "address_type":"11"

}
     */

        private String name;
        private String address;
    }
    }
