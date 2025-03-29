package ru.easet;

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
}
