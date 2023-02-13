package by.teachmeskills.homeworks.hw_17022023;

public class Vectors {
    public static void main(String[] args) {
        int [] array = new int []{ 2, -5, 10, -8, 4, 12, -4, 5, -6};
            int sum = 0;

            for(int i = 0; i  < array.length; i++){
                if (array[i] < 0){
                sum = sum + array[i];
                }
            }
        System.out.println(sum);
    }
}

