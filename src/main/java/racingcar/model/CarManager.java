package racingcar.model;

import racingcar.constant.ErrorMessage;
import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarManager {
    private final static String NAME_REGEX = "[!@#$%^&*]";
    private final static Pattern pattern = Pattern.compile(NAME_REGEX);
    private static final int MAX_NAME_LENGTH = 5;

    private final List<Car> cars = new ArrayList<>();

    public CarManager(String[] carNames) {
        trimStringArray(carNames);
        validateDuplicateCarNames(carNames);
        for (String carName : carNames) {
            validateNameLength(carName);
            validateNameFormat(carName);
            cars.add(new Car(carName));
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

    public void moveAllCars(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            if (moveStrategy.isMovable()) {
                car.move();
            }
        }
    }

    private void trimStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
        }
    }

    private void validateDuplicateCarNames(String[] carNames) {
        boolean hasDuplicateNames = Arrays.stream(carNames).distinct().count() != carNames.length;

        if (hasDuplicateNames) throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME_ERROR);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException(String.format(ErrorMessage.CAR_NAME_LENGTH_ERROR, MAX_NAME_LENGTH));
        }
    }

    private void validateNameFormat(String name) {
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_FORMAT_ERROR);
        }
    }

}
