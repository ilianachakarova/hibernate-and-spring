package com.example.inttotospring.init;

import com.example.inttotospring.domain.AccountService;
import com.example.inttotospring.domain.UserService;
import com.example.inttotospring.models.Account;
import com.example.inttotospring.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Slf4j
public class AccountsDemoRunner implements ApplicationRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User("ivan petrov",25 );
        User user2 = new User("stamat dimitrov",45 );

        Account account1 = new Account(new BigDecimal(5200),user1);
        user1.getAccounts().add(account1);
        Account account2 = new Account(new BigDecimal(35000),user2);
        user2.getAccounts().add(account2);

        userService.registerUser(user1);
        userService.registerUser(user2);
        System.out.println("bla b;a");
        log.info("!!!! Initial bounds for user: {}", accountService.getAccount(account1.getId()));
        accountService.withdrawMoney(account1.getId(), BigDecimal.valueOf(500));
        log.info("Balanace after withdraw: {}", accountService.getAccount(account1.getId()));
        accountService.depositMoney(account1.getId(), BigDecimal.valueOf(500));
        log.info("Balanace after deposit: {}", accountService.getAccount(account1.getId()));
    }
}
