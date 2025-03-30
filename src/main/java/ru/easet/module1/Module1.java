package ru.easet.module1;

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

    public void PracticalTask_1_4() {

        // ===== Практика. Операторы циклов for и while. =====
        // Задача 1
        int salary = 80000;
        int yearAmount = 0;

        for (int i = 0; i < 12; i++) {
            yearAmount += salary;
        }
        System.out.println("Заработал за 12 месяцев: " + yearAmount);

        // зАДАЧА 2
        double monthlyDeposit = 20000;
        double monthlyInterest = 0.02; // 2%
        int months = 24;
        double total = 0;

        for (int i = 1; i <= months; i++) {
            total += total * monthlyInterest; // начисление процентов
            total += monthlyDeposit;          // ежемесячный вклад
        }

        System.out.printf("Сумма вклада через 2 года: %.2f рублей\n", total);

        // Задача 3
        for (int i = 1; i <= 10; i++) {
            System.out.println("Умножаем 5*" + i + "=" + 5 * i);
        }

        // Task 4
        int i = 0;
        yearAmount = 0;
        while (i!=12){
            i++;
            yearAmount += salary;
        }
        System.out.println("Заработал за 12 месяцев (циклы whle) : " + yearAmount);

        // Task 5
        int monthlyDeposit2 = 25000;
        int goal = 5_000_000;
        int total2 = 0;
        int month = 0;

        while (total2 < goal) {
            month++;
            total2 += monthlyDeposit2;

            // Как требует задача можем выводить помесячно
            //System.out.printf("Месяц %d, сумма накоплений равна %d рублей\n", month, total2);

        }
        System.out.printf("Месяцев %d, сумма накоплений равна %d рублей\n", month, total2);


        // Task 6

        // Числа от 1 до 10 через while
        int j = 1;
        while (j <= 10) {
            System.out.print(j + " ");
            j++;
        }

        System.out.println();

        // Числа от 10 до 1 через for
        for (int k = 10; k >= 1; k--) {
            System.out.print(k + " ");
        }
        System.out.println();

        //Task 7
        int population = 25_000_000;
        double birthRate = 17 / 1000.0;
        double deathRate = 8 / 1000.0;
        int years = 6;

        for (int year = 1; year <= years; year++) {
            int born = (int) (population * birthRate);
            int died = (int) (population * deathRate);
            population = population + born - died;

            System.out.printf("Год %d, численность населения составляет %d\n", year, population);
        }

        // Task 8
        double monthlyDeposit4 = 60000;
        double monthlyInterest4 = 0.02; // 2%
        double goal4 = 20_000_000;
        double total4 = 0;
        int month4 = 0;

        while (total4 < goal4) {
            month4++;
            total4 += total4 * monthlyInterest4; // процент на накопления
            total4 += monthlyDeposit4;           // ежемесячный вклад

            //System.out.printf("Месяц %d, сумма накоплений равна %.2f рублей\n", month4, total4);
        }
        System.out.printf("Месяц %d, сумма накоплений равна %.2f рублей\n", month4, total4);
        System.out.printf("Всего месяцев понадобилось: %d\n", month4);

        // Task 9
        /*
        * Видоизмените задачу 7 таким образом, чтобы в консоль выводились не все месяцы подряд,
        * а только каждый двенадцатый. Должны быть видны накопления за 12, 24 36-й и следующие месяцы.
        *
        * НЕ могу понять в чем разница, 12 месяцев = 1 год.......
        * */
        int population9 = 25_000_000;
        double birthRate9 = 17 / 1000.0;
        double deathRate9 = 8 / 1000.0;
        int totalMonths9 = 6 * 12; // 6 лет = 72 месяца

        for (int month9 = 1; month9 <= totalMonths9; month9++) {
            int born9 = (int) (population9 * birthRate9 / 12);  // делим на 12 — ежемесячная рождаемость
            int died9 = (int) (population9 * deathRate9 / 12);  // делим на 12 — ежемесячная смертность
            population9 = population9 + born9 - died9;

            if (month9 % 12 == 0) {
                System.out.printf("Месяц %d, численность населения составляет %d\n", month9, population9);
            }
        }

        //Task 10
        int currentYear10 = 2024;
        int startPeriod10 = currentYear10 - 200;  // 1824
        int endPeriod10 = currentYear10 + 100;    // 2124
        int cometPeriod10 = 79;

        for (int year10 = 0; year10 <= endPeriod10; year10 += cometPeriod10) {
            if (year10 >= startPeriod10) {
                System.out.println(year10);
            }
        }

        // Task 11
        /*
        * Задача 11.
        Дано 6 целых чисел. Вычислите их сумму.
        * !!!!! - Напишите программу, использующую наименьшее число переменных.
        * */
        int sum11 = 5 + 12 + -3 + 8 + 7 + 10;
        System.out.println("Сумма чисел: " + sum11);




        // Task 11 вариант 1
        Scanner scanner12 = new Scanner(System.in);

        System.out.println("Программа считает количество О!");
        System.out.println("Введите сколько чисел N желаете вводить");
        int n12 = scanner12.nextInt();
        int zeroCount12 = 0;

        for (int q = 0; q < n12; q++) {
            System.out.println("Введите N");
            int number12 = scanner12.nextInt();
            if (number12 == 0) {
                zeroCount12++;
            }
        }

        System.out.println("Количество нулей: " + zeroCount12);

        // Task 11 вариант 2
        int zeroDigits12 = 0;

        for (int qw = 0; qw < n12; qw++) {
            int number12 = Math.abs(scanner12.nextInt()); // убираем знак минус

            if (number12 == 0) {
                zeroDigits12++; // число 0 содержит 1 цифру 0
            } else {
                while (number12 > 0) {
                    if (number12 % 10 == 0) {
                        zeroDigits12++;
                    }
                    number12 /= 10;
                }
            }
        }

        System.out.println("Количество цифр 0: " + zeroDigits12);
    }


}
