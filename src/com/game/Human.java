package com.game;

public class Human implements IPlayer {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeMove(int diceRoll, Game game) {
        game.movePlayer(this, diceRoll);
    }
}
