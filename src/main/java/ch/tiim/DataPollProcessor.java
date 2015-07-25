package ch.tiim;

import ch.tiim.database.DatabaseManager;
import ch.tiim.datapoll.DataPoll;
import ch.tiim.datapoll.MurmurHandler;
import ch.tiim.murmur.IceController;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;

public class DataPollProcessor {

    private final TelegramBot bot;
    private final DataPoll[] handlers;


    public DataPollProcessor(TelegramBot bot, DatabaseManager db, IceController ice, int adminId) {
        this.bot = bot;
        handlers = new DataPoll[]{
                new MurmurHandler(ice, db)
        };
    }

    public void update() {
        for (DataPoll h : handlers) {
            h.poll(bot);
        }
    }
}
