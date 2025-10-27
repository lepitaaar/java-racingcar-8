package racingcar;

public class Car {
    private final String name;
    private int position;
    final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
