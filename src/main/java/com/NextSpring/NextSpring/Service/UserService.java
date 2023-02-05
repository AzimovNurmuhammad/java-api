package com.NextSpring.NextSpring.Service;

import com.NextSpring.NextSpring.Repository.UserRepository;
import com.NextSpring.NextSpring.entity.enummration.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

//    yuqoridagi funksiya userni ma'lumotlar bazasiga saqlaydigan funksiya


    public boolean existsByLogin(String login){
        return userRepository.existsByLogin(login);
    }
}
