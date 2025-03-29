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
}
