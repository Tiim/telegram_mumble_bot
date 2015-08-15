package ch.tiim.cmdhandler.admincmd;

import ch.tiim.cmdhandler.CmdHandler;
import ch.tiim.database.TableUser;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TGUser;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SendInfo implements CmdHandler {
    private static final ch.tiim.utils.log.Log LOGGER = new ch.tiim.utils.log.Log(SendInfo.class);
    private final TableUser tableUser;

    public SendInfo(TableUser tableUser) {

        this.tableUser = tableUser;
    }

    @Override
    public boolean canHandleMessage(String[] cmd, TGMessage m) {
        return cmd.length > 0 && cmd[0].equals("send");
    }

    @Override
    public void handleMessage(String[] cmd, TGMessage m, TelegramBot b) throws IOException {
        List<String> numbers = Arrays.asList(cmd);
        String string = numbers.stream().skip(1)
                .collect(Collectors.joining(", "));
        try {
            for (TGUser user : tableUser.getRegisteredUsers()) {
                b.sendMessage(user.getId(), string);
            }
        } catch (SQLException e) {
            LOGGER.warning(e);
        }
    }
}
