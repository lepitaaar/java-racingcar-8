package racingcar;

import racingcar.strategy.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(new RandomMoveStrategy());
        game.setUp();
        game.start();
    }
}
