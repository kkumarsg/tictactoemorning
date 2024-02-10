package factories;

import models.DifficultyLevel;
import strategy.BotPlayingStrategy;
import strategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {


    public static BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel) {
        return new EasyBotPlayingStrategy();
    }
}
