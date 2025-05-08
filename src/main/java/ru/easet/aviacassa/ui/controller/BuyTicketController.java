package ru.easet.aviacassa.ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.easet.aviacassa.model.Passenger;
import ru.easet.aviacassa.model.ScheduledFlight;
import ru.easet.aviacassa.model.FlightTicket;
import ru.easet.aviacassa.system.TicketBookingSystem;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Контроллер для диалога покупки билета.
 */
public class BuyTicketController implements Initializable {
    private final TicketBookingSystem system;
    private final ScheduledFlight flight;

    /** Формат для ручного ввода даты dd.MM.yyyy */
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @FXML private TextField         tfFlightNumber;
    @FXML private ComboBox<String>  cbTicketClass;
    @FXML private TextField         tfName;
    @FXML private DatePicker        dpBirthDate;
    @FXML private TextField         tfPassport;

    /**
     * @param system система продажи билетов
     * @param flight выбранный рейс
     */
    public BuyTicketController(TicketBookingSystem system, ScheduledFlight flight) {
        this.system = system;
        this.flight = flight;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // проставляем поля по умолчанию
        tfFlightNumber.setText(flight.getFlightNumber());
        cbTicketClass.getItems().setAll("Economy", "Business");
        cbTicketClass.getSelectionModel().selectFirst();

        // настраиваем DatePicker на формат dd.MM.yyyy
        dpBirthDate.setPromptText("dd.MM.yyyy");
        dpBirthDate.setConverter(new javafx.util.StringConverter<>() {
            @Override
            public String toString(LocalDate date) {
                return date != null ? FORMAT.format(date) : "";
            }
            @Override
            public LocalDate fromString(String text) {
                if (text == null || text.isBlank()) return null;
                return LocalDate.parse(text, FORMAT);
            }
        });
    }

    /**
     * Обработчик кнопки "Купить".
     */
    @FXML
    public void onBuy() {
        try {
            // Форсируем парсинг даты из редактора
            String dateText = dpBirthDate.getEditor().getText();
            if (dateText != null && !dateText.isBlank()) {
                dpBirthDate.setValue(LocalDate.parse(dateText, FORMAT));
            }

            // Валидация полей
            String name        = tfName.getText().trim();
            LocalDate birth    = dpBirthDate.getValue();
            String passport    = tfPassport.getText().trim();
            String ticketClass = cbTicketClass.getValue();

            if (name.isEmpty() || birth == null || passport.isEmpty()) {
                throw new IllegalArgumentException("Заполните все поля пассажира.");
            }

            Passenger passenger = new Passenger(name, birth, passport);
            // Пробуем продать билет — метод бросит исключение при ошибке
            FlightTicket ticket = system.sellTicket(passenger, flight, ticketClass, LocalDate.now());

            new Alert(Alert.AlertType.INFORMATION,
                    "Билет куплен! Цена: " + ticket.getPrice()).showAndWait();
            close();
        } catch (IllegalArgumentException ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "Ошибка: " + ex.getMessage()).showAndWait();
        }
    }

    @FXML
    public void onCancel() {
        close();
    }

    private void close() {
        ((Stage) tfFlightNumber.getScene().getWindow()).close();
    }
}
