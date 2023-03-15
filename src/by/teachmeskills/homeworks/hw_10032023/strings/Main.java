package by.teachmeskills.homeworks.hw_10032023.strings;

import static by.teachmeskills.homeworks.hw_10032023.strings.StringUtils.*;

public class Main {
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
}