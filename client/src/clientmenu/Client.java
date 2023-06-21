package clientmenu;

import tmspaymentsystem.BankAccount;
import tmspaymentsystem.Merchant;
import tmspaymentsystem.MerchantService;
import tmspaymentsystem.exception.BankAccountNotFoundException;
import tmspaymentsystem.exception.MerchantNotFoundException;
import tmspaymentsystem.exception.NoBankAccountsFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Client {
    public static void main(String[] args) throws MerchantNotFoundException, NoBankAccountsFoundException, BankAccountNotFoundException {
        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);
        List<Merchant> merchants = new ArrayList<>();
        MerchantService merchantService = new MerchantService(merchants);

        while (!exitFlag) {
            System.out.println("\n" + """
                    Выберите действие:
                    1 - Получение информации о банковских аккаунтах мерчанта;
                    2 - Добавление нового банковского аккаунта мерчанту;
                    3 - Редактирование банковского аккаунта мерчанта;
                    4 - Удаление банковского аккаунта мерчанта;
                    5 - Получение информации о мерчанте;
                    6 - Получение всех мерчантов, зарегистрированных в платежной системе;
                    7 - Создание мерчанта;
                    8 - Удаление мерчанта;
                    9 - Выход из программы;""");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Введите id мерчента, о банковских аккаунтах которого нужно предоставить информацию: ");
                    String merchantId = scanner.next();
                    List<BankAccount> listBank = merchantService.getMerchantBankAccounts(merchantId);
                    listBank.forEach(s -> System.out.printf("Аккаунт: номер - %s; status - %s; дата - %s\n", s.getAccountNumber(), s.getStatus(), s.getCreatedTime()));
                }
                case 2 -> {
                    System.out.println("Введите id мерчента, которому нужно добавить новый банковский аккаунт:");
                    String merchantId = scanner.next();
                    System.out.print("Введите номер банковского аккаунта мерчента: ");
                    String accountNumber = scanner.next();
                    merchantService.addBankAccount(merchantId, accountNumber);
                }
                case 3 -> {
                    System.out.print("Введите id мерчента, у которого редактируется аккаунт: ");
                    String merchantId = scanner.next();
                    System.out.print("Введите номер банковского аккаунта мерчента, которое редактируется: ");
                    String accountNumber = scanner.next();
                    System.out.print("Введите новый номер аккаунта: ");
                    String newAccountNumber = scanner.next();
                    if (merchantService.updateBankAccount(accountNumber, newAccountNumber, merchantId)) {
                        System.out.println("Аккаунт " + merchantId + " изменен");
                    }
                }
                case 4 -> {
                    System.out.print("Введите id мерчента, аккаунт которого надо удалить: ");
                    String merchantId = scanner.next();
                    System.out.print("Введите номер банковского аккаунта мерчента, который надо удалить: ");
                    String accountNumber = scanner.next();
                    if (merchantService.deleteBankAccount(accountNumber, merchantId)) {
                        System.out.println("Аккаунт " + accountNumber + " удален!");
                    }
                }
                case 5 -> {
                    System.out.print("Введите id мерчента, о котором надо получить информацию: ");
                    String merchantId = scanner.next();
                    Merchant merchant = merchantService.getMerchantById(merchantId);
                    System.out.printf("Мерчант: ID - %s; имя - %s; дата создания - %s\n", merchant.getId(), merchant.getName(), merchant.getCreatedAt());
                }
                case 6 -> merchantService.getMerchants().forEach(s ->
                        System.out.printf("Мерчант: ID - %s; имя - %s; дата создания - %s\n", s.getId(), s.getName(), s.getCreatedAt()));
                case 7 -> {
                    System.out.print("Введите название мерчанта: ");
                    String id = String.valueOf(UUID.randomUUID());
                    String nameMerchantSc = scanner.next();
                    LocalDateTime createdAt = LocalDateTime.now();
                    merchantService.createMerchant(id, nameMerchantSc, createdAt);
                }
                case 8 -> {
                    System.out.print("Введите id мерчента, которое хотите удалить: ");
                    String merchantId = scanner.next();
                    if (merchantService.deleteMerchant(merchantId)) {
                        System.out.println("Мерчент с id - " + merchantId + " успешно удален!");
                    }
                }
                case 9 -> exitFlag = true;
            }
        }
    }
}