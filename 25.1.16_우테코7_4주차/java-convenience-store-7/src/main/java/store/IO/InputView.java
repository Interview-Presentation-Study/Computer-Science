package store.IO;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String input = Console.readLine();
    public static String readPurchaseInput(){
        System.out.println("구매하실 상품명과 수량을 입력해주세요. (예:[사이다-2], [감자칩-1])");
        return input;
    }
    public static String readYesNoInput(String message){
        System.out.println(message+"(Y/N)");
        return input.trim().toUpperCase();
    }
}
