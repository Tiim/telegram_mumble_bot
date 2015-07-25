package ch.tiim.cmdhandler.mumblecmd;

import Murmur.User;
import ch.tiim.cmdhandler.CmdHandler;
import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;

public class MumbleInfo implements CmdHandler {

    private final IceController mumble;

    public MumbleInfo(IceController mumble) {
        this.mumble = mumble;
    }

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 && cmd[0].equals("info");
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Following users are currently online:\n");
        for (User u : mumble.getMumbleUsers()) {
            sb.append("\uD83D\uDD38");
            sb.append(u.name).append(" (");
            if (u.mute || u.selfMute) {
                sb.append("\uD83D\uDE4A"); //SayNoEvil
            } else {
                sb.append("\uD83C\uDFA4"); //Mic
            }
            if (u.deaf || u.selfDeaf) {
                sb.append("\uD83D\uDE49"); //HearNoEvil
            } else {
                sb.append("\uD83D\uDD0A"); //Speaker
            }
            sb.append(") in ");
            sb.append(mumble.getChannel(u.channel).name).append("\n");
        }
        b.sendAnswer(m, sb.toString());
    }
}
