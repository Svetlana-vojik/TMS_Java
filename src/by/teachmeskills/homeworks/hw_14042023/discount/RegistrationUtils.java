package by.teachmeskills.homeworks.hw_14042023.discount;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationUtils {
    public static final String FILEPATH = "src\\by\\teachmeskills\\homeworks\\hw_14042023\\files\\users.txt";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private RegistrationUtils() {
    }

    private record Client(String name, LocalDate birthdayDate, String phone) {
    }

    public static void readUserData(List<Client> users) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ваше ФИО: ");
        String name = scan.nextLine();
        System.out.println("Введите ваш пол(мужской/женский): ");
        String sex = scan.nextLine();
        System.out.println("Введите ваш номер телефона в формате +375*********: ");
        String phone = scan.nextLine();
        System.out.println("Введите ваш электронный адрес: ");
        String email = scan.nextLine();
        System.out.println("Введите вашу дату рождения в формате год-месяц-день: ");
        String birthdayDate = scan.nextLine();
        if (validateData(name, birthdayDate, phone)) {
            users.add(new Client(name, LocalDate.parse(birthdayDate, FORMATTER), phone));
        } else {
            System.out.println("Клиент не добавлен");
        }
    }

    private static boolean validateData(String name, String birthdayDate, String phone) {

        if (name.isEmpty() || name.isBlank()) {
            System.out.println("ФИО не может быть пустым или содержать одни пробелы.");
            return false;
        }
        try {
            LocalDate.parse(birthdayDate, FORMATTER);
            System.out.println("Дата рождения верна.");
        } catch (DateTimeParseException ex) {
            System.out.println("Неверный формат даты рождения.");
            return false;
        }

        if ((!(phone.startsWith("+37529") || phone.startsWith("+37544") || phone.startsWith("+37533") || phone.startsWith("+37525"))) && phone.length() == 13 && phone.matches("[+0-9]+")) {
            System.out.println("Неверный код.");
            return false;
        } else if (phone.length() != 13 && phone.matches("[+0-9]+")) {
            System.out.println("Неверная длина номера.");
            return false;
        } else if (!phone.matches("[+0-9]+")) {
            System.out.println("Введены неверные символы в номере телефона.");
            return false;
        }
        return true;
    }

    public static void createUsersFile() {
        boolean exitFlag = false;
        Scanner in = new Scanner(System.in);
        List<Client> users = new ArrayList<>();
        while (!exitFlag) {
            System.out.println("""
                    Выберите действие:
                    1 - Зарегистрировать карту покупателя;
                    2 - Выход из регистрации;""");
            if (in.nextLine().equals("1")) {
                readUserData(users);
            } else {
                exitFlag = true;
            }
        }
        if (!users.isEmpty()) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILEPATH))) {
                for (Client c : users) {
                    bufferedWriter.write(c.name.trim().replaceAll(" +", " ") + " "
                            + c.phone + " " + c.birthdayDate.toString() + "\n");
                }
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }
}