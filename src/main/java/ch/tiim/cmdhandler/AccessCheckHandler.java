package ch.tiim.cmdhandler;

import ch.tiim.Main;
import ch.tiim.database.DatabaseManager;
import ch.tiim.database.TableUser;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.log.Log;

import java.io.IOException;
import java.sql.SQLException;

public class AccessCheckHandler implements CmdHandler {

    private static final Log LOGGER = new Log(AccessCheckHandler.class);

    private static final String PERMISSION_DENIED_STR = "Hello %s\n" +
            "You are unfortunately not allowed to use this bot.\uD83D\uDE22\n" +
            "We might white-list you soon!";
    private final TableUser db;

    public AccessCheckHandler(DatabaseManager db) {
        this.db = db.getTableUser();
    }

    @Override
    public boolean canHandleMessage(String[] arg, TGMessage m) {
        try {
            return !db.isUserRegistered(m.getChat().getId());
        } catch (SQLException e) {
            LOGGER.warning(e);
            return true;
        }
    }

    @Override
    public void handleMessage(String[] arg, TGMessage m, TelegramBot bot) throws IOException {
        bot.sendAnswer(m,
                String.format(PERMISSION_DENIED_STR, m.getFrom().getFirstName())
        );
        try {
            db.addNewUser(m.getChat());
        } catch (SQLException e) {
            LOGGER.warning(e);
        }
    }
}
