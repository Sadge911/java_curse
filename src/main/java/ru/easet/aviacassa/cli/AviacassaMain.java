package ru.easet.aviacassa.cli;

import ru.easet.aviacassa.model.Crew;
import ru.easet.aviacassa.model.Flight;
import ru.easet.aviacassa.model.Passenger;
import ru.easet.aviacassa.model.ScheduledFlight;
import ru.easet.aviacassa.search.FlightSearchImpl;
import ru.easet.aviacassa.system.TicketBookingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class AviacassaMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketBookingSystem system = new TicketBookingSystem();

        // Пример добавления рейса
        Map<String, Integer> seats = new HashMap<>();
        seats.put("Economy", 100);
        seats.put("Business", 20);
        Crew crew = new Crew("Иванов Иван", "Королёв Александр", Arrays.asList("Никитина Марина", "Ломцева Галина"));
        ScheduledFlight sampleFlight = new ScheduledFlight(
                "SU100", "Москва", "Париж",
                LocalDateTime.of(2025, 6, 15, 10, 30), seats, crew, 100.0, 250.0);
        system.addFlight(sampleFlight);

        while (true) {
            System.out.println("\n=== Авиакасса ===");
            System.out.println("1. Добавить рейс");
            System.out.println("2. Поиск рейсов");
            System.out.println("3. Купить билет");
            System.out.println("4. Выход");
            System.out.print("Выберите опцию: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Номер рейса: ");
                    String fn = scanner.nextLine();
                    System.out.print("Город отправления: ");
                    String dep = scanner.nextLine();
                    System.out.print("Город прибытия: ");
                    String arr = scanner.nextLine();
                    // разделяем ввод даты и времени
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
                    String pil = scanner.nextLine();
                    System.out.print("Имя второго пилота: ");
                    String cop = scanner.nextLine();
                    System.out.print("Стюарды через запятую: ");
                    List<String> ats = Arrays.asList(scanner.nextLine().split(","));
                    Crew newCrew = new Crew(pil, cop, ats);

                    System.out.print("Базовая цена Economy: ");
                    double bpE = Double.parseDouble(scanner.nextLine());
                    System.out.print("Базовая цена Business: ");
                    double bpB = Double.parseDouble(scanner.nextLine());

                    system.addFlight(new ScheduledFlight(fn, dep, arr, dt, newSeats, newCrew, bpE, bpB));
                    System.out.println("Рейс добавлен.");
                    break;
                case 2:
                    System.out.print("Город отправления: ");
                    dep = scanner.nextLine();
                    System.out.print("Город прибытия: ");
                    arr = scanner.nextLine();
                    System.out.print("Дата полета (YYYY-MM-DD): ");
                    LocalDate ld = LocalDate.parse(scanner.nextLine());
                    System.out.print("Класс билета (Economy/Business): ");
                    String tc = scanner.nextLine();
                    List<Flight> found = system.findSuitableFlights(dep, arr, ld, tc);
                    if (found.isEmpty()) {
                        System.out.println("Рейсы не найдены.");
                    } else {
                        for (Flight f : found) {
                            system.displayFlightInfo(f);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Имя пассажира: ");
                    String name = scanner.nextLine();
                    System.out.print("Дата рождения (YYYY-MM-DD): ");
                    LocalDate bd = LocalDate.parse(scanner.nextLine());
                    System.out.print("Номер паспорта: ");
                    String pass = scanner.nextLine();
                    Passenger p = new Passenger(name, bd, pass);

                    System.out.print("Номер рейса: ");
                    String sf = scanner.nextLine();

                    // Ищем рейс по номеру
                    Optional<Flight> opt = system.findFlightByNumber(sf);
                    if (opt.isEmpty() || !(opt.get() instanceof ScheduledFlight)) {
                        System.out.println("Рейс не найден.");
                        break;
                    }
                    ScheduledFlight flightToBook = (ScheduledFlight) opt.get();

                    System.out.print("Класс билета (Economy/Business): ");
                    String cd = scanner.nextLine();
                    system.sellTicket(p, flightToBook, cd, LocalDate.now());
                    break;
                case 4:
                    System.out.println("Выход.");
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

}