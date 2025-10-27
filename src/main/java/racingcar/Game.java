package racingcar;

import racingcar.strategy.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Car> cars = new ArrayList<>();
    int numberOfRounds;
    private final MoveStrategy moveStrategy;

    public Game(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void setUp() {
        String[] carNames = InputView.inputCarNames();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        numberOfRounds = InputView.inputRounds();
    }

    public void start() {
        while (numberOfRounds > 0) {
            moveCars();
            OutputView.printCarsPosition(cars);
            numberOfRounds--;
        }
        finish();
    }

    private void moveCars() {
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.move();
            }
        }
    }

    private List<Car> getWinner() {
        cars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
        int maxPosition = cars.getFirst().getPosition();
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car);
            }
        }
        return winner;
    }

    public void finish() {
        OutputView.printWinner(getWinner());
    }
}
