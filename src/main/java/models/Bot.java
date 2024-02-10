package models;

import factories.BotPlayingStrategyFactory;
import strategy.BotPlayingStrategy;

public class Bot extends Player{

    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Character symbol, String name, int id, PlayerType playerType, DifficultyLevel difficultyLevel) {
        super(symbol, name, id, playerType);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
