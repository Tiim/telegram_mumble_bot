package ch.tiim.utils;

import ch.tiim.utils.log.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class IpResolver {

    private static final Log LOGGER = new Log(IpResolver.class);
    private static final String ipService = "http://ip.42.pl/raw";
    private final String ip;

    public IpResolver() {
        String ips;
        try {
            URL url = new URL(ipService);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] buf = new byte[8192];
            int len;
            while ((len = in.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            ips = new String(os.toByteArray(), encoding);
        } catch (IOException e) {
            LOGGER.info("Can't fetch ip from " + ipService);
            ips = "<Error>";
        }
        ip = ips;
    }

    public String getIp() {
        return ip;
    }
}
