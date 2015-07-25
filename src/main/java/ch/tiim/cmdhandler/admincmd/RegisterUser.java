package ch.tiim.cmdhandler.admincmd;

import ch.tiim.cmdhandler.CmdHandler;
import ch.tiim.database.TableUser;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.log.Log;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterUser implements CmdHandler {
    private static final Log LOGGER = new Log(RegisterUser.class);
    private final TableUser db;

    public RegisterUser(TableUser db) {
        this.db = db;
    }

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage original) {
        return cmd.length > 0 &&
                (cmd[0].equals("register") || cmd[0].equals("unregister"));
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        boolean r = cmd[0].equals("register");
        if (cmd.length < 2) {
            b.sendAnswer(m, "Ussage:\n/admin <register|unregister> $(telegram_id)");
            return;
        }
        try {
            if (!db.registerUser(Integer.parseInt(cmd[1]), r)) {
                b.sendAnswer(m, "Operation failed:\nNo such user.");
            } else {
                b.sendAnswer(m, cmd[0] + "red " + cmd[1]);
                b.sendMessage(Integer.parseInt(cmd[1]), "You are now allowed to use this bot.\nType /help for help");
            }
        } catch (SQLException e) {
            b.sendAnswer(m, "Operation failed:\n" + e.getMessage());
            LOGGER.warning(e);
        } catch (NumberFormatException ex) {
            b.sendAnswer(m, "This is not a number!");
        }
    }
}
