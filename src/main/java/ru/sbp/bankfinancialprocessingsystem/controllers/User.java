package ru.sbp.bankfinancialprocessingsystem.controllers;

public class User{
    private final String username;
    private final String login;
    private final String password;

    public User(String username, String login, String password) {
        this.username = username;
        this.login = login;
        this.password = password;
    }
}
