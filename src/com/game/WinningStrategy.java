package com.game;

public interface WinningStrategy {
    boolean hasWon(int currentPos, int diceRoll, int boardSize);
}
