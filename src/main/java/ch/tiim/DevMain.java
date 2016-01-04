package ch.tiim;


import java.util.logging.Level;
import java.util.logging.Logger;

public class DevMain {

    @SuppressWarnings("SpellCheckingInspection")
    private static final Logger LOGGER = Logger.getGlobal();


    public static void main(String[] args) {
        Main.init();
        Main.sleepTime = 5_000;
        Main.recipients = new String[]{Main.PROPERTIES.getProperty("admin.id")};
        if (Main.PROPERTIES.containsKey("dev.token")) {
            Main.PROPERTIES.setProperty("token", Main.PROPERTIES.getProperty("dev.token"));
        }
        try {
            Main.start();
            Main.bot.sendMessage(Main.PROPERTIES.getProperty("admin.id"), "Started Test Bot");
            Main.loop();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Main thread threw an error", e);
        }
    }
}
