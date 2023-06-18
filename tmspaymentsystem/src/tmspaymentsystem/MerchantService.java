package tmspaymentsystem;

import tmspaymentsystem.exception.BankAccountNotFoundException;
import tmspaymentsystem.exception.MerchantNotFoundException;
import tmspaymentsystem.exception.NoBankAccountsFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static tmspaymentsystem.FilesPaths.FILE_BANK_ACCOUNT;
import static tmspaymentsystem.FilesPaths.FILE_MERCHANT;


public class MerchantService {
    private List<Merchant> merchants;

    public MerchantService(List<Merchant> merchants) {
        this.merchants = merchants;
    }


    public void addBankAccount(Merchant merchant, BankAccount bankAccount) {
        if (Stream.of(bankAccount).anyMatch(s -> bankAccount.getAccountNumber().length() != 8 && bankAccount.getAccountNumber().matches("^\\d+"))) {
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

    public List<BankAccount> getMerchantBankAccounts(Merchant merchant) throws NoBankAccountsFoundException {
        if (merchant.getBankAccounts().isEmpty()) {
            throw new NoBankAccountsFoundException("У этого пользователя нет аккаунта");
        }
        return merchant.getBankAccounts().stream().sorted(Comparator.comparing(BankAccount::getCreatedTime)).sorted(Comparator.comparing(BankAccount::getStatus)).toList();
    }

    public boolean updateBankAccount(String bankAccountId, String newAccountNumber, String idScanner) throws BankAccountNotFoundException, IOException, MerchantNotFoundException {
        Merchant merchant = getMerchantById(idScanner);
        List<BankAccount> accounts = merchant.getBankAccounts();
        BankAccount account = accounts.stream().filter(s -> s.getAccountNumber().equals(bankAccountId)).findAny().orElseThrow(() -> new BankAccountNotFoundException("No bank account found!"));
        account.setAccountNumber(newAccountNumber);
        Files.write(Path.of(FILE_BANK_ACCOUNT), merchants.stream().map(Merchant::toString).toList());
        return true;
    }

    public boolean deleteBankAccount(String idScannerDelete, String idScanner) throws BankAccountNotFoundException, MerchantNotFoundException, IOException {
        Merchant merchant = getMerchantById(idScanner);
        List<BankAccount> accounts = merchant.getBankAccounts();
        BankAccount account = accounts.stream().filter(s -> s.getAccountNumber().equals(idScannerDelete)).findAny().orElseThrow(() -> new BankAccountNotFoundException("No bank account found!"));
        accounts.remove(account);
        Files.write(Path.of(FILE_BANK_ACCOUNT), merchants.stream().map(Merchant::toString).toList());
        return true;
    }

    public void createMerchant(Merchant merchant) {
        merchants.add(merchant);
        try (FileWriter writer = new FileWriter(FILE_MERCHANT, true)) {
            writer.write(merchant.getId() + " " + merchant.getName() + " "
                    + merchant.getCreatedAt() + " " + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Merchant getMerchantById(String idScanner) throws MerchantNotFoundException {
        return merchants.stream().filter(s -> s.getId().equals(idScanner)).findAny().orElseThrow(() -> new MerchantNotFoundException("Такого пользователя нет"));
    }

    public boolean deleteMerchant(String idDelete) throws MerchantNotFoundException, IOException {
        Merchant merchant = merchants.stream().filter(s -> s.getId().equals(idDelete)).findAny().orElseThrow(() -> new MerchantNotFoundException("Такого пользователя нет"));
        merchants.remove(merchant);
        Files.write(Path.of(FILE_MERCHANT), merchants.stream().map(Merchant::toString).toList());
        Files.write(Path.of(FILE_BANK_ACCOUNT), merchants.stream().map(Merchant::toString).toList());
        return true;
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }
}