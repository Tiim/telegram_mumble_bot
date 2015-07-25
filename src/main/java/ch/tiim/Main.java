package ch.tiim;

import ch.tiim.database.DatabaseManager;
import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TGUpdate;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.log.FileAppender;
import ch.tiim.utils.log.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public static final Properties PROPERTIES = new Properties();

    @SuppressWarnings("SpellCheckingInspection")
    private static final Log LOGGER = new Log(Main.class);

    static TelegramBot bot;
    private static DatabaseManager db;
    private static IceController ice;


    public static void init() {
        try {
            InputStream in = Main.class.getResourceAsStream("/settings.properties");
            if (in == null) {
                in = new FileInputStream("settings.properties");
            }
            PROPERTIES.load(in);
            in.close();
        } catch (IOException e) {
            LOGGER.error("COULD NOT LOAD PROPERTIES FILE", e);
        }
    }

    public static void start() throws SQLException {
        LOGGER.info("Starting up");
        bot = new TelegramBot(PROPERTIES.getProperty("token"));
        db = new DatabaseManager("telegram.db");
        ice = new IceController();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            ice.stop();
            LOGGER.info("Shutting down");
        }));
    }

    public static void loop() {
        int adminId = Integer.parseInt(PROPERTIES.getProperty("admin.id"));
        MessageProcessor mp = new MessageProcessor(bot, db, ice, adminId);
        DataPollProcessor ep = new DataPollProcessor(bot, db, ice, adminId);
        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                for (TGUpdate upd : bot.getUpdates()) {
                    mp.receive(upd.getMessage());
                }
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
                try {
                    Thread.sleep(30_000);
                } catch (InterruptedException e1) {
                    LOGGER.warning("Interrupted thread", e1);
                }
            }
            ep.update();
        }
    }

    public static void main(String[] args) {
        //noinspection InfiniteLoopStatement
        Log.setAppender(new FileAppender("log.txt"));
        Log.setMinLogLevel(2);
        init();
        try {
            start();
        } catch (Exception e) {
            LOGGER.error("Start method threw abn error", e);
        }
        while (true) {
            try {
                loop();
            } catch (Exception e) {
                LOGGER.error("Main loop errored.. trying again", e);
            }
        }
    }
}
