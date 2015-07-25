package ch.tiim.cmdhandler;

import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.IpResolver;

import java.io.IOException;

public class IpCmdHandler implements CmdHandler {

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 && cmd[0].equals("/ip");
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        String port = "64738";
        //noinspection ConstantConditions
        b.sendAnswer(m, "IP: " + new IpResolver().getIp() +
                ((port != null) ? "\nPORT: " + port : ""));
    }
}
