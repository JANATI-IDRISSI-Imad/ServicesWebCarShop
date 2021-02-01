package fr.carchop.api.controllers;
import fr.carchop.api.models.User;
import fr.carchop.api.models.UserL;
import fr.carchop.api.services.UserServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserServise userServise;

    @GetMapping("/get/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        Optional<User> o = userServise.getUserbyId(id);
        return o;
    }

    @PostMapping("/add")
    public Boolean addUser(@RequestBody UserL user) {
        return userServise.addUser(user);
    }

    @GetMapping("/getUserByName/{name}")
    public Optional<User> getUserByName(@PathVariable String name) {
        return userServise.getUserByName(name);
    }

    @GetMapping("/getByEmail/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userServise.getUserByEmail(email);
    }

    @PostMapping("/Login")
    public Boolean login(@RequestBody UserL user) {
        return userServise.login(user);
    }

    @RequestMapping("/passforget/{email}/{code}")
    public Boolean passforget(@PathVariable String code, @PathVariable String email) {
        return userServise.passforget(code, email);
    }

    @RequestMapping("/changepassword/{email}/{pass}")
    public Boolean changepassword(@PathVariable String email, @PathVariable String pass) {
        return userServise.changepassword(email, pass);
    }

    @PostMapping("/UpdateUser")
    public Boolean updateUser(@RequestBody UserL userL) {
        return userServise.updateUser(userL);
    }

}
