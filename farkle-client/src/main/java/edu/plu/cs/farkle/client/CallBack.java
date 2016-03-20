package edu.plu.cs.farkle.client;

public interface CallBack {
    String login(String username, String password);
    String createAccount(String username, String password);
}