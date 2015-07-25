package ch.tiim.datapoll;

import ch.tiim.telegram.TelegramBot;

public interface DataPoll {
    void poll(TelegramBot bot);
}
