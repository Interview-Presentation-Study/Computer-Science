package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
