package ch.tiim.cmdhandler.mumblecmd;

import Murmur.User;
import ch.tiim.cmdhandler.CmdHandler;
import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;
import java.util.Collection;

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
        Collection<User> users = mumble.getMumbleUsers();
        if (users.size() != 0) {
            sb.append("Following users are currently online:\n");
        } else {
            sb.append("\u0302\u030eN\u036a\u034eo\u035b\u0360b\u035b\u0304o\u0367\u0347d\u0321\u0305 y\u0303\u036b is currently online\uD83D\uDE13\n");
            sb.append("Be the \uD83C\uDD75\uD83C\uDD78\uD83C\uDD81\uD83C\uDD82\uD83C\uDD83 to join and make everyone follow you\uD83D\uDE0C");
        }
        for (User u : users) {
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
