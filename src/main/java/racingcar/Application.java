package racingcar;

import racingcar.constant.ErrorMessage;
import racingcar.model.Game;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        String stringNumberOfRounds = InputView.inputStringNumberOfRounds();
        int numberOfRounds = parseValidNumber(stringNumberOfRounds);

        Game game = new Game(carNames, numberOfRounds, new RandomMoveStrategy());

        OutputView.printExecutionResultHeader();
        while (!game.isFinished()) {
            game.race();
            OutputView.printCarsPosition(game.getCars());
        }

        OutputView.printWinner(game.getWinner());
    }

    private static int parseValidNumber(String stringNumber) {
        int numberOfRounds = parseNumber(stringNumber);
        validateNegativeNumber(numberOfRounds);

        return numberOfRounds;
    }

    private static int parseNumber(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_ERROR);
        }
    }

    private static void validateNegativeNumber(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_ROUND_NUMBER_ERROR);
        }
    }
}
