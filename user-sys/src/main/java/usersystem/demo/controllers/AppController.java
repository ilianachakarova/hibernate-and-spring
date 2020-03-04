package usersystem.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import usersystem.demo.services.UserService;

@Controller
public class AppController implements CommandLineRunner {
private final UserService userService;
    @Autowired
    public AppController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
    userService.seedUsers();

    }
}
