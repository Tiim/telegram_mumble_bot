package ch.tiim.datapoll;

import Murmur.User;
import ch.tiim.murmur.IceController;
import ch.tiim.murmur.UserWrapper;
import ch.tiim.telegram.TelegramBot;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MurmurHandler implements DataPoll {
    private static final Logger LOGGER = Logger.getLogger(MurmurHandler.class.getName());
    private final IceController ice;
    private Collection<UserWrapper> lastTimeOnline;

    public MurmurHandler(IceController ice) {
        this.ice = ice;
        if (ice.isAvailable()) {
            lastTimeOnline = ice.getMumbleUsers();
        } else {
            lastTimeOnline = new ArrayList<>();
        }
    }

    @Override
    public void poll(TelegramBot bot, String[] recipients) {
        if (!ice.isAvailable()) {
            return;
        }
        Collection<UserWrapper> usersIce = ice.getMumbleUsers();
        Collection<UserWrapper> offline = getNewOffline(usersIce, lastTimeOnline);
        Collection<UserWrapper> online = getNewOnline(usersIce, lastTimeOnline);

        if (!online.isEmpty() || !offline.isEmpty())
            for (String rec : recipients) {
                try {
                    bot.sendMessageMarkdown(rec, makeMessage(online, offline, usersIce));
                } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "Can't send message to " + rec, e);
                }
            }

        lastTimeOnline = usersIce;
    }

    private Collection<UserWrapper> getNewOffline(Collection<UserWrapper> now, Collection<UserWrapper> lastTimt) {
        Collection<UserWrapper> copy = lastTimeOnline.stream().collect(Collectors.toList());
        copy.removeAll(now);
        return copy;
    }

    private Collection<UserWrapper> getNewOnline(Collection<UserWrapper> now, Collection<UserWrapper> lastTimt) {
        Collection<UserWrapper> copy = now.stream().collect(Collectors.toList());
        copy.removeAll(lastTimt);
        return copy;
    }

    private String makeMessage(Collection<UserWrapper> online, Collection<UserWrapper> offline, Collection<UserWrapper> usersIce) {
        StringBuilder s = new StringBuilder();
        for (UserWrapper u : online) {
            s.append("\u2705 ").append(u.getUser().name).append(" is now online\n");
        }
        for (UserWrapper u : offline) {
            s.append("\u274C ").append(u.getUser().name).append(" is now offline\n");
        }
        if (!usersIce.isEmpty()) {
            s.append("These are all online users:\n");
            for (UserWrapper uw : usersIce) {
                User u = uw.getUser();
                s.append("\uD83D\uDD39 ").append(u.name);
                if (u.selfDeaf || u.deaf) {
                    s.append("\uD83D\uDE4A");
                } else {
                    s.append("\uD83D\uDD0A");
                }
                if (u.selfMute || u.mute) {
                    s.append("\uD83D\uDE49");
                } else {
                    s.append("\uD83C\uDFA4"); //not muterd
                }
                s.append("\n");
            }
        } else {
            s.append("Nobody else is online\uD83D\uDE22");
        }
        s.append("\n*").append(countdownString(LocalDateTime.of(2016, 1, 9, 12, 0)))
                .append("* until this mumble server will be shut down. Ask @TiimB if you want to host the server.");

        return s.toString();
    }


    private String countdownString(LocalDateTime date) {
        Duration d = Duration.between(LocalDateTime.now(), date);
        System.out.println(d);
        StringBuilder b = new StringBuilder();
        b.append(d.toDays()).append(" Days ");
        d = d.minusDays(d.toDays());
        b.append(d.toHours()).append("h ");
        d = d.minusHours(d.toHours());
        b.append(d.toMinutes()).append("min");
        return b.toString();
    }
}
