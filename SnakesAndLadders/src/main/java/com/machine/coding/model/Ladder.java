package com.machine.coding.model;

import java.util.HashMap;

public class Ladder {
    private static HashMap<Integer, Integer> ladders;

    public Ladder() {
        ladders = new HashMap<>();
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadder(int start, int end) {
        ladders.put(start, end);
    }

}
