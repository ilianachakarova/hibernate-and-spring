package com.example.inttotospring.domain;

import com.example.inttotospring.models.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account getAccount(long accountId);
    void withdrawMoney(long accountId, BigDecimal amount);
    void depositMoney(long accountId, BigDecimal amount);
    void transferMoney(long fromId, long toId, BigDecimal amount);
}
