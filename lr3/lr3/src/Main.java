
import java.util.Scanner;

public class Main {

    private static void ArrayWork(double[] array, int size) {

        int maxIndex = -1, minIndex = -1;
        double sum = 0; // сума;
        double result = 1; // добуток;

        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;

        for (int i = 0; i < size; ++i) {
            if (array[i] < min) { // пошук мінімуму та його індексу;
                min = array[i];
                minIndex = i;
            }
            if (array[i] < 0) sum += array[i]; // якщо число від'ємне, рахуємо його до суми,
            if (array[i] > max) { // пошук максимуму та його індексу;
                max = array[i];
                maxIndex = i;
            }

        }
        System.out.println();

        if (maxIndex > minIndex) { //  якщо треба буде змінити місцями індекси, щоб перший був меншим;
            maxIndex = maxIndex + minIndex;
            minIndex = maxIndex - minIndex;
            maxIndex = maxIndex - minIndex;
        }
        for (int i = maxIndex + 1; i < minIndex; ++i) { // від меншого індексу до більшого,
            result *= array[i]; // рахуємо добуток;
        }
        System.out.println("Сума від'ємних: " + sum);
        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Добуток чисел, які між максимумом та мінімумом: " + result);
    }

    private static void ArrayWork2 (int [][]matrix) {
        int max = matrix[0][0];


        int str = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] > 0 || matrix[i][j] == 0) {
                    count++;
                }
            }
            if (count == matrix[i].length) {
                str++;
                count = 0;
            }
            else {count = 0;}
        }
        System.out.println("Кількість строк без мінусових елементів:" + str);


        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] > max) {
                    for (int g = 0; g < matrix.length; g++) {
                        for (int k = 0; k < matrix[i].length; k++) {
                            if (j == k && g == i) continue;
                            if (matrix[i][j] == matrix[g][k]) {
                                max = matrix[i][j];
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Найбільше число, яке зустрічається мінімум двічі у масиві:" + max);
    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Введіть довжину масиву:");
        int size = input.nextInt(); // читаємо з клавіатури розмір масиву і записуємо його у сайз,

        double[] array = new double[size]; // створюємо масив дабл розміром сайз;

        System.out.println("Введіть елементи масиву:");
        // йдемо по всьому масиву, заповнюючи його;
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        System.out.print ("Наш масив:");
        for (int i = 0; i < size; i++) {
            System.out.print (" " + array[i]); // Виводимо наш масив;
        }
        ArrayWork(array, size);

        int [][] matrix = {

                 { 1, 2, 6  },
                 {-6, 3, 6  },
                 { 1, 2, 3  }
        };

        System.out.print("Наш масив:"+ '\n');

        for (int [] row : matrix) {
            for (int elem : row)
                System.out.printf("%2d",elem);
            System.out.println();
        }
        ArrayWork2 (matrix);
    }
}