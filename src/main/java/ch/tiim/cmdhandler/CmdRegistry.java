package ch.tiim.cmdhandler;

import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;

public class CmdRegistry {

    private final CmdHandler[] handlers;

    public CmdRegistry(CmdHandler... handlers) {

        this.handlers = handlers;
    }


    public boolean handle(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        for (CmdHandler handler : handlers) {
            if (handler.canHandleMessage(cmd, m)) {
                handler.handleMessage(cmd, m, b);
                return true;
            }
        }
        return false;
    }
}
