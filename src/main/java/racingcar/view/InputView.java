package racingcar.view;

import racingcar.constant.ErrorMessage;
import racingcar.constant.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String DELIMITER = ",";

    public static String[] inputCarNames() {
        System.out.println(InputMessage.CAR_NAMES_PROMPT);
        String carNames = readLine();
        return carNames.split(DELIMITER);
    }

    public static int inputRounds() {
        System.out.println(InputMessage.ROUNDS_PROMPT);
        String rounds = readLine();
        try {
            int numberOfRounds = Integer.parseInt(rounds);
            return validateRoundOfNumber(numberOfRounds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_ERROR);
        }
    }

    private static int validateRoundOfNumber(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_ROUND_NUMBER_ERROR);
        }
        return numberOfRounds;
    }
}
