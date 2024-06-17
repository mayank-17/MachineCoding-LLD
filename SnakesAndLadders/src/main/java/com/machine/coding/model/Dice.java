package com.machine.coding.model;

import java.util.Random;

public class Dice {
    private int die;
    public Dice(int die) {
        this.die = die;
    }
    Random random = new Random();
    public int rollDie() {
        if(die == 1) {
            return random.nextInt(6) + 1;
        } else {
            return random.nextInt(12) + 1;
        }
    }
}
