package racingcar;

import java.util.List;
import java.util.stream.Collectors;

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
        String winnerNames = winner.stream()
                .map(car -> car.name)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames);
    }

    public static void printCarsPosition(List<Car> cars) {
    }

}
