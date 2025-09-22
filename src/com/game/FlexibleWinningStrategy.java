package com.game;

public class FlexibleWinningStrategy implements WinningStrategy {
    public boolean hasWon(int currentPos, int diceRoll, int boardSize) {
        return currentPos + diceRoll >= boardSize;
    }
}
