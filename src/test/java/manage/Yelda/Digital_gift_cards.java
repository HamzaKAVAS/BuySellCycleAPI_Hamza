package manage.Yelda;

public class Digital_gift_cards {


    private String digital_gift_cards = "INSERT INTO digital_gift_cards (id, gift_name , descriptionOne, thumbnail_image_one, thumbnail_image_two, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?);";

    private String digital_gift_cardsDelete = "DELETE FROM digital_gift_cards WHERE id = ?;";

    private String digital_gift_cardsSelect="SELECT * FROM digital_gift_cards WHERE id = ?;";

    public String getDigital_gift_cards() {
        return digital_gift_cards;
    }

    public String getDigital_gift_cardsDelete() {
        return digital_gift_cardsDelete;
    }

    public String getDigital_gift_cardsSelect() {
        return digital_gift_cardsSelect;
    }
}
