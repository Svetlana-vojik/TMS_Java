package by.teachmeskills.homeworks.hw_10032023.strings;

public class StringUtils {
    public static void main(String[] args) {
        String str1 = "Сегодня первый день весны!";
        String str2 = "Око за око, зуб за зуб";
        StringBuilder sb = replaceCharacter(new StringBuilder("3 + 2 = 5"));
        StringBuilder stringBuilder = returnAppend(3, 56);

        lastCharacter(str1);
        System.out.println("-------------------------");
        lastThreeCharacter(str1);
        System.out.println("-------------------------");
        firstCharacters(str1);
        System.out.println("-------------------------");
        toLowerCase(str1);
        System.out.println("-------------------------");
        toUpperCase(str1);
        System.out.println("-------------------------");
        System.out.println(sb);
        System.out.println("-------------------------");
        split(str1);
        System.out.println("-------------------------");
        System.out.print(stringBuilder);
        System.out.println("-------------------------");
        returnData(str1);
        System.out.println("-------------------------");
        twoStrings("good", "days");
        System.out.println("-------------------------");
        isPalindrome("Око за око, зуб за зуб");
    }

    public static void lastCharacter(String str) {
        int n = str.length();
        char last = str.charAt(n - 1);
        System.out.println("Last character: " + last);
    }

    public static void lastThreeCharacter(String str) {
        boolean ends = str.endsWith("!!!");
        System.out.println("Does the string end with \"!!!\": " + ends);
    }

    public static void firstCharacters(String str) {
        boolean starts = str.startsWith("Сиреневенький синхрофазатрон");
        System.out.println("Does the string start with \"Сиреневенький синхрофазатрон\": " + starts);
    }

    public static void toUpperCase(String str) {
        String upperCase = str.toUpperCase();
        System.out.println(upperCase);
    }

    public static void toLowerCase(String str) {
        String lowerCase = str.toLowerCase();
        System.out.println(lowerCase);
    }

    public static void returnData(String str) {
        boolean contains = str.contains("dadada");
        System.out.println("If the string have word:" + contains);
    }

    private static StringBuilder returnAppend(int a, int b) {
        StringBuilder result = new StringBuilder();
        result.append(a).append(" + ").append(b).append(" = ").append(a + b).append("\n");
        result.append(a).append(" - ").append(b).append(" = ").append(a + b).append("\n");
        result.append(a).append(" * ").append(b).append(" = ").append(a + b).append("\n");
        return result;
    }

    public static StringBuilder replaceCharacter(StringBuilder stringBuilder) {
        int position = stringBuilder.indexOf("=");
        stringBuilder.deleteCharAt(position);
        stringBuilder.insert(position, "равно");
        return stringBuilder;
    }

    public static void split(String str) {
        String[] parts = str.split(" ");
        for (String s : parts)
            System.out.println(s);
    }

    public static void twoStrings(String str1, String str2) {
        String result = str1.concat(str2);
        int len = result.length();
        int middle = len / 2;
        String total = String.valueOf(result.charAt(middle));
        String total2 = String.valueOf(result.charAt(middle - 1));
        System.out.println(total2 + total);
    }

    public static void isPalindrome(String text) {
        StringBuilder buffer = new StringBuilder(text);
        buffer.reverse();
        String data = buffer.toString();
        if (text.equals(data)){
            System.out.println("Палиндром");
        }else{
            System.out.println("Не палиндром");
        }
    }
}

