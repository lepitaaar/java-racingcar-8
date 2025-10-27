package racingcar.view;

import racingcar.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printWinner(List<Car> winner) {
        String winnerNames = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
