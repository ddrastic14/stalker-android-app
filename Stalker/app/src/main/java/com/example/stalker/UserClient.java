package com.example.stalker;

import android.app.Application;
import com.example.stalker.models.User;


public class UserClient extends Application {
    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
