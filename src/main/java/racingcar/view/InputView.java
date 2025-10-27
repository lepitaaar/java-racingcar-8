package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();
        return carNames.split(",");
    }

    public static int inputRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String rounds = readLine();
        return validateRoundOfNumber(Integer.parseInt(rounds));
    }

    private static int validateRoundOfNumber(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new IllegalArgumentException();
        }
        return numberOfRounds;
    }
}
