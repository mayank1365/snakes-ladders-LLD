package com.game;

import java.util.*;

public class GameBuilder {
    int boardSize = 100;
    List<IPlayer> players = new ArrayList<>();
    StartStrategy startStrategy = new AnyStartStrategy();
    WinningStrategy winningStrategy = new ExactWinningStrategy();

    public GameBuilder boardSize(int size) {
        this.boardSize = size;
        return this;
    }

    public GameBuilder addPlayer(IPlayer player) {
        this.players.add(player);
        return this;
    }

    public GameBuilder startStrategy(StartStrategy s) {
        this.startStrategy = s;
        return this;
    }

    public GameBuilder winningStrategy(WinningStrategy s) {
        this.winningStrategy = s;
        return this;
    }

    public Game build() {
        if (players.isEmpty()) {
            throw new IllegalStateException("Game must have at least one player");
        }
        return new Game(this);
    }
}
