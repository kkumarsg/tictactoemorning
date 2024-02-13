package strategy;

import models.Board;
import models.Cell;
import models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    // return the first empty cell
    @Override
    public Cell makeMove(Board board) {
        for(List<Cell> row: board.getBoard()){
            for(Cell cell: row){
                if (CellState.EMPTY.equals(cell.getCellState())) {
                    return cell;
                }
            }
        }
        return null;
    }
}
