import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
        // Посмотрите на код, и подумайте сколько разных типов исключений
        // вы тут сможете получить?
        // РЕАЛИЗОВАНЫ МЕТОДЫ:
        // public static int promptArr()
        // public static void promptBegin() throws Exception
        // public static int sumArray(int[] arr) throws Exception

        // 2. Реализуйте метод, принимающий в качестве аргументов
        // два целочисленных массива, и возвращающий новый массив,
        // каждый элемент которого равен разности элементов
        // двух входящих массивов в той же ячейке. Если длины массивов не равны,
        // необходимо как-то оповестить пользователя.

        // 3. Реализуйте метод, принимающий в качестве аргументов
        // два целочисленных массива, и возвращающий новый массив,
        // каждый элемент которого равен частному элементов
        // двух входящих массивов в той же ячейке. Если длины массивов не равны,
        // необходимо как-то оповестить пользователя.
        // Важно: При выполнении метода единственное исключение,
        // которое пользователь может увидеть - RuntimeException, т.е. ваше.

        try {
            promptBegin(); // Задание 1
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.print("Введите длину первого массива: ");
        int length1 = promptArr(); // Задание 1
        System.out.print("Введите длину второго массива: ");
        int length2 = promptArr(); // Задание 1
        int[] array1 = fillArray(length1);
        int[] array2 = fillArray(length2);
        System.out.println("Первый массив:");
        printArray(array1);
        System.out.println("Второй массив:");
        printArray(array2);

        try {
            int[] arrayDiff = diffArray(array1, array2); // Задание 2
            System.out.println("Массив разностей двух массивов:");
            printArray(arrayDiff);
            double[] arrayDiv = divArray(array1, array2); // Задание 3
            System.out.println("Массив частного двух массивов:");
            printArray(arrayDiv);
            System.out.println("Сумма четных элементов элементов первого массива: " +
                    sumArray(array1)); // Заданием 1
            System.out.println("Сумма четных элементов элементов второго массива: " +
                    sumArray(array2)); // Заданием 1
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Задание 1
    // Посчитать сумму четных элементов массива из целых чисел,
    // если его длина не меньше 5
    public static int sumArray(int[] arr) throws Exception {
        int sum = 0;
        if (arr == null) {
            throw new RuntimeException("Массива нет!");
        } else if (arr.length < 5) {
            throw new RuntimeException("Длина массива меньше 5!");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 0) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }

    // Задание 2
    public static int[] diffArray(int[] arr1, int[] arr2) throws Exception {
        int[] result = new int[arr1.length];
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Хотя бы одного из массивов не существует!");
        } else if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны. Программа остановлена!");
        } else {
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i] - arr2[i];
            }
        }
        return result;
    }

    // Задание 3
    public static double[] divArray(int[] arr1, int[] arr2) throws Exception {
        double[] result = new double[arr1.length];
        if (arr1 == null || arr2 == null) {
            throw new RuntimeException("Хотя бы одного из массивов не существует!");
        } else if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны. Программа остановлена!");
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr2[i] != 0) {
                    result[i] = (double) arr1[i] / arr2[i];
                } else {
                    throw new RuntimeException("Деление на ноль!");
                }
            }
        }
        return result;
    }

    public static int[] fillArray(int arrLength) {
        int[] array = new int[arrLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(-10, 11);
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + "; ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("]");
    }

    public static void printArray(double[] array) {
        System.out.print("[");
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(decimalFormat.format(array[i]) + "; ");
            } else {
                System.out.print(decimalFormat.format(array[i]));
            }
        }
        System.out.println("]");
    }

    // Задание 1
    // Ввод с клавиатуры длины массива
    public static int promptArr() {
        Scanner console = new Scanner(System.in);
        int length = 0;
        try {
            length = console.nextInt();
            if (length < 0) {
                throw new RuntimeException("Введено некорректное значение!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Введено некорректное значение!");
        }
        return length;
    }

    //Задание 1
    // Вы хотите начать? Введите "y" или "n"
    public static void promptBegin() throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.print("Вы хотите начать? Введите 'y' или 'n': ");
        String answer = "";
        answer = console.nextLine();
        if (!answer.toUpperCase().equals("Y") && !answer.toUpperCase().equals("N")) {
            throw new RuntimeException("Введено некорректное значение!");
        }
    }
}