package ch.tiim.telegram;

import org.json.JSONObject;

public class TGDocument {
    private String fileId;
    private TGPhoto thumb;
    private String fileName;
    private String mimeType;
    private int fileSize;

    public TGDocument(JSONObject o) {
        fileId = o.getString("file_id");
        thumb = new TGPhoto(o.getJSONObject("thumb"));
        fileName = o.has("file_name") ? o.getString("file_name") : null;
        mimeType = o.has("mime_type") ? o.getString("mime_type") : null;
        fileSize = o.has("file_size") ? o.getInt("file_size") : -1;
    }

    @Override
    public String toString() {
        return "TGDocument{" +
                "fileId='" + fileId + '\'' +
                ", thumb=" + thumb +
                ", fileName='" + fileName + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
