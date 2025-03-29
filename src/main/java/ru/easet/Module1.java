package ru.easet;

import java.util.Scanner;

public class Module1 {

    public void PracticalTask_1_1() {
        /*
         * Задача 1.
         * Присвоим переменным значения.
         */
        var task = false;
        var puppy = 8.0;
        var myMoney = 33234.6;
        var goodLuck = 763789;

        System.out.println("Проверка значений после Задачи 1");

        /*
         * Задача 2.
         * Увеличим значения на 4.
         */
        puppy += 4;
        myMoney += 4;
        goodLuck += 4;

        System.out.println("Проверка значений после Задачи 2");

        /*
         * Задача 3.
         * Уменьшим значения переменных.
         */
        puppy -= 5;
        myMoney -= 234.3;
        goodLuck -= 6;

        System.out.println("Проверка значений после Задачи 3");

        /*
         * Задача 4.
         * Попробуем вычесть 2 из переменной task.
         */
        // task = task - 2; // Код не скомпилируется (Ответ: C)

        System.out.println("Проверка значений после Задачи 4");

        /*
         * Задача 5.
         * Работа с переменной bird.
         */
        var bird = 3.5;
        bird = bird * 10;
        bird = bird / 3.5;
        bird = bird + 4;

        System.out.println("Проверка значений после Задачи 5");

        /*
         * Задача 6.
         * Вес участников, сумма и среднее.
         */
        var first = 73.4;
        var second = 69.4;
        var third = 74.1;
        var total = first + second + third;
        var mean = total / 3;

        System.out.println("Проверка значений после Задачи 6");

        /*
         * Задача 7.
         * Зарплата сотрудников за месяц.
         */
        var employees = 200;
        var hoursPerDay = 8;
        var daysInMonth = 23;
        var hourlyRate = 1000;
        var totalSalary = employees * hoursPerDay * daysInMonth * hourlyRate;

        System.out.println("Проверка значений после Задачи 7");

        /*
         * Задача 8.
         * Расчет налога (13% от зарплаты).
         */
        var tax = totalSalary * 0.13;

        System.out.println("Проверка значений после Задачи 8");
    }

    public void PracticalTask_1_2() {
        /*
         * Задача 1.
         * Объявим переменные всех основных типов, без var
         */
        int someInteger = 10_000_000;
        byte someByte = 120;
        short someShort = 10_000;
        long someLong = 10_000_000L;
        double someDouble = 10_000_000.0;
        float someFloat = 10_000_000.0f;

        char someChar = 'A';
        boolean someBoolean = true;

        System.out.println("Проверка значений после Задачи 1");

        /*
         * Задача 2.
         * Инициализация переменных
         */
        int number1 = 25;
        double number2 = 26.4;
        long number3 = 985_439_324_234L;
        double number4 = 4.5422;
        short number5 = 3894;
        int number6 = -234;
        int number7 = 234_542;
        byte number8 = 67;

        System.out.println("Проверка значений после Задачи 2");

        /*
         * Задача 3.
         * Арифметические операции с двумя int
         */
        int a = 15;
        int b = 4;
        int sum = a + b;
        int diff = a - b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;

        System.out.println("Проверка значений после Задачи 3");

        /*
         * Задача 4.
         * Неявное преобразование int -> double
         */
        int original = 42;
        double converted = original;

        System.out.println("Проверка значений после Задачи 4");

        /*
         * Задача 5.
         * Явное приведение double -> int
         */
        double precise = 42.7;
        int rounded = (int) precise;

        System.out.println("Проверка значений после Задачи 5");

        /*
         * Задача 6.
         * Объект Object
         */
        Object myObject = new Object();

        System.out.println("Проверка значений после Задачи 6");

        /*
         * Задача 7.
         * Два объекта Car
         */
        Car myCar1 = new Car();
        Car myCar2 = new Car();

        System.out.println("Проверка значений после Задачи 7");

        /*
         * Задача 8.
         * Три объекта Bus
         */
        Bus myBus1 = new Bus();
        Bus myBus2 = new Bus();
        Bus myBus3 = new Bus();

        System.out.println("Проверка значений после Задачи 8");

        /*
         * Задача 9.
         * Производительность логотипов
         */
        int logosPer4Min = 9;
        int logosPerMin = logosPer4Min / 4;
        int logos20min = logosPerMin * 20;
        int logosDay = logosPerMin * 60 * 24;
        int logos3Days = logosDay * 3;
        int logosMonth = logosDay * 30;

        System.out.println("Проверка значений после Задачи 9");

        /*
         * Задача 10.
         * 18 банок краски на ремонт дома, нужно понять сколько белой и зеленой
         * На один этаж уходит:
         * 4 банки белой краски
         * 2 банки зеленой краски
         *
         * Сколько этажей можно покрасить?
         * Всего уходит 6 банок на этаж (4 белые + 2 зеленые)
         */
        int totalPaint = 18;
        int whitePerFloor = 4;
        int greenPerFloor = 2;
        int paintPerFloor = whitePerFloor + greenPerFloor;

        // Считаем сколько этажей можно покрасить
        int totalFloors = totalPaint / paintPerFloor;

        // Считаем сколько нужно банок каждого цвета
        int whiteNeeded = whitePerFloor * totalFloors;
        int greenNeeded = greenPerFloor * totalFloors;

        System.out.println("Проверка значений после Задачи 10");

        /*
         * Задача 11.
         * Повышение зарплаты сотрудников + расчёт разницы годового дохода
         */
        double vasya = 67760;
        double petya = 83690;
        double polina = 76230;
        double dasha = 45240;

        double vasyaNew = vasya * 1.05;
        double petyaNew = petya * 1.05;
        double polinaNew = polina * 1.05;
        double dashaNew = dasha * 1.05;

        double vasyaDiff = (vasyaNew - vasya) * 12;
        double petyaDiff = (petyaNew - petya) * 12;
        double polinaDiff = (polinaNew - polina) * 12;
        double dashaDiff = (dashaNew - dasha) * 12;

        System.out.println("Проверка значений после Задачи 11");
    }

    public void PracticalTask_1_3() {
        Scanner scanner = new Scanner(System.in);

        // ===== Вывод данных =====

        System.out.println("Привет, мир!"); // Задача 1

        int number = 42; // Задача 2
        System.out.println("Ответ на главный вопрос жизни, вселенной и всего такого: " + number);

        double pi = 3.14159; // Задача 3
        System.out.printf("Число Пи равно %.2f%n", pi);

        String name = "Катя"; // Задача 4
        int age = 19;
        System.out.println("Имя: " + name + ", возраст: " + age);

        char symbol = 'Ж'; // Задача 5
        System.out.println(symbol + " – символ гордости!!");

        boolean truth = true; // Задача 6
        System.out.println("Это правда? " + truth);

        long bigNumber = 123_456_789_000L; // Задача 7
        System.out.println("Большое число: " + bigNumber);

        float fraction = 9.8765f; // Задача 8
        System.out.printf("Дробное число: %.2f%n", fraction);

        String city = "Новосибирск"; // Задача 9
        System.out.println("Местоположение: " + city);

        int x = 90; // Задача 10
        int y = 12;
        System.out.println(x + " - " + y + " = " + (x - y));

        // ===== Ввод данных =====

        // Ввод 1
        System.out.print("Введите ваше имя: ");
        String userName = scanner.nextLine();
        System.out.print("Привет, " + userName + "!\n");

        // Ввод 2
        System.out.print("Введите первое число: ");
        int n1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int n2 = scanner.nextInt();
        System.out.println("Сумма: " + (n1 + n2));
        System.out.println("Разность: " + (n1 - n2));
        System.out.println("Произведение: " + (n1 * n2));
        System.out.println("Деление: " + (n1 / n2));

        // Ввод 3
        System.out.print("Введите число для таблицы умножения: ");
        int mult = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(mult + " * " + i + " = " + (mult * i));
        }

        // Ввод 4
        System.out.print("Введите оценку студента (1–5): ");
        int grade = scanner.nextInt();
        if (grade == 5) System.out.println("Отлично!");
        else if (grade == 4) System.out.println("Хорошо");
        else if (grade == 3) System.out.println("Удовлетворительно");
        else System.out.println("Неудовлетворительно");

        scanner.nextLine(); // очистка буфера

        // Ввод 5
        System.out.print("Введите своё имя: ");
        String fullName = scanner.nextLine();
        System.out.print("Введите свой возраст: ");
        int userAge = scanner.nextInt();
        scanner.nextLine(); // очистка
        System.out.print("Введите интересный факт о себе: ");
        String fact = scanner.nextLine();
        System.out.println("Пользователь: " + fullName + ", возраст: " + userAge + ", факт: " + fact);

        // ===== Условные операторы с вводом =====

        // Условие 1
        System.out.print("Введите ваш возраст: ");
        int personAge = scanner.nextInt();
        if (personAge >= 18) {
            System.out.println("Если возраст человека равен " + personAge + ", то он совершеннолетний");
        } else {
            System.out.println("Если возраст человека равен " + personAge + ", то он не достиг совершеннолетия");
        }

        // Условие 2
        System.out.print("Введите температуру на улице: ");
        int temp = scanner.nextInt();
        if (temp < 10) {
            System.out.println("На улице " + temp + " градусов, нужно надеть шапку");
        } else {
            System.out.println("На улице " + temp + " градусов, можно идти без шапки");
        }

        // Условие 3
        System.out.print("Введите вашу скорость (км/ч): ");
        int speed = scanner.nextInt();
        if (speed > 110) {
            System.out.println("Если скорость " + speed + ", то придется заплатить штраф");
        } else {
            System.out.println("Если скорость " + speed + ", то штраф не придет");
        }

        // Условие 4
        System.out.print("Введите возраст для определения учреждения: ");
        int checkAge = scanner.nextInt();
        if (checkAge < 3) System.out.println("Если возраст человека равен " + checkAge + ", то ему в ясли");
        else if (checkAge <= 6) System.out.println("...в детский сад");
        else if (checkAge <= 18) System.out.println("...в школу");
        else if (checkAge < 24) System.out.println("...в университет");
        else if (checkAge <= 60) System.out.println("...пора на работу");
        else System.out.println("...выходит на пенсию");

        // Условие 5
        System.out.print("Введите рост ребёнка в см: ");
        int height = scanner.nextInt();
        if (height < 100) System.out.println("Если рост ребенка равен " + height + ", то ему нельзя кататься");
        else if (height < 140) System.out.println("...можно кататься в сопровождении взрослого");
        else System.out.println("...можно кататься без сопровождения");

        // Условие 6
        System.out.print("Введите количество занятых мест в поезде: ");
        int occupied = scanner.nextInt();
        int total = 2500;
        int seats = 344;
        if (occupied < seats) {
            System.out.println("Есть сидячее место");
        } else if (occupied < total) {
            System.out.println("Сидячих мест нет, есть стоячее");
        } else {
            System.out.println("Поезд полностью забит");
        }

        // Условие 7
        System.out.print("Введите два числа");
        System.out.print("Первое:");
        int a = scanner.nextInt();
        System.out.print("Второе:");
        int b = scanner.nextInt();
        System.out.println("Большее число: " + (a > b ? a : b));

        // Условие 8
        System.out.print("Введите три числа: ");
        System.out.print("Первое:");
        int m1 = scanner.nextInt();
        System.out.print("Второе:");
        int m2 = scanner.nextInt();
        System.out.print("Третье:");
        int m3 = scanner.nextInt();
        int min = m1;
        if (m2 < min) min = m2;
        if (m3 < min) min = m3;
        System.out.println("Меньшее число: " + min);

        // Условие 9
        System.out.print("Введите ОС (0 – iOS, 1 – Android): ");
        int clientOS = scanner.nextInt();
        if (clientOS == 0) {
            System.out.println("Установите версию приложения для iOS");
        } else {
            System.out.println("Установите версию приложения для Android");
        }

        // Условие 10
        System.out.print("Введите год выпуска телефона: ");
        int phoneYear = scanner.nextInt();
        if (clientOS == 0) {
            if (phoneYear < 2020)
                System.out.println("Скачайте лайт версию приложения для iOS по ссылке");
            else
                System.out.println("Установите версию приложения для iOS");
        } else {
            if (phoneYear < 2020)
                System.out.println("Скачайте лайт версию приложения для Android по ссылке");
            else
                System.out.println("Установите версию приложения для Android");
        }

        // Условие 11
        System.out.print("Введите год для проверки на високосность: ");
        int year = scanner.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }

        // Условие 12
        System.out.print("Введите дистанцию до клиента: ");
        int deliveryDistance = scanner.nextInt();
        int days = 1;
        if (deliveryDistance > 150) {
            System.out.println("Доставки нет");
        } else {
            if (deliveryDistance > 80) days += 2;
            else if (deliveryDistance > 50) days += 1;
            System.out.println("Потребуется дней: " + days);
        }

        // Условие 13
        System.out.print("Введите номер месяца (1–12): ");
        int monthNumber = scanner.nextInt();
        switch (monthNumber) {
            case 12, 1, 2 -> System.out.println("Зима");
            case 3, 4, 5 -> System.out.println("Весна");
            case 6, 7, 8 -> System.out.println("Лето");
            case 9, 10, 11 -> System.out.println("Осень");
            default -> System.out.println("Такого месяца не существует");
        }

        // Условие 14
        System.out.print("Введите номер действия (1–5): ");
        int action = scanner.nextInt();
        switch (action) {
            case 1 -> System.out.println("Найти билеты на самолет");
            case 2 -> System.out.println("Купить билеты на самолет");
            case 3 -> System.out.println("Сдать ранее купленные билеты");
            case 4 -> System.out.println("Форма регистрации на рейс");
            case 5 -> System.out.println("Связаться с поддержкой");
            default -> System.out.println("Такого действия нет");
        }

        System.out.println("Практическое задание 1.3 завершено!");
    }

}
