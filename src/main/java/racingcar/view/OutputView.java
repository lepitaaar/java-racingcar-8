package racingcar.view;

import racingcar.constant.OutputMessage;
import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printWinner(List<Car> winner) {
        String winnerNames = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.printf(OutputMessage.WINNER_MESSAGE + "\n", winnerNames);
    }

    public static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf(OutputMessage.CAR_POSITION_MESSAGE, car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printExecutionResultHeader() {
        System.out.print(OutputMessage.EXECUTION_RESULT_HEADER);
    }
}
