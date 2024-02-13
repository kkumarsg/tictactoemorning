package controller;

import exception.DuplicateSymbolForPlayer;
import exception.MoreThanOneBotException;
import exception.PlayersAndBoardCountMismatch;
import models.Game;
import models.Player;
import strategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> playerList,
                           List<WinningStrategy> winningStrategyList)
            throws PlayersAndBoardCountMismatch, DuplicateSymbolForPlayer, MoreThanOneBotException {

        return Game.getBuilder()
                .setPlayers(playerList)
                .setDimension(dimension)
                .setWinningStrategies(winningStrategyList)
                .build();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public void printBoard(Game game){

        game.printBoard();
    }


    public void undo(Game game) {

        game.undo();


    }















}
