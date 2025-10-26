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
        View.printCarsPosition(cars);
    }

    public void finish() {
        View.printWinner(cars);
    }
}
