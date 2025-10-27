package racingcar.view;

import racingcar.constant.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String DELIMITER = ",";

    public static String[] inputCarNames() {
        System.out.println(InputMessage.CAR_NAMES_PROMPT);
        String carNames = readLine();
        return carNames.split(DELIMITER);
    }

    public static String inputStringNumberOfRounds() {
        System.out.println(InputMessage.ROUNDS_PROMPT);

        return readLine();
    }
}
