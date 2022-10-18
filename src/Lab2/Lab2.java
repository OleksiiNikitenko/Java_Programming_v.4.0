package Lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

//12. У програмі, де потрібно з матриці з елементами,
// введеними з клавіатури, вивести стовпець з максимальним парним числом,
// можуть виникати помилки в наступних випадках:
//- введення рядка замість числа;
//- невідповідність числового типу даних;
//- немає парних чисел;
//- передбачити інші виняткові ситуації, які генеруються програмою.
public class Lab2 {
    public static void main(String[] args) {
        int[][] matrix = new int[1][1];
        try {
            int n = Integer.parseInt("25");
            matrix = generateMatrix(n);
        } catch (NumberFormatException e) {
            System.err.println("Invalid format");
        }

        printMatrix(matrix);
        try {
            findMaxCol(matrix);
        } catch (NotEvenNumberException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void findMaxCol(int[][] matrix) throws NotEvenNumberException {
        int max = matrix[0][0];
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > max && matrix[i][j] % 2 == 0) {
                    max = matrix[i][j];
                    col = j;
                }
            }
        }
        boolean notEvenNumberCheck = false;
        if (max % 2 != 0) {
            notEvenNumberCheck = true;
            throw new NotEvenNumberException("no even number");
        }
        if (!notEvenNumberCheck) {
            printCol(matrix, col);
        }
    }

    public static void printCol(int[][] matrix, int col) {
        System.out.println("Max column");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j == col) {
                    System.out.println(matrix[i][j] + "\t");
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++, System.out.println()) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
        }
    }

    private static int[][] generateMatrix(int n) {
        Scanner in = new Scanner(System.in);
        int[][] matrix = new int[n][n];
        if (matrix.length >= 20) {
            try {
                throw new LargeMatrixException();
            } catch (LargeMatrixException e) {
                System.err.println("Matrix is too large");
                System. exit(0);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = intInputWithCheck(in);
            }
        }
        return matrix;
    }


    public static int intInputWithCheck(Scanner in) {
        int value = 0;
        boolean checkN = true;
        do {
            try {
                System.out.println("Input value: ");
                value = in.nextInt();
                checkN = false;
            } catch (InputMismatchException e) {
                System.err.println("Incorrect input! Please try again...");
                in.next();
            }
        } while (checkN);
        return value;
    }
}
