package by.teachmeskills.homeworks.hw_14042023.discount;

import java.io.IOException;

import static by.teachmeskills.homeworks.hw_14042023.discount.RegistrationUtils.FILEPATH;

public class Main {
    public static void main(String[] args) throws IOException {
        RegistrationUtils.createUsersFile();
        NotificationUtils.sendNotification(FILEPATH);
    }
}