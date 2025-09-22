package com.game;

import java.util.*;

public class Game {
    private int boardSize;
    private List<IPlayer> players;
    private Map<IPlayer, Integer> positions;
    private StartStrategy startStrategy;
    private WinningStrategy winningStrategy;

    protected Game(GameBuilder builder) {
        this.boardSize = builder.boardSize;
        this.players = builder.players;
        this.positions = new HashMap<>();
        this.startStrategy = builder.startStrategy;
        this.winningStrategy = builder.winningStrategy;

        for (IPlayer p : players) {
            positions.put(p, 0);
        }
    }

    public List<IPlayer> getPlayers() {
        return players;
    }

    public void playTurn(IPlayer player) {
        int diceRoll = Dice.getInstance().roll();
        System.out.println(player.getName() + " rolled a " + diceRoll);
        player.makeMove(diceRoll, this);
    }

    public void movePlayer(IPlayer player, int diceRoll) {
        int currentPos = positions.get(player);

        if (currentPos == 0 && !startStrategy.canStart(diceRoll)) {
            System.out.println(player.getName() + " cannot start yet!");
            return;
        }

        int newPos = currentPos + diceRoll;
        if (winningStrategy.hasWon(currentPos, diceRoll, boardSize)) {
            System.out.println(player.getName() + " wins the game!");
            positions.put(player, boardSize);
        } else if (newPos < boardSize) {
            positions.put(player, newPos);
            System.out.println(player.getName() + " moved to " + newPos);
        } else {
            System.out.println(player.getName() + " stays at " + currentPos);
        }
    }
}
