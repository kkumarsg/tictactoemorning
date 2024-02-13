package strategy;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{

    Map<Character, Integer> leftDiaMpa = new HashMap<>();
    Map<Character, Integer> rightDiaMpa = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Character symbol = move.getPlayer().getSymbol();

        // check if the move was part of left diagonal ?
        if(row==col){
            // check if we're putting this symbol for the first time in this diagonal
            if(!leftDiaMpa.containsKey(symbol)){
                leftDiaMpa.put(symbol, 0);
            }
            leftDiaMpa.put(symbol, leftDiaMpa.get(symbol)+1);

            // check if entire diagonal is filled with this symbol
            if(leftDiaMpa.get(symbol).equals(board.getDimension())){
                return true;
            }
        }

        // check if the move was part of right diagonal ?
        if(row+col==(board.getDimension()-1)){
            // check if we're putting symbol for the first time in this diagona
            if(!rightDiaMpa.containsKey(symbol)){
                rightDiaMpa.put(symbol, 0);
            }
            rightDiaMpa.put(symbol, rightDiaMpa.get(symbol)+1);

            // check if entire diagonal is filled with this symbol
            if(rightDiaMpa.get(symbol).equals(board.getDimension())){
                return true;
            }
        }

        return false;

    }













}
