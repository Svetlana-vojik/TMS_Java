package by.teachmeskills.homeworks.hw_14042023.discount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class NotificationUtils {
    public static void sendNotification(String filePath) throws IOException {
        String shopName = "\"Шопоголик\"";
        LocalDate today = LocalDate.now();
        File fileUsers = new File(filePath);
        String products = "сезонный ассортимент";
        String user;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileUsers))) {
            while ((user = bufferedReader.readLine()) != null) {
                String[] userArray = user.split(";");
                Map<String, String> users = new HashMap<>();
                for (int i = 0; i < userArray.length; i++) {
                    switch (i) {
                        case 0 -> users.put("name", userArray[i]);
                        case 2 -> users.put("birthdayDate", userArray[i]);
                    }
                }
                LocalDate userBirthday = LocalDate.parse(users.get(("birthdayDate")).trim());
                LocalDate thisYearUserBirthday = userBirthday.withYear(2023);
                LocalDate weekBeforeUserBirthday = thisYearUserBirthday.minusDays(7);
                LocalDate weekAfterUserBirthday = thisYearUserBirthday.plusDays(7);

                if (today.isEqual(userBirthday)) {
                    System.out.printf("Уважаемый(-моя) %s Магазин %s поздравляет Вас с Днем рождения и дарит Вам в скидку 15%% на следующие товары %s." +
                            "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY." +
                            "Будем рады видеть Вас в нашем магазине", users.get("name").trim(), shopName, products, weekBeforeUserBirthday, weekAfterUserBirthday);
                } else if (today.isEqual(weekBeforeUserBirthday)) {
                    System.out.printf("Уважаемый(-моя) %s, магазин %s в Ваш День рождения дарит Вам в скидку 15%% на следующие товары %s." +
                            "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY." +
                            "Будем рады видеть Вас в нашем магазине", users.get("name").trim(), shopName, products, weekBeforeUserBirthday, weekAfterUserBirthday);
                } else if (today.isEqual(weekAfterUserBirthday)) {
                    System.out.printf("Уважаемый(-моя) %s, магазин %s в Ваш День рождения дарит Вам в скидку 15%% на следующие товары %s." +
                            "Скидка действует с %4$td %4$tB %4$tY до %5$td %5$tB %5$tY." +
                            "Будем рады видеть Вас в нашем магазине", users.get("name").trim(), shopName, products, weekBeforeUserBirthday, weekAfterUserBirthday);
                }
            }
        }
    }
}