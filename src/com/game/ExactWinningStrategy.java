package com.game;

public class ExactWinningStrategy implements WinningStrategy {
    public boolean hasWon(int currentPos, int diceRoll, int boardSize) {
        return currentPos + diceRoll == boardSize;
    }
}
