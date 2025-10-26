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

    public List<Car> getWinner() {
        cars.sort((car1, car2) -> car2.position - car1.position);
        int maxPosition = cars.getFirst().position;
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.position == maxPosition) {
                winner.add(car);
            }
        }
        return winner;
    }

    public void finish() {
        View.printWinner(getWinner());
    }
}
