package ch.tiim.telegram;

import org.json.JSONObject;

public class TGSticker {
    private String fileId;
    private int width;
    private int height;
    private TGPhoto thumb;
    private int fileSize;

    public TGSticker(JSONObject o) {
        fileId = o.getString("file_id");
        width = o.getInt("width");
        height = o.getInt("height");
        thumb = new TGPhoto(o.getJSONObject("thumb"));
        fileSize = o.has("file_size") ? o.getInt("file_size") : -1;
    }

    @Override
    public String toString() {
        return "TGSticker{" +
                "fileId='" + fileId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", thumb=" + thumb +
                ", fileSize=" + fileSize +
                '}';
    }
}
