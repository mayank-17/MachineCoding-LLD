package com.machine.coding.model;

import java.util.HashMap;

public class Snake {
    private static HashMap<Integer,Integer> snakes;

    public Snake() {
        snakes = new HashMap<>();
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnake(int start, int end) {
        snakes.put(start, end);
    }

}
