package com.machine.coding.model;

import java.util.Map;
import java.util.Scanner;

public class Game {
    Board board;
    Snake snakes;
    Ladder ladders;
    Player players;
    Dice die;
    public Game() {
        Scanner scan = new Scanner(System.in);

        // Take Board Input
        int sizeOfBoard = scan.nextInt();
        board = new Board(sizeOfBoard);

        // Take Snakes Input
        int noOfSnakes = scan.nextInt();
        snakes = new Snake();
        while (noOfSnakes > 0) {
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            snakes.setSnake(startPosition, endPosition);
            noOfSnakes--;
        }

        // Take Ladders Input
        int noOfLadders = scan.nextInt();
        ladders = new Ladder();
        while (noOfLadders > 0) {
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            ladders.setLadder(startPosition, endPosition);
            noOfLadders--;
        }

        // Take Players Input
        int noOfPlayers = scan.nextInt();
        players = new Player();
        while (noOfPlayers > 0) {
            String playerName = scan.next();
            players.setPlayer(playerName, 0);
            noOfPlayers--;
        }

        die = new Dice(2);
    }

    public int movePlayer(Player players, String playerName, int roll) {
        int previousPosition = players.getPlayers().get(playerName);
        if (previousPosition + roll > 100) {
            return previousPosition;
        } else if (ladders.getLadders().get(previousPosition + roll) != null) {
            return ladders.getLadders().get(previousPosition + roll);
        } else if (snakes.getSnakes().get(previousPosition + roll) != null) {
            return snakes.getSnakes().get(previousPosition + roll);
        }
        return previousPosition + roll;
    }

    public void play() {
        while (true) {
            for (Map.Entry<String, Integer> entry : players.getPlayers().entrySet()) {
                String playerName = entry.getKey();
                int position = entry.getValue();
                int roll = die.rollDie();
                int newPosition = movePlayer(players, playerName, roll);
                players.getPlayers().put(playerName, newPosition);
                System.out.println(playerName + " rolled a " + roll + " and moved from " + position + " to " + newPosition);
                if(newPosition == 100) {
                    System.out.println(playerName + " wins the game");
                    return;
                }
            }
        }
    }
}
