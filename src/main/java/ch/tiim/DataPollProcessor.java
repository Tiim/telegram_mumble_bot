package ch.tiim;

import ch.tiim.datapoll.DataPoll;
import ch.tiim.datapoll.MurmurHandler;
import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TelegramBot;

public class DataPollProcessor {

    private final TelegramBot bot;
    private final DataPoll[] handlers;
    private final String[] recipients;

    public DataPollProcessor(TelegramBot bot, IceController ice, String[] recipients) {
        this.bot = bot;
        this.recipients = recipients;
        handlers = new DataPoll[]{
                new MurmurHandler(ice)
        };
    }

    public void update() {
        for (DataPoll h : handlers) {
            h.poll(bot, recipients);
        }
    }
}
