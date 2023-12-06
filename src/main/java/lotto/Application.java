package lotto;


import lotto.configuration.ApplicationConfiguration;
import lotto.controller.FrontController;

public class Application {
    public static void main(String[] args) {
        FrontController frontController = new ApplicationConfiguration().frontController();
        frontController.run();
    }
}
