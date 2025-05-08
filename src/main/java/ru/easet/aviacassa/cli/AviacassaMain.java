package ru.easet.aviacassa.cli;

import ru.easet.aviacassa.model.Crew;
import ru.easet.aviacassa.model.Flight;
import ru.easet.aviacassa.model.FlightTicket;
import ru.easet.aviacassa.model.Passenger;
import ru.easet.aviacassa.model.ScheduledFlight;
import ru.easet.aviacassa.system.TicketBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class AviacassaMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketBookingSystem system = new TicketBookingSystem();

        // Пример добавления рейса при старте
        //todo Нет проверок на 2й такой же рейс (дубль)
//
//        Map<String, Integer> seats = new HashMap<>();
//        seats.put("Economy", 100);
//        seats.put("Business", 20);
//        Crew crew = new Crew(
//                "Иванов Иван",
//                "Королёв Александр",
//                Arrays.asList("Никитина Марина", "Ломцева Галина")
//        );
//        ScheduledFlight sampleFlight = new ScheduledFlight(
//                "SU100",
//                "Москва",
//                "Париж",
//                LocalDateTime.of(2025, 6, 15, 10, 30),
//                seats,
//                crew,
//                100.0,
//                250.0
//        );
//        system.addFlight(sampleFlight);

        while (true) {
            System.out.println("\n=== Авиакасса ===");
            System.out.println("1. Добавить рейс");
            System.out.println("2. Поиск рейсов");
            System.out.println("3. Купить билет");
            System.out.println("4. Показать все рейсы");
            System.out.println("5. Показать все проданные билеты");
            System.out.println("6. Выход");
            System.out.print("Выберите опцию: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Введите цифру от 1 до 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Добавление нового рейса
                    System.out.print("Номер рейса: ");
                    String fn = scanner.nextLine();
                    System.out.print("Город отправления: ");
                    String dep = scanner.nextLine();
                    System.out.print("Город прибытия: ");
                    String arr = scanner.nextLine();
                    System.out.print("Дата вылета (YYYY-MM-DD): ");
                    LocalDate depDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Время вылета (HH:MM): ");
                    LocalTime depTime = LocalTime.parse(scanner.nextLine());
                    LocalDateTime dt = LocalDateTime.of(depDate, depTime);

                    System.out.print("Места Economy: ");
                    int eco = Integer.parseInt(scanner.nextLine());
                    System.out.print("Места Business: ");
                    int biz = Integer.parseInt(scanner.nextLine());
                    Map<String, Integer> newSeats = new HashMap<>();
                    newSeats.put("Economy", eco);
                    newSeats.put("Business", biz);

                    System.out.print("Имя пилота: ");
                    String pilot = scanner.nextLine();
                    System.out.print("Имя второго пилота: ");
                    String copilot = scanner.nextLine();
                    System.out.print("Стюарды через запятую: ");
                    List<String> attendants = Arrays.asList(scanner.nextLine().split(","));
                    Crew newCrew = new Crew(pilot, copilot, attendants);

                    System.out.print("Базовая цена Economy: ");
                    double bpE = Double.parseDouble(scanner.nextLine());
                    System.out.print("Базовая цена Business: ");
                    double bpB = Double.parseDouble(scanner.nextLine());

                    ScheduledFlight newFlight = new ScheduledFlight(
                            fn, dep, arr, dt, newSeats, newCrew, bpE, bpB
                    );
                    system.addFlight(newFlight);
                    System.out.println("Рейс добавлен.");
                    break;

                case 2:
                    // Поиск рейсов по параметрам
                    System.out.print("Город отправления: ");
                    String sDep = scanner.nextLine();
                    System.out.print("Город прибытия: ");
                    String sArr = scanner.nextLine();
                    System.out.print("Дата полета (YYYY-MM-DD): ");
                    LocalDate travelDate = LocalDate.parse(scanner.nextLine());
                    System.out.print("Класс билета (Economy/Business): ");
                    String tClass = scanner.nextLine();

                    List<Flight> found = system.findSuitableFlights(
                            sDep, sArr, travelDate, tClass
                    );
                    if (found.isEmpty()) {
                        System.out.println("Рейсы не найдены.");
                    } else {
                        for (Flight f : found) {
                            system.displayFlightInfo(f);
                        }
                    }
                    break;

                case 3:
                    // Покупка билета
                    System.out.print("Имя пассажира: ");
                    String name = scanner.nextLine();
                    System.out.print("Дата рождения (YYYY-MM-DD): ");
                    LocalDate bd = LocalDate.parse(scanner.nextLine());
                    System.out.print("Номер паспорта: ");
                    String pass = scanner.nextLine();
                    Passenger p = new Passenger(name, bd, pass);

                    System.out.print("Номер рейса: ");
                    String flightNum = scanner.nextLine();
                    Optional<Flight> opt = system.findFlightByNumber(flightNum);
                    if (opt.isEmpty() || !(opt.get() instanceof ScheduledFlight)) {
                        System.out.println("Рейс не найден.");
                        break;
                    }
                    ScheduledFlight flightToBook = (ScheduledFlight) opt.get();

                    System.out.print("Класс билета (Economy/Business): ");
                    String ticketClass = scanner.nextLine();
                    system.sellTicket(p, flightToBook, ticketClass, LocalDate.now());
                    break;

                case 4:
                    // Показать все рейсы
                    List<Flight> allFlights = system.getAllFlights();
                    if (allFlights.isEmpty()) {
                        System.out.println("Рейсов пока нет.");
                    } else {
                        System.out.println("Список всех рейсов:");
                        for (Flight f : allFlights) {
                            system.displayFlightInfo(f);
                        }
                    }
                    break;

                case 5:
                    // Показать все проданные билеты
                    List<FlightTicket> allTickets = system.getAllTickets();
                    if (allTickets.isEmpty()) {
                        System.out.println("Билетов пока нет.");
                    } else {
                        System.out.println("Список проданных билетов:");
                        for (FlightTicket t : allTickets) {
                            System.out.printf(
                                    "Пассажир: %s, Рейс: %s, Класс: %s, Цена: %.2f, Дата покупки: %s%n",
                                    t.getPassenger().getName(),
                                    t.getFlight().getFlightNumber(),
                                    t.getTicketClass(),
                                    t.getPrice(),
                                    t.getPurchaseDate()
                            );
                        }
                    }
                    break;

                case 6:
                    System.out.println("Выход.");
                    System.exit(0);

                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }
        }
    }
}
