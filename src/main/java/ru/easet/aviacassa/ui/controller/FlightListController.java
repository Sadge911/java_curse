package ru.easet.aviacassa.ui.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import ru.easet.aviacassa.model.Flight;
import ru.easet.aviacassa.model.FlightTicket;
import ru.easet.aviacassa.model.ScheduledFlight;
import ru.easet.aviacassa.system.TicketBookingSystem;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 * Контроллер главного окна с таблицей рейсов.
 */
public class FlightListController {
    private final TicketBookingSystem system;

    @FXML private BorderPane rootPane;
    @FXML private TableView<Flight> flightTable;
    @FXML private TableColumn<Flight, String> colNumber;
    @FXML private TableColumn<Flight, String> colRoute;
    @FXML private TableColumn<Flight, String> colTime;
    @FXML private TableColumn<Flight, Integer> colSeatsEco;
    @FXML private TableColumn<Flight, Integer> colSeatsBiz;
    @FXML private Button btnAddFlight;
    @FXML private Button btnBuyTicket;
    @FXML private Button btnViewFlight;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public FlightListController(TicketBookingSystem system) {
        this.system = system;
    }

    @FXML
    public void initialize() {
        colNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        colRoute.setCellValueFactory(data ->
                javafx.beans.binding.Bindings.createStringBinding(
                        () -> data.getValue().getDepartureCity() + " → " + data.getValue().getArrivalCity()
                )
        );
        colTime.setCellValueFactory(data ->
                javafx.beans.binding.Bindings.createStringBinding(
                        () -> data.getValue().getDepartureDateTime().format(dtf)
                )
        );
        colSeatsEco.setCellValueFactory(data ->
                new SimpleIntegerProperty(
                        data.getValue().getAvailableSeats("Economy")
                ).asObject()
        );
        colSeatsBiz.setCellValueFactory(data ->
                new SimpleIntegerProperty(
                        data.getValue().getAvailableSeats("Business")
                ).asObject()
        );

        refreshTable();

        btnAddFlight.setOnAction(e -> openAddFlightDialog());
        btnBuyTicket.setOnAction(e -> openBuyTicketDialog());
        btnViewFlight.setOnAction(e -> openViewFlightDialog());
    }

    private void refreshTable() {
        flightTable.setItems(
                FXCollections.observableArrayList(system.getAllFlights())
        );
    }

    private void openViewFlightDialog() {
        Flight sel = flightTable.getSelectionModel().getSelectedItem();
        if (!(sel instanceof ScheduledFlight)) {
            new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING,
                    "Пожалуйста, выберите рейс в таблице.").showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/FlightDetailDialog.fxml")
            );
            loader.setControllerFactory(c ->
                    new FlightDetailsController(system, (ScheduledFlight) sel)
            );
            Scene scene = new Scene(loader.load());
            Stage dlg = new Stage();
            dlg.initOwner(rootPane.getScene().getWindow());
            dlg.initModality(Modality.APPLICATION_MODAL);
            dlg.setTitle("Детали рейса " + sel.getFlightNumber());
            dlg.setScene(scene);
            dlg.showAndWait();
            // после закрытия обновляем таблицу
            refreshTable();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void openAddFlightDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/AddFlightDialog.fxml")
            );
            loader.setControllerFactory(c -> new AddFlightController(system, this::refreshTable));
            Scene scene = new Scene(loader.load());
            Stage dlg = new Stage();
            dlg.initOwner(rootPane.getScene().getWindow());
            dlg.initModality(Modality.APPLICATION_MODAL);
            dlg.setTitle("Добавить рейс");
            dlg.setScene(scene);
            dlg.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Открывает диалог покупки билета для выбранного рейса.
     */
    private void openBuyTicketDialog() {
        Flight sel = flightTable.getSelectionModel().getSelectedItem();
        if (!(sel instanceof ScheduledFlight)) {
            new Alert(Alert.AlertType.WARNING,
                    "Сначала выберите рейс в таблице.").showAndWait();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/BuyTicketDialog.fxml")
            );
            loader.setControllerFactory(c ->
                    new BuyTicketController(system, (ScheduledFlight) sel)
            );
            Stage dlg = new Stage();
            dlg.initOwner(rootPane.getScene().getWindow());
            dlg.initModality(Modality.APPLICATION_MODAL);
            dlg.setTitle("Купить билет на рейс " + sel.getFlightNumber());
            dlg.setScene(new Scene(loader.load()));
            dlg.showAndWait();
            // После покупки можно обновить таблицу свободных мест:
            refreshTable();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
