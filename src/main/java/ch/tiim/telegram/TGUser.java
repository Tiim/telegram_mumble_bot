package ch.tiim.telegram;

import org.json.JSONObject;

public class TGUser {

    private String id;
    private boolean groupChat;
    private String firstName;
    private String lastName;
    private String userName;

    public TGUser(JSONObject o) {
        if (o.get("id") instanceof Number) {
            id = Long.toString(o.getLong("id"));
        } else {
            id = o.getString("id");
        }
        if (o.has("title")) {
            firstName = o.getString("title");
            groupChat = true;
        } else {
            firstName = o.getString("first_name");
            lastName = o.has("last_name") ? o.getString("last_name") : null;
            userName = o.has("username") ? o.getString("username") : null;
            groupChat = false;
        }
    }

    /**
     * Creates a groupchat;
     *
     * @param id    chat id
     * @param title chat title
     */
    public TGUser(String id, String title) {
        this.id = id;
        this.firstName = title;
        this.groupChat = true;
    }

    public TGUser(String id, String firstName, String lastName, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.groupChat = false;
        this.lastName = lastName;
        this.userName = userName;
    }


    @Override
    public String toString() {
        return "TGUser{" +
                "id=" + id +
                ((groupChat) ?
                        (", title='" + firstName + '\'') :
                        (", firstName='" + firstName + '\'' +
                                ", lastName='" + lastName + '\'' +
                                ", userName='" + userName + '\'')) +
                '}';
    }

    public String getId() {
        return id;
    }

    public boolean isGroupChat() {
        return groupChat;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }
}
