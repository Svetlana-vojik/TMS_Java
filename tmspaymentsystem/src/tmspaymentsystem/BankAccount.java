package tmspaymentsystem;

import java.time.LocalDateTime;
import java.util.Arrays;

public class BankAccount extends Merchant {
    private String id;
    private String merchantId;
    private AccountStatus status;
    private String accountNumber;
    private LocalDateTime createdTime;

    public BankAccount(String id, AccountStatus status, String accountNumber, LocalDateTime createdTime) {
        this.id = id;
        this.merchantId = merchantId;
        this.status = status;
        this.accountNumber = accountNumber;
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    }