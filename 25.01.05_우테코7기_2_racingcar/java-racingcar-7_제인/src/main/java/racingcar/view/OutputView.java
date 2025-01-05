package racingcar.view;

import java.util.List;

public class OutputView {
    public void printResultStart(){
        System.out.println("\n실행결과");
    }

    public void printFinalWinner(String winner){
        System.out.println("최종 우승자 : "+winner);
    }
}
