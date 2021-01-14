package fr.carchop.api.controllers;

import fr.carchop.api.models.User;
import fr.carchop.api.services.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserServise userServise;
    @GetMapping("/get/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        Optional<User>o=userServise.getUserbyId(id);
        return o;
    }
    @PostMapping("/add")
    public  Boolean addUser(@RequestBody User user){
        return userServise.addUser(user);
    }

    @GetMapping("/getByEmail/{email}")
    public  Optional<User>getUserByEmail(@PathVariable String email){
        return userServise.getUserByEmail(email);
    }


}
