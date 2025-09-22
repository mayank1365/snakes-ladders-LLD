# Snakes and Ladders UML Diagram 

```mermaid
classDiagram
    class Game {
        -Board board
        -List~IPlayer~ players
        -IStartStrategy startStrategy
        -IWinningStrategy winningStrategy
        +playTurn(player: IPlayer): voida
        +getPlayers(): List~IPlayer~
    }

    class GameBuilder {
        -int boardSize
        -List~IPlayer~ players
        -IStartStrategy startStrategy
        -IWinningStrategy winningStrategy
        +boardSize(size: int): GameBuilder
        +addPlayer(player: IPlayer): GameBuilder
        +startStrategy(strategy: IStartStrategy): GameBuilder
        +winningStrategy(strategy: IWinningStrategy): GameBuilder
        +build(): Game
    }

    class Board {
        -int size
        -Map~int,int~ snakes
        -Map~int,int~ ladders
        +getNextPosition(position: int): int
    }

    class IPlayer {
        <<interface>>
        +getName(): String
        +getPosition(): int
        +setPosition(pos: int): void
    }

    class Human {
        -String name
        -int position
    }

    class Bot {
        -String name
        -int position
    }

    class IStartStrategy {
        <<interface>>
        +canStart(roll: int): boolean
    }

    class AnyNumberStartStrategy
    class RollOneOrSixStartStrategy

    class IWinningStrategy {
        <<interface>>
        +hasWon(position: int, boardSize: int): boolean
    }

    class ExactMatchWinningStrategy
    class FlexibleWinningStrategy

    class DiceService {
        -static DiceService instance
        +getInstance(): DiceService
        +roll(): int
    }

    %% Relationships
    Game --> Board
    Game --> IPlayer
    Game --> IStartStrategy
    Game --> IWinningStrategy
    GameBuilder --> Game
    Human ..|> IPlayer
    Bot ..|> IPlayer
    AnyNumberStartStrategy ..|> IStartStrategy
    RollOneOrSixStartStrategy ..|> IStartStrategy
    ExactMatchWinningStrategy ..|> IWinningStrategy
    FlexibleWinningStrategy ..|> IWinningStrategy
    Game --> DiceService : uses
