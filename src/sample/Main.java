package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.controller.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller();
        controller.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
