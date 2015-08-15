package ch.tiim.cmdhandler.admincmd;

import ch.tiim.cmdhandler.CmdHandler;
import ch.tiim.cmdhandler.CmdRegistry;
import ch.tiim.cmdhandler.SimpleHandler;
import ch.tiim.cmdhandler.admincmd.RegisterUser;
import ch.tiim.database.DatabaseManager;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.StringArrays;

import java.io.IOException;

public class AdminCmdHandler implements CmdHandler {

    private final int adminId;

    private final CmdRegistry registry;

    public AdminCmdHandler(int adminId, DatabaseManager db) {

        this.adminId = adminId;
        registry = new CmdRegistry(
                new RegisterUser(db.getTableUser()),
                new DumpCmd(db.getTableUser()),
                new SendInfo(db.getTableUser()),
                new SimpleHandler("info", System.getProperty("user.name") + " - " + System.getProperty("os.name"))
        );

    }

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 && cmd[0].equals("/admin")
                && m.getFrom().getId() == adminId;
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        if (cmd.length == 1) {
            b.sendAnswer(m,
                    "Usage:\n" +
                            "/admin register $(id)\n" +
                            "/admin info\n" +
                            "/admin dump"
            );
            return;
        }
        String[] cmds = StringArrays.skipFirst(cmd);
        registry.handle(cmds, m, b);
    }
}
