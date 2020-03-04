package com.example.inttotospring.domain;

import com.example.inttotospring.dao.UserRepository;
import com.example.inttotospring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;
    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
}
