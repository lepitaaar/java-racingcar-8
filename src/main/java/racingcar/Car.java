package racingcar;

public class Car {
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public void moveIfCan() {
        if (Random.isAvailableMove()) {
            this.position++;
        }
    }
}
