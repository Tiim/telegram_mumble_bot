package ch.tiim.telegram;

import org.json.JSONObject;

public class TGVideo {
    private String fileId;
    private int width;
    private int height;
    private int duration;
    private TGPhoto thumb;
    private String mimeType;
    private int fileSize;
    private String caption;

    public TGVideo(JSONObject o) {
        fileId = o.getString("file_id");
        width = o.getInt("width");
        height = o.getInt("height");
        duration = o.getInt("duration");
        thumb = new TGPhoto(o.getJSONObject("thumb"));
        mimeType = o.has("mime_type") ? o.getString("mime_type") : null;
        fileSize = o.has("file_size") ? o.getInt("file_size") : -1;
        caption = o.has("caption") ? o.getString("caption") : null;
    }

    @Override
    public String toString() {
        return "TGVideo{" +
                "fileId='" + fileId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", caption='" + caption + '\'' +
                '}';
    }
}
