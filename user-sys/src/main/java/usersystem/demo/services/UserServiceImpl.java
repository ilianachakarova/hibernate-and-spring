package usersystem.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usersystem.demo.entities.User;
import usersystem.demo.repositories.UserRepository;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
@Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void seedUsers() {
        User user = new User();
        user.setFirstName("kjsdks");
        user.setLastName("kdfjhf");
        user.setAge(25);
        user.setEmail("klsddkf@abv.bg");
        user.setUsername("iliana121212");
        user.setPassword("jfADJ&6");

    this.userRepository.saveAndFlush(user);
    }
}
