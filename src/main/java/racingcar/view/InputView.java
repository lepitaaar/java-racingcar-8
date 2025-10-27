package racingcar.view;

import racingcar.constant.ErrorMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String DELIMITER = ",";

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        return carNames.split(DELIMITER);
    }

    public static int inputRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
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
