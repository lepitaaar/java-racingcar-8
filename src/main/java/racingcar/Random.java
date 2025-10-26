package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static boolean isAvailableMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        return randomNumber >= 4;
    }
}
