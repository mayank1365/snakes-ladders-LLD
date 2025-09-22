package com.game;

public interface IPlayer {
    String getName();

    void makeMove(int diceRoll, Game game);
}
