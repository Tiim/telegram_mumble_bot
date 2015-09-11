package ch.tiim.datapoll;

import Murmur.User;
import ch.tiim.database.DatabaseManager;
import ch.tiim.murmur.IceController;
import ch.tiim.murmur.UserList;
import ch.tiim.telegram.TelegramBot;
import ch.tiim.utils.log.Log;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MurmurHandler implements DataPoll {
    private static final Log LOGGER = new Log(MurmurHandler.class);
    private final IceController ice;
    private final DatabaseManager db;
    private Collection<User> lastTimeOnline;

    public MurmurHandler(IceController ice, DatabaseManager db) {
        this.ice = ice;
        this.db = db;
        lastTimeOnline = new ArrayList<>();
        if (ice.isAvailable()) {
            lastTimeOnline = ice.getMumbleUsers();
        }
    }

    @Override
    public void poll(TelegramBot bot) {
        if (!ice.isAvailable()) {
            return;
        }
        try {
            Map<String, List<Integer>> hashDB = db.getTableMumbleSubscribe().getSubscribedUsers();
            Collection<User> usersIce = ice.getMumbleUsers();
            for (User uice : usersIce) {
                if (!UserList.listContainsUser(lastTimeOnline, uice)) {
                    //Subscription to user
                    if (hashDB.containsKey(uice.name)) {
                        for (int i : hashDB.get(uice.name)) {
                            try {
                                bot.sendMessage(i, uice.name + " went online!");
                            } catch (IOException e) {
                                LOGGER.info(e);
                            }
                        }
                    }
                    //Subscription to all
                    if (hashDB.containsKey("__all__")) {
                        for (int i : hashDB.get("__all__")) {
                            try {
                                bot.sendMessage(i, uice.name + " went online!");
                            } catch (IOException e) {
                                LOGGER.info(e);
                            }
                        }
                    }
                }
            }
            lastTimeOnline = usersIce;
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }
}
