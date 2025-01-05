package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    // 1. 자동차 이름을 부여
    public static String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요. ");
        String cars = Console.readLine();
        String carNames[] = ExceptionHandler.carNamesException(cars);
        return carNames;
    }
    // 3. 몇 번 이동할건지 입력
    public static Integer inputTryCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int tryCount = ExceptionHandler.Exception(input);
        return tryCount;
    }
}
