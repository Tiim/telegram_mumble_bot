package ch.tiim;

import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TelegramBot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final Properties PROPERTIES = new Properties();

    private static final Logger LOGGER = Logger.getGlobal();

    static TelegramBot bot;
    private static IceController ice;
    static String[] recipients;
    static int sleepTime = 30_000;

    public static void init() {
        try (InputStream in = Main.class.getResourceAsStream("/settings.properties")) {
            if (in == null) {
                try (InputStream fin = new FileInputStream("settings.properties")) {
                    PROPERTIES.load(fin);
                }
            } else {
                PROPERTIES.load(in);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "COULD NOT LOAD PROPERTIES FILE", e);
        }
    }

    private static void initRec() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; PROPERTIES.containsKey("rec." + i); i++) {
            arrayList.add(PROPERTIES.getProperty("rec." + i));
        }
        recipients = arrayList.toArray(new String[arrayList.size()]);
    }

    public static void start() throws SQLException {
        LOGGER.info("Starting up");
        bot = new TelegramBot(PROPERTIES.getProperty("token"));
        ice = new IceController();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ice.stop();
            LOGGER.info("Shutting down");
        }));
    }

    public static void loop() {
        DataPollProcessor ep = new DataPollProcessor(bot, ice, recipients);
        while (true) {
            ep.update();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                LOGGER.warning("Thread interrupted.. ignoring");
            }
        }
    }

    public static void main(String[] args) {
        initLogger();
        init();
        initRec();
        try {
            start();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Start method threw an error", e);
        }
        while (true) {
            try {
                loop();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Main loop errored.. trying again", e);
            }
        }
    }

    private static void initLogger() {
        LOGGER.setLevel(Level.WARNING);
        Thread.setDefaultUncaughtExceptionHandler((t, e1) -> LOGGER.log(Level.SEVERE, "Exception in thread: " + t, e1));
        Handler[] handlers = LOGGER.getHandlers();
        for (Handler handler : handlers) {
            LOGGER.removeHandler(handler);
        }
        try {
            LOGGER.addHandler(new FileHandler("log.txt"));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can't open file for logging..", e);
        }
    }
}
