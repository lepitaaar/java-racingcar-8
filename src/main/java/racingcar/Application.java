package racingcar;

import racingcar.model.Game;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        int numberOfRounds = InputView.inputRounds();
        Game game = new Game(carNames, numberOfRounds, new RandomMoveStrategy());

        OutputView.printExecutionResultHeader();
        while (!game.isFinished()) {
            game.race();
            OutputView.printCarsPosition(game.getCars());
        }
        OutputView.printWinner(game.getWinner());
    }
}
