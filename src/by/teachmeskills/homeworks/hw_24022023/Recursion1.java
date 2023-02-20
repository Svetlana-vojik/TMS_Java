package by.teachmeskills.homeworks.hw_24022023;

public class Recursion1 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(sum(nums, nums.length));

    }

    private static int sum(int array[], int i) {
        if (i <= 0) {
            return 0;
        }
        return (sum(array, i - 1) + array[i - 1]);
    }
}
