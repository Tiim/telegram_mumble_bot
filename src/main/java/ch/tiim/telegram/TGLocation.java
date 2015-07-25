package ch.tiim.telegram;

import org.json.JSONObject;

public class TGLocation {
    private double longitude;
    private double latitude;

    public TGLocation(JSONObject o) {
        longitude = o.getDouble("longitude");
        latitude = o.getDouble("latitude");
    }

    @Override
    public String toString() {
        return "TGLocation{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
