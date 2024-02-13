package app;

import controller.GameController;
import exception.DuplicateSymbolForPlayer;
import exception.MoreThanOneBotException;
import exception.PlayersAndBoardCountMismatch;
import models.*;
import strategy.ColWinningStrategy;
import strategy.DiagonalWinningStrategy;
import strategy.RowWinningStrategy;
import strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws PlayersAndBoardCountMismatch, DuplicateSymbolForPlayer, MoreThanOneBotException {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        int dimension = 3;
        ArrayList<Player> players = new ArrayList<>();

        players.add(new HumanPlayer('X', "Keerthi", 1, PlayerType.HUMAN,scanner));
        players.add(new HumanPlayer('0', "Abhi", 2, PlayerType.HUMAN,scanner));
//        players.add(new Bot('0', "GPT", 2, PlayerType.BOT, DifficultyLevel.EASY));

        ArrayList<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.createGame(dimension, players, winningStrategies);


        while(GameState.IN_PROG.equals(game.getGameState())) {
            gameController.printBoard(game);

            // if somebody wants to make an undo

            System.out.println("Does anyone want to undo ? (y/n");
            String undo = scanner.next();

            if(undo.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }

            gameController.makeMove(game);
        }

        if(GameState.CONCLUDED.equals(game.getGameState())){
            System.out.println(game.getWinner().getName()+" Has won the game");
        }
        if(GameState.DRAW.equals(game.getGameState())){
            System.out.println("It's a draw");
        }

    }
}
