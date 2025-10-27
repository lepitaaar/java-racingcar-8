package racingcar.model;

import racingcar.constant.ErrorMessage;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Car> cars = new ArrayList<>();
    private int numberOfRounds;
    private final MoveStrategy moveStrategy;

    public Game(String[] carNames, int numberOfRounds, MoveStrategy moveStrategy) {
        validateDuplicateCarNames(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
        this.numberOfRounds = numberOfRounds;
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        moveCars();
        numberOfRounds--;
    }

    private void moveCars() {
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.move();
            }
        }
    }

    public List<Car> getWinner() {
        cars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
        int maxPosition = cars.getFirst().getPosition();
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winner.add(car);
            }
        }
        return Collections.unmodifiableList(winner);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public boolean isFinished() {
        return numberOfRounds <= 0;
    }

    private void validateDuplicateCarNames(String[] carNames) {
        boolean hasDuplicateNames = Arrays.stream(carNames).distinct().count() != carNames.length;

        if (hasDuplicateNames) throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_ERROR);
    }
}
