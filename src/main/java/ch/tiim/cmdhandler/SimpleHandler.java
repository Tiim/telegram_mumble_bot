package ch.tiim.cmdhandler;

import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;

public class SimpleHandler implements CmdHandler {

    public interface HandleMessage {
        void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException;
    }

    private final String cmd;
    private final HandleMessage lambda;
    private final String answer;

    public SimpleHandler(String cmd, HandleMessage h) {
        this.cmd = cmd;
        lambda = h;
        answer = null;
    }

    public SimpleHandler(String cmd, String answer) {
        this.cmd = cmd;
        lambda = null;
        this.answer = answer;
    }


    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 && cmd[0].equals(this.cmd);
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        if (lambda != null) {
            lambda.handleMessage(cmd, m, b);
        } else {
            b.sendAnswer(m, answer);
        }
    }
}
