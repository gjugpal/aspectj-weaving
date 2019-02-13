package com.geek.aspects.app;

public class Homepage {

    private String username;

    public Homepage signin(String username, String password) {
        this.username = username;
        return this;
    }

    public String getCustomerMessage() {
        return "Welcome " + username;
    }

}
