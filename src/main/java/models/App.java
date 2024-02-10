package models;

import controller.GameController;
import exception.DuplicateSymbolForPlayer;
import exception.MoreThanOneBotException;
import exception.PlayersAndBoardCountMismatch;
import strategy.ColWinningStrategy;
import strategy.DiagonalWinningStrategy;
import strategy.RowWinningStrategy;
import strategy.WinningStrategy;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws PlayersAndBoardCountMismatch, DuplicateSymbolForPlayer, MoreThanOneBotException {

        GameController gameController = new GameController();

        int dimension = 3;
        ArrayList<Player> players = new ArrayList<>();

        players.add(new HumanPlayer('X', "Keerthi", 1, PlayerType.HUMAN));
        players.add(new Bot('0', "GPT", 2, PlayerType.BOT, DifficultyLevel.EASY));
        players.add(new HumanPlayer('K', "Murali", 3, PlayerType.HUMAN));

        ArrayList<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.createGame(dimension, players, winningStrategies);
        gameController.printBoard(game);
    }
}
