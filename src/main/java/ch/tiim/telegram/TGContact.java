package ch.tiim.telegram;

import org.json.JSONObject;

public class TGContact {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String userId;

    public TGContact(JSONObject o) {
        phoneNumber = o.getString("phone_number");
        firstName = o.getString("first_name");
        lastName = o.has("last_name") ? o.getString("last_name") : null;
        userId = o.has("user_id") ? o.getString("user_id") : null;
    }

    @Override
    public String toString() {
        return "TGContact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
