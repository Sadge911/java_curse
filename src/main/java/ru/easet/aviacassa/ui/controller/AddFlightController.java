package ru.easet.aviacassa.ui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.easet.aviacassa.model.Crew;
import ru.easet.aviacassa.model.ScheduledFlight;
import ru.easet.aviacassa.system.TicketBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Контроллер для формы добавления рейса.
 */
public class AddFlightController {
    private final TicketBookingSystem system;
    private final Runnable onSuccess;

    @FXML private TextField tfFlightNumber;
    @FXML private TextField tfDepartureCity;
    @FXML private TextField tfArrivalCity;
    @FXML private DatePicker dpDate;
    @FXML private TextField tfTime;
    @FXML private Spinner<Integer> spEconomy;
    @FXML private Spinner<Integer> spBusiness;
    @FXML private TextArea taCrew;
    @FXML private TextField tfPriceEco;
    @FXML private TextField tfPriceBiz;

    public AddFlightController(TicketBookingSystem system, Runnable onSuccess) {
        this.system = system;
        this.onSuccess = onSuccess;
    }

    @FXML
    public void initialize() {
        // Инициализируем спиннеры здесь, а не в FXML
        spEconomy.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 500, 100)
        );
        spBusiness.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 20)
        );
    }

    @FXML
    public void onSave() {
        try {
            String fn  = tfFlightNumber.getText();
            String dep = tfDepartureCity.getText();
            String arr = tfArrivalCity.getText();
            LocalDate date = dpDate.getValue();
            LocalTime time = LocalTime.parse(tfTime.getText());
            LocalDateTime dt = LocalDateTime.of(date, time);

            Map<String, Integer> seats = Map.of(
                    "Economy", spEconomy.getValue(),
                    "Business", spBusiness.getValue()
            );

            String[] parts = taCrew.getText().split(",");
            Crew crew = new Crew(
                    parts[0].trim(),
                    parts[1].trim(),
                    Arrays.asList(parts).subList(2, parts.length)
            );

            double priceE = Double.parseDouble(tfPriceEco.getText());
            double priceB = Double.parseDouble(tfPriceBiz.getText());

            system.addFlight(
                    new ScheduledFlight(fn, dep, arr, dt, seats, crew, priceE, priceB)
            );
            onSuccess.run();
            // закрываем диалог
            ((Stage) tfFlightNumber.getScene().getWindow()).close();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "Ошибка ввода: " + ex.getMessage())
                    .showAndWait();
        }
    }

    @FXML
    public void onCancel() {
        ((Stage) tfFlightNumber.getScene().getWindow()).close();
    }
}
