package ch.tiim.telegram;

import org.json.JSONObject;

public class TGPhoto {
    private String fileId;
    private int width;
    private int height;
    private int fileSize;

    public TGPhoto(JSONObject o) {
        fileId = o.getString("file_id");
        width = o.getInt("width");
        height = o.getInt("height");
        fileSize = o.has("file_size") ? o.getInt("file_size") : -1;
    }

    @Override
    public String toString() {
        return "TGPhoto{" +
                "fileId='" + fileId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", fileSize=" + fileSize +
                '}';
    }
}
