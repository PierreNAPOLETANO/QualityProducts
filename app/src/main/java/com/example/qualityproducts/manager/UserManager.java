package com.example.qualityproducts.manager;

import com.example.qualityproducts.model.User;

public class UserManager {
    private static UserManager instance;
    private User user;

    public static UserManager getInstance() {
        if (instance == null)
            instance = new UserManager();

        return instance;
    }

    public static void setInstance(UserManager instance) {
        UserManager.instance = instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
