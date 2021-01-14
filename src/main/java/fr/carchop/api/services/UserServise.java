package fr.carchop.api.services;

import fr.carchop.api.models.User;
import fr.carchop.api.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServise {
    @Autowired
    UserDAO userDAO;

    public Optional<User> getUserbyId(Long id){
        return userDAO.findById(id);
    }
    public void addUser(User user){
        userDAO.save(user);
    }

    public Optional<User>getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }
}
