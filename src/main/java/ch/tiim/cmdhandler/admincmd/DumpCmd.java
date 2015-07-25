package ch.tiim.cmdhandler.admincmd;

import ch.tiim.cmdhandler.CmdHandler;
import ch.tiim.database.TableUser;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TGUser;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.log.Log;

import java.io.IOException;
import java.sql.SQLException;

public class DumpCmd implements CmdHandler {
    private static final Log LOGGER = new Log(DumpCmd.class);
    private final TableUser db;

    public DumpCmd(TableUser db) {
        this.db = db;
    }

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 && cmd[0].equals("dump");
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        try {
            TGUser[] usrs = db.getUnregisteredUsers();
            StringBuilder sb = new StringBuilder();
            sb.append("Following users are not yet registered:\n");
            for(TGUser u : usrs) {
                sb.append(u.getFirstName());
                if (u.getLastName() != null) {
                    sb.append(" ").append(u.getLastName());
                }
                if (u.getUserName() != null) {
                    sb.append("(@").append(u.getUserName()).append(")");
                }
                sb.append(": ").append(u.getId());
                if (u.isGroupChat()) {
                    sb.append(" - GROUP");
                }
            }
            b.sendAnswer(m, sb.toString());
        } catch (SQLException e) {
            LOGGER.warning(e);
        }
    }
}
