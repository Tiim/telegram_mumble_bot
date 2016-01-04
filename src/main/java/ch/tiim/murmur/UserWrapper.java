package ch.tiim.murmur;

import Murmur.User;

public class UserWrapper {
    private User user;

    public UserWrapper(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object uw) {
        if (!(uw instanceof UserWrapper)) {
            return false;
        }
        UserWrapper o = (UserWrapper) uw;
        User u = o.getUser();
        return user.name.equals(u.name);
    }
}
