package manage.Yelda;

public class Contacts {

    private String contacts="INSERT INTO contacts (id, name, email, query_type, message)VALUES (?,?,?,?,?);";
    private String contactsDelete="DELETE FROM contacts WHERE id=?;";

    public String getContacts() {
        return contacts;
    }

    public String getContactsDelete() {
        return contactsDelete;
    }

}
