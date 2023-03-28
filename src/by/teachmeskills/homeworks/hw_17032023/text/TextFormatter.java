package by.teachmeskills.homeworks.hw_17032023.text;

public class TextFormatter {

    public static int returnWordNumber(String string) {
        String[] array = string.split(" ");
        return array.length;
    }

    public static boolean checkPalindromes(String string) {
        String[] list = string.split("\\P{L}+");
        for (String str : list) {
            StringBuilder temp = new StringBuilder(str);
            if (str.equals(temp.reverse().toString()))
                return true;
        }
        return false;
    }
}