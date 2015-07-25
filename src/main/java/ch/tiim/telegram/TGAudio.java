package ch.tiim.telegram;

import org.json.JSONObject;

public class TGAudio {
    private String fileId;
    private int duration;
    private String mimeType;
    private int fileSize;

    public TGAudio(JSONObject o) {
        fileId = o.getString("file_id");
        duration = o.getInt("duration");
        mimeType = o.has("mime_type") ? o.getString("mime_type") : null;
        fileSize = o.has("file_size") ? o.getInt("file_size") : -1;
    }

    @Override
    public String toString() {
        return "TGAudio{" +
                "fileId='" + fileId + '\'' +
                ", duration=" + duration +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
