package store.controller;

import store.IO.InputView;
import store.IO.OutputView;
import store.service.Service;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void run(){
        OutputView.printWelcomeMessage();
        OutputView.printProduceList(service.getAvailableProducts());

        while(true){
            try {
                String purchaseInput = InputView.readPurchaseInput();
                String receipt = service.processPurchase(purchaseInput);

                OutputView.printReceipt(receipt);

                String continuePurchase = InputView.readYesNoInput("구매를 계속 하시겠습니까?");
                if("N".equals(continuePurchase)) break;
            } catch(IllegalArgumentException e){
                OutputView.printError(e.getMessage());
            }
        }
        OutputView.printMessage("감사합니다. 다음에 또 방문해주세요!");
    }
}
