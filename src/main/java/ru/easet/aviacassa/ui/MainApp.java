package ru.easet.aviacassa.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.easet.aviacassa.system.TicketBookingSystem;
import ru.easet.aviacassa.ui.controller.FlightListController;

public class MainApp extends Application {
    private TicketBookingSystem system;

    @Override
    public void init() {
        // Загружаем сохранённые рейсы и билеты
        system = new TicketBookingSystem();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/FlightList.fxml")
        );
        // Передаём систему в контроллер
        loader.setControllerFactory(param -> new FlightListController(system));

        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Авиакасса (JavaFX)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
