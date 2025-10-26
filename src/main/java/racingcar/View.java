package racingcar;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public static String[] inputCarNames() {
        String carNames = readLine();
        return carNames.split(",");
    }

    public static int inputRounds() {
        String rounds = readLine();
        return Integer.parseInt(rounds);
    }

    public static void printWinner(List<Car> winner) {
    }

    public static void printCarsPosition(List<Car> cars) {
    }

}
