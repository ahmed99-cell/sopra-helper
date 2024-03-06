package com.sopra.help.soprahelp.Controllers;

import com.sopra.help.soprahelp.Exception.UserNotFoundException;
import com.sopra.help.soprahelp.Model.User;
import com.sopra.help.soprahelp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@CrossOrigin(origins = "http://localhost:3000")*/
@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id).map(user -> {
            user.setNom(newUser.getNom());
            user.setPrenom(newUser.getPrenom());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            user.setMatricule(newUser.getMatricule());
            user.setRoles(newUser.getRoles());
            return userRepository.save((user));
        }).orElseThrow(() -> new UserNotFoundException(id));
    }
    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new  UserNotFoundException(id);

        }
        userRepository.deleteById(id);
        return "user with id " +id+ "has been deleted successfylly";

    }


}
