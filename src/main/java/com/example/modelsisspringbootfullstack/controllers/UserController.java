package com.example.modelsisspringbootfullstack.controllers;

import com.example.modelsisspringbootfullstack.entities.User;
import com.example.modelsisspringbootfullstack.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/test_recrutement")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> add(@RequestParam("userName") String userName, @RequestParam("password") String password){
        userService.create(userName,password);
        return ResponseEntity.ok().body("{\"message\": \"utilisateur ajouté\"}");
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> get(@PathVariable("id") int id){
        User user = userService.findById(id).get();
        return ResponseEntity.ok().body(user);
    }
    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getAll();
        return ResponseEntity.ok().body(users);
    }
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return ResponseEntity.ok().body("{\"message\": \"utulisateur supprimé\"}");
    }
    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user){
        User newUser = userService.update(id, user);
        return ResponseEntity.ok().body(newUser);
    }


}
