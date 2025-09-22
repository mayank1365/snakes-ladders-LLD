package com.game;

public class Bot implements IPlayer {
    private String name;

    public Bot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeMove(int diceRoll, Game game) {
        game.movePlayer(this, diceRoll);
    }
}
