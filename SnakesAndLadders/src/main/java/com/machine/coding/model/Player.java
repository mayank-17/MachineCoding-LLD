package com.machine.coding.model;

import java.util.HashMap;

public class Player {
    private static HashMap<String, Integer> players;

    public Player() {
        players = new HashMap<>();
    }

    public HashMap<String, Integer> getPlayers() {
        return players;
    }

    public void setPlayer(String playerName, int position) {
        players.put(playerName, position);
    }

}
