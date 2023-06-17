package clientmenu;

import tmspaymentsystem.AccountStatus;
import tmspaymentsystem.BankAccount;
import tmspaymentsystem.Merchant;
import tmspaymentsystem.MerchantService;
import tmspaymentsystem.exception.BankAccountNotFoundException;
import tmspaymentsystem.exception.MerchantNotFoundException;
import tmspaymentsystem.exception.NoBankAccountsFoundException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Client {
    public static void main(String[] args) throws MerchantNotFoundException, NoBankAccountsFoundException, BankAccountNotFoundException, IOException {
        boolean exitFlag = false;
        Scanner scanner = new Scanner(System.in);
        List<Merchant> merchants = new ArrayList<>();
        MerchantService merchantService = new MerchantService(merchants);

        while (!exitFlag) {
            System.out.println("""
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
                    String idScanner = scanner.nextLine();
                    Merchant merchant = merchantService.getMerchantById(idScanner);
                    List<BankAccount> listBank = merchantService.getMerchantBankAccounts(merchant);
                    listBank.forEach(s -> System.out.printf("Аккаунт: номер - %s; status - %s; дата - %s\n", s.getAccountNumber(), s.getStatus(), s.getCreatedTime()));
                }
                case 2 -> {
                    System.out.println("Введите id мерчанта, которому нужно добавить новый банковский аккаунт");
                    String idScanner = scanner.nextLine();
                    Merchant merchant = merchantService.getMerchantById(idScanner);
                    System.out.print("Введите номер банковского аккаунта мерчента: ");
                    String idScannerAccount = scanner.nextLine();
                    BankAccount bankAccount = new BankAccount(idScanner, AccountStatus.ACTIVE, idScannerAccount, LocalDateTime.now());
                    merchantService.addBankAccount(merchant, bankAccount);
                }
                case 3 -> {
                    System.out.print("Введите id мерчента, у которого редактируется аккаунт: ");
                    String idScanner = scanner.nextLine();
                    Merchant merchant = merchantService.getMerchantById(idScanner);
                    System.out.print("Введите номер аккаунта, которое редактируется: ");
                    String idScannerAccount = scanner.nextLine();
                    System.out.print("Введите новый номер аккаунта: ");
                    String newIdScannerAccount = scanner.nextLine();
                    BankAccount tempBankAccount = new BankAccount(merchant.getId(), AccountStatus.ACTIVE, idScannerAccount, LocalDateTime.now());
                    merchantService.updateBankAccount(tempBankAccount, newIdScannerAccount);
                }
                case 4 -> {
                    System.out.print("Введите id мерчента, аккаунт которого надо удалить: ");
                    String idScanner = scanner.nextLine();
                    Merchant merchant = merchantService.getMerchantById(idScanner);
                    List<BankAccount> listAccounts = merchantService.getMerchantBankAccounts(merchant);
                    System.out.print("Введите номер аккаунта, который надо удалить: ");
                    String idScannerDelete = scanner.nextLine();
                    BankAccount bankAccount = listAccounts.stream().filter(a -> a.getAccountNumber().equals(idScannerDelete)).findFirst().get();
                    if (merchantService.deleteBankAccount(bankAccount)) {
                        System.out.println("Аккаунт " + idScannerDelete + "удален!");
                    }
                }

                case 5 -> {
                    System.out.print("Введите id мерчента, о котором надо получить информацию: ");
                    String idScanner = scanner.nextLine();
                    Merchant merchant = merchantService.getMerchantById(idScanner);
                    System.out.printf("Мерчант: ID - %s; имя - %s; дата создания - %s\n", merchant.getId(), merchant.getName(), merchant.getCreatedAt());
                }

                case 6 -> merchantService.getMerchants().forEach(s ->
                        System.out.printf("Мерчант: ID - %s; имя - %s; дата создания - %s\n", s.getId(), s.getName(), s.getCreatedAt()));
                case 7 -> {
                    System.out.print("Введите название мерчанта: ");
                    String nameMerchantSc = scanner.nextLine();
                    String id = String.valueOf(UUID.randomUUID());
                    LocalDateTime createdAt = LocalDateTime.now();
                    Merchant merchant = new Merchant(id, nameMerchantSc, createdAt);
                    merchantService.createMerchant(merchant);
                }
                case 8 -> {
                    System.out.print("Введите id мерчента, которое хотите удалить: ");
                    String idDelete = scanner.nextLine();
                    if (merchantService.deleteMerchant(idDelete)) {
                        System.out.println("Мерчент с id - " + idDelete + " успешно удален!");
                    }
                }
                case 9 -> exitFlag = true;
            }
        }
    }
}