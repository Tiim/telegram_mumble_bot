package ch.tiim.cmdhandler;

import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.StringArrays;

import java.io.IOException;

public class HelpCmdHandler implements CmdHandler {

    private final String version;

    public HelpCmdHandler() {
        version = getClass().getPackage().getImplementationVersion();
    }

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 &&
                (cmd[0].equals("/help") || cmd[0].equals("/start"));
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        b.sendAnswer(m,
                "Welcome to @TiimB s mumble bot v" + version + "\n" +
                        "\n" +
                        "Currently supported commands are:\n" +
                        "\uD83D\uDD36 /help - shows this message\n" +
                        "\uD83D\uDD36 /ip - shows the ip of the mumble server\n" +
                        "\uD83D\uDD36 /mumble - \n" +
                        "\uD83D\uDD39 /mumble subscribe [$(MumbleName)] -  registers you to a mumble name and sends " +
                        "you a message the next time $(MumbleName) comes online. If $(MumbleName) is not specified" +
                        "you will get a message every time a new user connects\n" +
                        "\uD83D\uDD39 /mumble unsubscribe [$(MumbleName)] - unregisters you from $(MumbleName). If" +
                        "$(MumbleName) is not specified you will be unregistered from every name.\n" +
                        "\uD83D\uDD39 /mumble info - shows a list of currently connected users\n"
        );
        //}
    }
}
