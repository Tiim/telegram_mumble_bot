package ch.tiim.telegram;

import ch.tiim.utils.log.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class TelegramBot {
    private static final Log LOGGER = new Log(TelegramBot.class);
    private static final String url = "https://api.telegram.org/bot";
    private final String token;

    private int updateId = 0;

    public TelegramBot(String token) {
        this.token = token;
    }

    private JSONObject callApi(String function, Map<String, String> args) throws IOException {
        byte[] urlParameters = args.entrySet().stream()
                .map(p -> {
                    try {
                        return URLEncoder.encode(p.getKey(), "UTF-8") +
                                "=" +
                                URLEncoder.encode(p.getValue(), "UTF-8");
                    } catch (UnsupportedEncodingException ignore) {
                        return null;
                    }
                })
                .reduce((p1, p2) -> p1 + "&" + p2)
                .orElse("").getBytes(StandardCharsets.UTF_8);

        URL conUrl = new URL(url + token + "/" + function);
        HttpsURLConnection con = (HttpsURLConnection) conUrl.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("charset", "utf-8");
        con.setRequestProperty("Content-Length", Integer.toString(urlParameters.length));
        con.setUseCaches(false);
        con.getOutputStream().write(urlParameters);
        con.getOutputStream().flush();
        Reader r = new InputStreamReader(con.getInputStream());
        StringBuilder b = new StringBuilder();
        char[] buf = new char[100];
        int i;
        while ((i = r.read(buf)) != -1) {
            b.append(buf, 0, i);
        }
        return new JSONObject(b.toString());
    }

    public TGUser getMe() throws IOException {
        JSONObject obj = callApi("getMe", new HashMap<>());
        if (obj.has("ok") && obj.getBoolean("ok")) {
            return new TGUser(obj.getJSONObject("result"));
        }
        return null;
    }

    //TODO: KEYBOARD LAYOUTS
    public TGMessage sendMessage(int chatId, String text, boolean disableWebPagePreview, int replyToMessageId) throws IOException {
        Map<String, String> m = new HashMap<>();
        m.put("chat_id", Integer.toString(chatId));
        m.put("text", text);
        m.put("disable_web_page_preview", Boolean.toString(disableWebPagePreview));
        if (replyToMessageId > 0) {
            m.put("reply_to_message_id", Integer.toString(replyToMessageId));
        }
        JSONObject obj = callApi("sendMessage", m);
        if (obj.has("ok") && obj.getBoolean("ok")) {
            return new TGMessage(obj.getJSONObject("result"));
        }
        return null;
    }

    public TGMessage sendMessage(int chatId, String text) throws IOException {
        return sendMessage(chatId, text, false, -1);
    }

    public TGMessage sendAnswer(TGMessage msg, String text) throws IOException {
        return sendMessage(msg.getChat().getId(), text);
    }

    public TGUpdate[] getUpdates() throws IOException {
        LOGGER.info("getUpdate();");
        Map<String, String> m = new HashMap<>();
        m.put("offset", Integer.toString(updateId + 1));
        m.put("timeout", "100");
        JSONObject obj = callApi("getUpdates", m);
        if (obj.has("ok") && obj.getBoolean("ok")) {
            JSONArray arr = obj.getJSONArray("result");
            TGUpdate[] ret = new TGUpdate[arr.length()];
            for (int i = 0; i < arr.length(); i++) {
                ret[i] = new TGUpdate(arr.getJSONObject(i));
            }
            if (ret.length > 0) {
                updateId = ret[ret.length - 1].getId();
            }
            return ret;
        }
        return new TGUpdate[0];
    }
}
