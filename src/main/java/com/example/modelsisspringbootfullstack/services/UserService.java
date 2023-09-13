package com.example.modelsisspringbootfullstack.services;

import com.example.modelsisspringbootfullstack.entities.User;
import com.example.modelsisspringbootfullstack.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(int id){return userRepository.findById(id);}

    public List<User> getAll(){return userRepository.findAll();}

    public User create(String userName, String password){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);


        return userRepository.save(user);
    }

    public User update(int id, User user){
        User newUser = findById(id).get();
        newUser.setUserName(user.getUserName());
        newUser.setPassword(user.getPassword());

        return userRepository.save(newUser);
    }

    public  void delete(int id){
        userRepository.deleteById(id);
    }
}
