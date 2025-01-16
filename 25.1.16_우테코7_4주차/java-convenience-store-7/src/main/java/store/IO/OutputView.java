package store.IO;

import java.util.List;

public class OutputView {
    public static void printWelcomeMessage(){
        System.out.println("안녕하세요. W편의점입니다. 현재 보유하고 있는 상품입니다.");
    }
    public static void printProduceList(List<String> products){
        for(String product: products){
            System.out.println("-"+product);
        }
    }
    public static void printReceipt(String receipt){
        System.out.println("= ==========W편의점===========");
        System.out.println(receipt);
        System.out.println("==============================");
    }
    public static void printError(String errorMessage){
        System.out.println("[ERROR]"+errorMessage);
    }
    public static void printMessage(String message){
        System.out.println(message);
    }
}
