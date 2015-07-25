package ch.tiim.cmdhandler;

import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;

public class NullHandler implements CmdHandler {
    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return true;
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        b.sendAnswer(m, "Unknown command. Type /help for more info.");
    }
}
