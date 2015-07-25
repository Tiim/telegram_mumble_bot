package ch.tiim.murmur;

import Murmur.User;

import java.util.Collection;

public class UserList {

    public static boolean listContainsUser(Collection<User> c, User u) {
        for(User usr : c) {
            if (usr.session == u.session) {
                return true;
            }
        }
        return false;
    }

}
