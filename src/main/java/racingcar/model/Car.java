package racingcar.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private final static String NAME_REGEX = "[!@#$%^&*]";
    private final static Pattern pattern = Pattern.compile(NAME_REGEX);

    private final String name;
    private int position;
    private static final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        validateNameLength(name);
        validateNameFormat(name);
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
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException(String.format("자동차 이름의 길이는 1~%d자 이내입니다.", MAX_NAME_LENGTH));
        }
    }

    private void validateNameFormat(String name) {
        Matcher matcher = pattern.matcher(name);
        if (matcher.find()) {
            throw new IllegalArgumentException("자동차 이름은 특수문자를 포함할 수 없습니다.");
        }
    }
}
