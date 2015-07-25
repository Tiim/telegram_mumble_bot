package ch.tiim;


import ch.tiim.utils.log.ConsoleAppender;
import ch.tiim.utils.log.Log;

public class DevMain {

    @SuppressWarnings("SpellCheckingInspection")
    private static final Log LOGGER = new Log(DevMain.class);


    public static void main(String[] args) {
        Log.setAppender(new ConsoleAppender());
        Log.setMinLogLevel(3);
        Main.init();

        if (Main.PROPERTIES.containsKey("dev.token")) {
            Main.PROPERTIES.setProperty("token", Main.PROPERTIES.getProperty("dev.token"));
        }
        try {
            Main.start();
            Main.bot.sendMessage(Integer.parseInt(Main.PROPERTIES.getProperty("admin.id")), "Started Test Bot");
            Main.loop();
        } catch (Exception e) {
            LOGGER.error("Main thread threw an error", e);
        }
    }
}
