package ch.tiim.cmdhandler.mumblecmd;

import ch.tiim.cmdhandler.CmdHandler;
import ch.tiim.database.TableMumbleSubscribe;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.log.Log;

import java.io.IOException;
import java.sql.SQLException;

public class MumbleSubscribe implements CmdHandler {
private static final Log LOGGER = new Log(MumbleSubscribe.class);
    private final TableMumbleSubscribe db;

    public MumbleSubscribe(TableMumbleSubscribe db) {
        this.db = db;
    }

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 && cmd[0].equals("subscribe");
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        if (cmd.length != 1 && cmd.length != 2) {
            b.sendAnswer(m, "Look at /help mumble");
            return;
        }
        boolean s = cmd[0].equals("subscribe");
        try {
            db.subscribeUser(m.getChat().getId(), cmd.length == 2 ? cmd[1] : "__all__");
            b.sendAnswer(m, "Successfully subscribed to " + (cmd.length == 2 ? cmd[1] : "every user"));
        } catch (SQLException e) {
            b.sendAnswer(m, "Operation failed:\n" + e.getMessage());
            if(e.getErrorCode() == 19) {
                b.sendAnswer(m, "You might be already subscribed to this user");
            }
            LOGGER.warning(e);
        }
    }
}
