package ch.tiim.cmdhandler;

import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;

public interface CmdHandler {

    boolean canHandleMessage(String[] cmd, TGMessage m);

    void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException;

}
