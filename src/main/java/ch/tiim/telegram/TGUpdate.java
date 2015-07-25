package ch.tiim.telegram;

import org.json.JSONObject;

public class TGUpdate {
    private int updateId;
    private TGMessage message;

    public TGUpdate(JSONObject o) {
        updateId = o.getInt("update_id");
        message = o.has("message") ? new TGMessage(o.getJSONObject("message")) : null;
    }

    @Override
    public String toString() {
        return "TGUpdate{" +
                "updateId=" + updateId +
                ", message=" + message +
                '}';
    }

    public int getId() {
        return updateId;
    }

    public TGMessage getMessage() {
        return message;
    }
}
