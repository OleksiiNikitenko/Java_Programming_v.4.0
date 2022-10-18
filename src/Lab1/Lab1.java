package Lab1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        //task4();
        //ask5();
        task6();
    }

    //1. Написати програму повного дослідження коренів лінійного рівняння
    //ax + b = 0. Якщо коренів немає або безліч, то програма має вивести текстове
    //повідомлення про це. Інакше має бути виведений корінь.
    public static void task1() {
        System.out.println("ax+b=0");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        final double EPS = 1e-12;
        if (Math.abs(a) < EPS) { // a = 0
            if (Math.abs(b) < EPS) { // b = 0
                System.out.println("x - безліч");
            } else {
                System.out.println("Коренів немає");
            }
        } else {
            double x = -b / a;
            System.out.println("x=" + x);
            if (Math.abs(a * x + b) < EPS) {
                System.out.println("х знайдений");
            } else {
                System.out.println("Коренів немає");
            }
        }
    }

    //1. Випадковим чином генерується масив чисел розміру n. Користувач
    //вводить числа a і b. Замінити елемент масиву на суму його сусідів, якщо
    //елемент масиву парний і номер його лежить в проміжку від a до b.
    public static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть a: ");
        int a = in.nextInt();
        System.out.print("Введіть b: ");
        int b = in.nextInt();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 20);
            System.out.print(array[i] + "\t");
        }
        for (int i = 0; i < array.length; i++) {
            if (i > a && i < b && array[i] % 2 == 0) {
                if ((i + 1) == array.length) {
                    array[i] = array[i - 1];
                } else {
                    array[i] = array[i - 1] + array[i + 1];
                }
            }
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    //1. Обчисліть суму і кількість додатних елементів матриці розмірністю
    //n×n, що знаходяться над головною діагоналлю
    public static void task3() {
        Random rnd = new Random();
        int sum = 0;
        int count = 0;
        int m = 5;
        int n = 5;
        int[][] matrix = new int[m][n];
        System.out.println("Сгенерована матриця");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) ((Math.random() * 22) - 11);
                System.out.printf("%1$3s ", matrix[i][j]);
                if ((j > i) && (matrix[i][j] >= 0)) {
                    sum += matrix[i][j];
//                    System.out.println(matrix[i][j] + " yjdt");
                    count++;
                }
            }
            System.out.println();
        }
        System.out.printf("Сума = %1$s, Кількість = %2$s" + "\r\n", sum, count);
    }

    //1. Характеристикою рядка цілочисельної матриці розмірності n×m
    //назвемо суму її додатних парних елементів. Переставляючи рядки заданої
    //матриці, розташувати їх відповідно до зростання їх характеристик.
    public static void task4() {
        int rows, columns;
        System.out.print("Введіль кількісь рядків: ");
        rows = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.print("Введіть кількість стовпців: ");
        columns = Integer.parseInt(new Scanner(System.in).nextLine());
        int[][] matrix = new int[rows][columns];
        System.out.println("Початкова матриця: ");
        int[] sum = new int[rows];
        for (int i = 0; i < rows; i++) {
            sum[i] = 0;
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) ((Math.random() * 22) - 11);
                System.out.printf("%1$5s", matrix[i][j]);
                if (matrix[i][j] > 0 && matrix[i][j] % 2 == 0) {
                    sum[i] += matrix[i][j];
                }
            }
            System.out.printf(" Sum: %1$s" + "\r\n", sum[i]);
        }
        for (int i = 0; i < sum.length - 1; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (sum[i] > sum[j]) {
                    int b = sum[i];
                    sum[i] = sum[j];
                    sum[j] = b;
                    for (int m = 0; m < columns; m++) {
                        b = matrix[i][m];
                        matrix[i][m] = matrix[j][m];
                        matrix[j][m] = b;
                    }
                }
            }
        }
        System.out.println("Оброблена матриця: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%1$5s", matrix[i][j]);
            }
            System.out.printf(" Sum: %1$s" + "\r\n", sum[i]);
        }
    }

    //1. За правилами машинопису після коми в тексті завжди ставиться
    //символ пробілу. Скласти програму виправлення такого типу помилок
    //(відсутність пробілу) в тексті.
    public static void task5() {
        String s = "Осінь це пора поетів та романтиків!То коли ж насолоджуватися красивими римованими рядками,як не восени?Тренуємо память разом з дітьми.Від нас добірка віршів з подихом осені.";
        s = s.replaceAll("(?<=\\p{Punct})(?=\\p{IsCyrillic})", " ");
        System.out.println(s);
    }

    //1. Знайти та підрахувати кількість всіх послідовностей символів
    //«авто» в різних контекстах, як наприклад: «авто», «автомат»,
    //«автовокзал», «тавтологія», «мініавто» і т. ін.
    public static void task6() {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("авто");
        strings.add("автомат");
        strings.add("aвт1");
        strings.add("автовокзал");
        strings.add("тавтологія");
        strings.add("aвт2");
        strings.add("мініавто");
        strings.add("aвт3");

        int autoCounter = 0;
        int allCounter = 0;
        for (String str : strings) {
            if (str.contains("авто")) {
                autoCounter++;
            }
            allCounter++;
        }
        System.out.println("\"авто\" міститься у " + autoCounter + " рядках з " + allCounter);

    }
}
