package racingcar.constant;

public final class ErrorMessage {

    public static final String CAR_NAME_LENGTH_ERROR = "자동차 이름의 길이는 1~%d자 이내입니다.";
    public static final String CAR_NAME_FORMAT_ERROR = "자동차 이름은 특수문자를 포함할 수 없습니다.";
    public static final String DUPLICATE_CAR_NAME_ERROR = "중복된 자동차 이름이 존재합니다.";
    public static final String INVALID_NUMBER_ERROR = "유효한 숫자를 입력해야합니다.";
    public static final String NEGATIVE_ROUND_NUMBER_ERROR = "레이싱 횟수는 음수가 될 수 없습니다.";

    private ErrorMessage() {
    }
}
