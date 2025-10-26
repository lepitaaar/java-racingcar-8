package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Car> cars = new ArrayList<>();
    int numberOfRounds;

    public void setUp() {
        String[] carNames = View.inputCarNames();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        numberOfRounds = View.inputRounds();
    }

    public void start() {
        while (numberOfRounds > 0) {
            for (Car car : cars) {
                car.moveIfCan();
            }
            View.printCarsPosition(cars);
            numberOfRounds--;
        }
    }

    public void finish() {
        View.printWinner(cars);
    }
}
