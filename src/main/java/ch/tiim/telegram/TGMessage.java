package ch.tiim.telegram;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class TGMessage {

    private int messageId;
    private TGUser from;
    private int date;
    private TGUser chat;
    private TGUser forwardFrom;
    private int forwardDate;
    private TGMessage replyToMessage;
    private String text;
    private TGAudio audio;
    private TGDocument document;
    private TGPhoto[] photo;
    private TGSticker sticker;
    private TGVideo video;
    private TGContact contact;
    private TGLocation location;
    private TGUser newChatParticipant;
    private TGUser leftChatParticipant;
    private String newChatTitle;
    private TGPhoto[] newChatPhoto;
    private boolean deleteChatPhoto;
    private boolean groupChatCreated;

    public TGMessage(JSONObject o) {
        messageId = o.getInt("message_id");
        from = new TGUser(o.getJSONObject("from"));
        date = o.getInt("date");
        chat = new TGUser(o.getJSONObject("chat"));
        forwardFrom = (o.has("forward_from")) ? new TGUser(o.getJSONObject("forward_from")) : null;
        forwardDate = (o.has("forward_date")) ? o.getInt("forward_date") : -1;
        replyToMessage = o.has("reply_to_message") ? new TGMessage(o.getJSONObject("reply_to_message")) : null;
        text = o.has("text") ? o.getString("text") : null;
        audio = o.has("audio") ? new TGAudio(o.getJSONObject("audio")) : null;
        document = o.has("document") ? new TGDocument(o.getJSONObject("document")) : null;
        if (o.has("photo")) {
            JSONArray arr = o.getJSONArray("photo");
            photo = new TGPhoto[arr.length()];
            for (int i = 0; i < arr.length(); i++) {
                photo[i] = new TGPhoto(arr.getJSONObject(i));
            }
        }
        sticker = o.has("sticker") ? new TGSticker(o.getJSONObject("sticker")) : null;
        video = o.has("video") ? new TGVideo(o.getJSONObject("video")) : null;
        contact = o.has("contact") ? new TGContact(o.getJSONObject("contact")) : null;
        location = o.has("location") ? new TGLocation(o.getJSONObject("location")) : null
        ;
        newChatParticipant = o.has("new_chat_participant") ? new TGUser(o.getJSONObject("new_chat_participant")) : null;
        leftChatParticipant = o.has("left_chat_participant") ? new TGUser(o.getJSONObject("left_chat_participant")) : null;
        newChatTitle = o.has("new_chat_title") ? o.getString("new_chat_title") : null;
        if (o.has("new_chat_photo")) {
            JSONArray arr = o.getJSONArray("new_chat_photo");
            newChatPhoto = new TGPhoto[arr.length()];
            for (int i = 0; i < arr.length(); i++) {
                newChatPhoto[i] = new TGPhoto(arr.getJSONObject(i));
            }
        }
        deleteChatPhoto = o.has("delete_chat_photo") && o.getBoolean("delete_chat_photo");
        groupChatCreated = o.has("group_chat_created") && o.getBoolean("group_chat_created");
    }

    @Override
    public String toString() {
        return "TGMessage{" +
                "messageId=" + messageId +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forwardFrom=" + forwardFrom +
                ", forwardDate=" + forwardDate +
                ", replyToMessage=" + replyToMessage +
                ", text='" + text + '\'' +
                ", audio=" + audio +
                ", document=" + document +
                ", photo=" + Arrays.toString(photo) +
                ", sticker=" + sticker +
                ", video=" + video +
                ", contact=" + contact +
                ", location=" + location +
                ", newChatParticipant=" + newChatParticipant +
                ", leftChatParticipant=" + leftChatParticipant +
                ", newChatTitle='" + newChatTitle + '\'' +
                ", newChatPhoto=" + Arrays.toString(newChatPhoto) +
                ", deleteChatPhoto=" + deleteChatPhoto +
                ", groupChatCreated=" + groupChatCreated +
                '}';
    }

    public String getText() {
        return text;
    }

    public TGUser getFrom() {
        return from;
    }

    public TGUser getChat() {
        return chat;
    }
}
