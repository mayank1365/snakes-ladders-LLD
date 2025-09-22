package com.game;

public class Main {
    public static void main(String[] args) {
        Game game = new GameBuilder()
                .boardSize(100)
                .addPlayer(new Human("Alice"))
                .addPlayer(new Bot("Bot1"))
                .startStrategy(new RollOneOrSixStartStrategy())
                .winningStrategy(new FlexibleWinningStrategy())
                .build();

        int totalTurns = 10;
        int turn = 0;

        while (turn < totalTurns) {
            for (IPlayer player : game.getPlayers()) {
                System.out.println("\nTurn " + (turn + 1) + " - " + player.getName());
                game.playTurn(player);
            }
            turn++;
        }
    }
}
