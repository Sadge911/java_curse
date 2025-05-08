// src/main/java/ru/easet/aviacassa/ui/controller/FlightDetailsController.java
package ru.easet.aviacassa.ui.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.easet.aviacassa.model.FlightTicket;
import ru.easet.aviacassa.model.ScheduledFlight;
import ru.easet.aviacassa.system.TicketBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class FlightDetailsController {
    private final TicketBookingSystem system;
    private final ScheduledFlight flight;

    @FXML private TextField tfNumber;
    @FXML private TextField tfDepartureCity;
    @FXML private TextField tfArrivalCity;
    @FXML private DatePicker dpDate;
    @FXML private TextField tfTime;
    @FXML private TextField tfPriceEco;
    @FXML private TextField tfPriceBiz;
    @FXML private TableView<FlightTicket> ticketsTable;
    @FXML private TableColumn<FlightTicket, String> colPassenger;
    @FXML private TableColumn<FlightTicket, String> colClass;
    @FXML private TableColumn<FlightTicket, Double> colPrice;
    @FXML private TableColumn<FlightTicket, String> colDate;

    public FlightDetailsController(TicketBookingSystem system, ScheduledFlight flight) {
        this.system = system;
        this.flight = flight;
    }

    @FXML
    public void initialize() {
        // заполняем поля
        tfNumber.setText(flight.getFlightNumber());
        tfDepartureCity.setText(flight.getDepartureCity());
        tfArrivalCity.setText(flight.getArrivalCity());
        dpDate.setValue(flight.getDepartureDateTime().toLocalDate());
        tfTime.setText(flight.getDepartureDateTime().toLocalTime().toString());


        tfPriceEco.setText(String.valueOf(flight.getBasePrice("Economy")));
        tfPriceBiz.setText(String.valueOf(flight.getBasePrice("Business")));

        // настраиваем таблицу билетов
        colPassenger.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getPassenger().getName()
                )
        );
        colClass.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getTicketClass()
                )
        );
        colPrice.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(
                        data.getValue().getPrice()
                )
        );
        colDate.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getPurchaseDate().toString()
                )
        );

        ticketsTable.setItems(
                FXCollections.observableArrayList(
                        system.getTicketsForFlight(flight.getFlightNumber())
                )
        );
    }

    /** Перезагрузить список проданных билетов для этого рейса. */
    private void refreshTickets() {
        ticketsTable.setItems(
                FXCollections.observableArrayList(
                        system.getTicketsForFlight(flight.getFlightNumber())
                )
        );
    }


    @FXML
    private void onSave() {
        try {
            flight.setDepartureCity(tfDepartureCity.getText());
            flight.setArrivalCity(tfArrivalCity.getText());

            LocalDate date = dpDate.getValue();
            LocalTime time = LocalTime.parse(tfTime.getText());
            flight.setDepartureDateTime(LocalDateTime.of(date, time));

            flight.setBasePrice("Economy", Double.parseDouble(tfPriceEco.getText()));
            flight.setBasePrice("Business", Double.parseDouble(tfPriceBiz.getText()));

            system.saveAllFlights();

            new Alert(Alert.AlertType.INFORMATION,
                    "Параметры рейса сохранены.").showAndWait();

            // Обновить таблицу билетов и закрыть окно
            refreshTickets();
            ((Stage) tfNumber.getScene().getWindow()).close();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Ошибка при сохранении: " + ex.getMessage())
                    .showAndWait();
        }
    }

    @FXML
    private void onClose() {
        ((Stage) tfNumber.getScene().getWindow()).close();
    }
}
