package by.teachmeskills.homeworks.hw_17022023;

public class Vectors {
    public static void main(String[] args) {
        int[] array = {2, -5, 10, 7, -4, 12};
        int sum = 0;
        int max = 0;
        int min = 0;
        int multiply = 1;

      for (int i = 0; i < array.length; i++) {
           if (array[i] < 0) {
              sum = sum + array[i];
           }
       }
       System.out.println("Сумма отрицательных элементов: " + sum);

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
            if (array[i] < array[min]) {
                min = i;
            }
        }for ( int i = min + 1; i <= max - 1; i++){
            int temp = array[i];
            multiply = multiply * array[i];
        }
        System.out.println("Произведение: " + multiply);

        System.out.println("Max: " + array[min] + "; " + "Min: " + array[max]);
    }
}

