package ch.tiim.cmdhandler.mumblecmd;

import ch.tiim.cmdhandler.CmdHandler;
import ch.tiim.cmdhandler.CmdRegistry;
import ch.tiim.database.DatabaseManager;
import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.StringArrays;

import java.io.IOException;

public class MumbleCmdHandler implements CmdHandler {

    private final IceController mumble;
    private final CmdRegistry registry;

    public MumbleCmdHandler(IceController mumble, DatabaseManager db) {
        this.mumble = mumble;
        registry = new CmdRegistry(
                new MumbleInfo(mumble),
                new MumbleSubscribe(db.getTableMumbleSubscribe()),
                new MumbleUnsubscribe(db.getTableMumbleSubscribe())

        );
    }

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 && cmd[0].equals("/mumble");
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        if (cmd.length < 2) {
            b.sendAnswer(m, "Look at /help");
            return;
        }
        if (!mumble.isAvailable()) {
            b.sendAnswer(m, "ICE interface not detected.\n" +
                    "Maybe there is no running mumble server.");
        } else {
            String[] cmds = StringArrays.skipFirst(cmd);
            registry.handle(cmds, m, b);
        }
    }
}
