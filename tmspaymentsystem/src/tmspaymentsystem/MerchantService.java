package tmspaymentsystem;

import tmspaymentsystem.exception.BankAccountNotFoundException;
import tmspaymentsystem.exception.MerchantNotFoundException;
import tmspaymentsystem.exception.NoBankAccountsFoundException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static tmspaymentsystem.FilesPaths.FILE_BANK_ACCOUNT;
import static tmspaymentsystem.FilesPaths.FILE_BANK_ACCOUNT_TEMP;
import static tmspaymentsystem.FilesPaths.FILE_MERCHANT;
import static tmspaymentsystem.FilesPaths.FILE_MERCHANT_TEMP;


public class MerchantService {
    private List<Merchant> merchants;

    public MerchantService(List<Merchant> merchants) {
        this.merchants = merchants;
    }


    public void addBankAccount(String merchantId, String accountNumber) throws MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        BankAccount bankAccount = new BankAccount(merchantId, AccountStatus.ACTIVE, accountNumber, LocalDateTime.now());
        if (accountNumber.length() != 8 && accountNumber.matches("^\\d+")) {
            throw new IllegalArgumentException("Номер банковского аккаунта неверный");
        } else {
            Optional<BankAccount> accountOfBank = merchant.getBankAccounts().stream().filter(s -> s.getAccountNumber().equals(bankAccount.getAccountNumber())).findAny();
            accountOfBank.ifPresentOrElse(a -> Optional.of(a).filter(s -> s.getStatus().equals(AccountStatus.DELETED)).ifPresent(s -> s.setStatus(AccountStatus.ACTIVE)), () -> {
                merchant.getBankAccounts().add(bankAccount);
                try (FileWriter writer = new FileWriter(FILE_BANK_ACCOUNT, true)) {
                    writer.write(bankAccount.getId() + " " + merchant.getId() + " " + bankAccount.getStatus() + " "
                            + bankAccount.getAccountNumber() + " " + bankAccount.getCreatedTime() + "\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        }
    }

    public List<BankAccount> getMerchantBankAccounts(String merchantId) throws NoBankAccountsFoundException, MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        if (merchant.getBankAccounts().isEmpty()) {
            throw new NoBankAccountsFoundException("У этого пользователя нет аккаунта");
        }
        return merchant.getBankAccounts().stream()
                .sorted(Comparator.comparing(BankAccount::getMerchantId))
                .sorted(Comparator.comparing(BankAccount::getCreatedTime))
                .sorted(Comparator.comparing(BankAccount::getStatus)).toList();
    }

    public boolean updateBankAccount(String accountNumber, String newAccountNumber, String merchantId) throws BankAccountNotFoundException, MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        List<BankAccount> accounts = merchant.getBankAccounts();
        BankAccount account = accounts.stream().filter(s -> s.getAccountNumber().equals(accountNumber)).findAny().orElseThrow(() -> new BankAccountNotFoundException("No bank account found!"));
        account.setAccountNumber(newAccountNumber);
        changeBankAccountFile();
        return true;
    }

    public boolean deleteBankAccount(String accountNumber, String merchantId) throws BankAccountNotFoundException, MerchantNotFoundException {
        Merchant merchant = getMerchantById(merchantId);
        List<BankAccount> accounts = merchant.getBankAccounts();
        BankAccount account = accounts.stream().filter(s -> s.getAccountNumber().equals(accountNumber)).findAny().orElseThrow(() -> new BankAccountNotFoundException("No bank account found!"));
        accounts.remove(account);
        changeBankAccountFile();
        return true;
    }

    public void createMerchant(String id, String nameMerchantSc, LocalDateTime createdAt) {
        Merchant merchant = new Merchant(id, nameMerchantSc, createdAt);
        merchants.add(merchant);
        try (FileWriter writer = new FileWriter(FILE_MERCHANT, true)) {
            writer.write(merchant.getId() + " " + merchant.getName() + " "
                    + merchant.getCreatedAt() + " " + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Merchant getMerchantById(String merchantId) throws MerchantNotFoundException {
        return merchants.stream().filter(s -> s.getId().equals(merchantId)).findAny().orElseThrow(() -> new MerchantNotFoundException("Такого пользователя нет"));
    }

    public boolean deleteMerchant(String merchantId) throws MerchantNotFoundException {
        Merchant merchant = merchants.stream().filter(s -> s.getId().equals(merchantId)).findAny().orElseThrow(() -> new MerchantNotFoundException("Такого пользователя нет"));
        merchant.getBankAccounts().clear();
        merchants.remove(merchant);
        changeMerchantFile();
        return true;
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public void changeBankAccountFile() {
        try (FileWriter writer = new FileWriter(FILE_BANK_ACCOUNT_TEMP)) {
            for (Merchant m : merchants) {
                m.getBankAccounts().forEach(s -> {
                    try {
                        writer.write(s.getId() + " " + s.getMerchantId() + " " + s.getStatus() + " " + s.getAccountNumber() + " " +
                                s.getCreatedTime() + "\n");
                    } catch (IOException e) {
                        System.out.println("Не удалось обновить файл");
                    }
                });
            }
        } catch (IOException e) {
            System.out.println("Не удалось обновить файл");
        }
        File file1 = new File(FILE_BANK_ACCOUNT);
        File file2 = new File(FILE_BANK_ACCOUNT_TEMP);
        File file3 = new File(FILE_BANK_ACCOUNT);
        if (file1.exists() && file1.delete() && file2.exists()) {
            System.out.println(file2.renameTo(file3) ? "Обновление прошло успешно" :
                    "При обновлении merchant.txt произошла ошибка");
        }
    }

    public void changeMerchantFile() {
        try (FileWriter writer = new FileWriter(FILE_MERCHANT_TEMP)) {
            merchants.forEach(s -> {
                try {
                    writer.write(s.getId() + " " + s.getName() + " " + s.getCreatedAt() + "\n");
                } catch (IOException e) {
                    System.out.println("Не удалось обновить файл");
                }
            });
        } catch (IOException e) {
            System.out.println("Не удалось обновить файл");
        }
        File file1 = new File(FILE_MERCHANT);
        File file2 = new File(FILE_MERCHANT_TEMP);
        File file3 = new File(FILE_MERCHANT);
        if (file1.exists() && file1.delete() && file2.exists()) {
            System.out.println(file2.renameTo(file3) ? "Обновление прошло успешно" :
                    "При обновлении merchant.txt произошла ошибка");
        }
    }
}