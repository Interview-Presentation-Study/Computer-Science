package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.service.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarNameValidator carNameValidator;

    private int count;

    public RaceController(InputView inputView, OutputView outputView, CarNameValidator carNameValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameValidator = carNameValidator;
    }

    public void run(){
        String input = inputView.inputCarNames();

        String[] carNames = input.split(",");
        carNameValidator.validate(carNames);
        count = inputView.inputCount();

        outputView.printResultStart();
        Cars cars = new Cars(carNames);
        cars.play(count);
        outputView.printFinalWinner(cars.winners());



    }
}
