package manage.hamza;

public class Refund_reasons {

    public String getRefund_reasons_select() {
        return refund_reasons_select;
    }

    private String refund_reasons_select = "SELECT EXISTS ( SELECT 1 FROM refund_reasons WHERE reason IS NULL ) AS has_null_reason";

}
