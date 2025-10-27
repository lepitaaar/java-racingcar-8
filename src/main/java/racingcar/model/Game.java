package racingcar.model;

import racingcar.strategy.MoveStrategy;

import java.util.List;

public class Game {
    private final CarManager carManager;
    private int numberOfRounds;
    private final MoveStrategy moveStrategy;

    public Game(String[] carNames, int numberOfRounds, MoveStrategy moveStrategy) {
        carManager = new CarManager(carNames);
        this.numberOfRounds = numberOfRounds;
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        carManager.moveAllCars(moveStrategy);
        numberOfRounds--;
    }

    public boolean isFinished() {
        return numberOfRounds <= 0;
    }

    public List<Car> getWinner() {
        return carManager.getWinner();
    }

    public List<Car> getCars() {
        return carManager.getCars();
    }
}
