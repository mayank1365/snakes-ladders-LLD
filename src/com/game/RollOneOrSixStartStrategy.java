package com.game;

public class RollOneOrSixStartStrategy implements StartStrategy {
    public boolean canStart(int diceRoll) {
        return diceRoll == 1 || diceRoll == 6;
    }
}
