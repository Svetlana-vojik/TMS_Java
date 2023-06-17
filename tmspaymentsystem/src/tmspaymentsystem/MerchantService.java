package tmspaymentsystem;

import tmspaymentsystem.exception.BankAccountNotFoundException;
import tmspaymentsystem.exception.MerchantNotFoundException;
import tmspaymentsystem.exception.NoBankAccountsFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static tmspaymentsystem.FilesPathes.FILE_BANK_ACCOUNT;
import static tmspaymentsystem.FilesPathes.FILE_MERCHANT;


public record MerchantService(List<Merchant> merchants) {
    public MerchantService(List<Merchant> merchants) {
        this.merchants = new ArrayList<>();
    }

    public void addBankAccount(Merchant merchant, BankAccount bankAccount) {
        if (Stream.of(bankAccount).anyMatch(s -> bankAccount.getAccountNumber().length() != 8 && bankAccount.getAccountNumber().matches("^\\d+"))) {
            throw new IllegalArgumentException("Номер банковского аккаунта неверный");
        }
        BankAccount tempBankAccount = merchant.getBankAccounts().stream().filter(s -> s.getAccountNumber().equals(bankAccount.getAccountNumber())).findFirst().orElse(null);
        if (tempBankAccount != null) {
            if (tempBankAccount.getStatus() == AccountStatus.DELETED) {
                tempBankAccount.setStatus(AccountStatus.ACTIVE);
            }
        } else {
            merchant.setBankAccounts((List<BankAccount>) bankAccount);

            try (FileWriter writer = new FileWriter(FILE_BANK_ACCOUNT + "bank_account.txt", true)) {
                writer.write(merchant.getId() + " " + bankAccount.getStatus() + " "
                        + bankAccount.getAccountNumber() + " " + bankAccount.getCreatedTime() + "\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<BankAccount> getMerchantBankAccounts(Merchant merchant) throws NoBankAccountsFoundException {
        if (merchant.getBankAccounts().isEmpty()) {
            throw new NoBankAccountsFoundException("У этого пользователя нет аккаунта");
        }
        return merchant.getBankAccounts().stream().sorted(Comparator.comparing(BankAccount::getCreatedTime)).sorted(Comparator.comparing(BankAccount::getStatus)).toList();
    }

    public void updateBankAccount(Merchant merchant, String number) throws BankAccountNotFoundException {
        merchant.getBankAccounts().stream().filter(s -> s.getAccountNumber().equals(number)).findFirst().orElseThrow(
                () -> new BankAccountNotFoundException("Банковский аккаунт не найден"));
    }


    public boolean deleteBankAccount(BankAccount bankAccount) throws MerchantNotFoundException, BankAccountNotFoundException, IOException {
        Merchant merchant = getMerchantById(bankAccount.getMerchantId());
        List<BankAccount> accounts = merchant.getBankAccounts();
        BankAccount account = accounts.stream().filter(s -> false).findAny().orElseThrow(() -> new BankAccountNotFoundException("Банковский аккаунт не найден"));
        accounts.remove(account);
        Files.write(Path.of(FILE_BANK_ACCOUNT), merchants.stream().map(Merchant::toString).toList());
        return true;
    }

    public void createMerchant(Merchant merchant) {
           merchants.add(merchant);
        try (FileWriter writer = new FileWriter(FILE_MERCHANT + "merchant.txt", true)) {
            writer.write(merchant.getId() + " " + merchant.getName() + " "
                    + merchant.getCreatedAt() + " " + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Merchant getMerchantById(String id) throws MerchantNotFoundException {
        for (Merchant merchant : merchants) {
            if (merchant.getId().equals(id)) {
                System.out.println(merchant);
            }
        }
        throw new MerchantNotFoundException("Такого пользователя нет");
    }

    public boolean deleteMerchant(String id) throws MerchantNotFoundException, IOException {
        for (Merchant merchant : merchants) {
            if (merchant.getId().equals(id)) {
                merchants.remove(merchant);
                Files.write(Path.of(FILE_MERCHANT), merchants.stream().map(Merchant::toString).toList());
                Files.write(Path.of(FILE_BANK_ACCOUNT), merchants.stream().map(Merchant::toString).toList());
            }
        }
        throw new MerchantNotFoundException("Такого пользователя нет");
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }
}