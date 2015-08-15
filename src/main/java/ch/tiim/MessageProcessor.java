package ch.tiim;

import ch.tiim.cmdhandler.*;
import ch.tiim.cmdhandler.admincmd.AdminCmdHandler;
import ch.tiim.cmdhandler.mumblecmd.MumbleCmdHandler;
import ch.tiim.database.DatabaseManager;
import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TGMessage;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.log.Log;
import ch.tiim.utils.StringArrays;

import java.io.IOException;

public class MessageProcessor {
    private static final Log LOGGER = new Log(MessageProcessor.class);
    private final TelegramBot bot;
    private final CmdRegistry registry;


    public MessageProcessor(TelegramBot bot, DatabaseManager db, IceController ice, int adminId) {
        this.bot = bot;
        registry = new CmdRegistry(
                new AccessCheckHandler(db),
                new HelpCmdHandler(),
                new IpCmdHandler(),
                new MumbleCmdHandler(ice, db),
                new AdminCmdHandler(adminId, db),
                new NullHandler()
        );
    }

    public void receive(TGMessage msg) {
        if (msg.getText() != null) {
            String[] args = msg.getText().split(" ");
            StringArrays.trimArray(args);
            try {
                registry.handle(args, msg, bot);
            } catch (IOException e) {
                LOGGER.warning(e);
            }
        }
    }

}
