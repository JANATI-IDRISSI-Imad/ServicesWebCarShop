package fr.carchop.api.services;

import fr.carchop.api.models.Cart;
import fr.carchop.api.models.User;
import fr.carchop.api.repositories.CarDao;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServise {
    @Autowired
    UserDAO userDAO;
    @Autowired
    CartDAO cartDao;

    public Optional<User> getUserbyId(Long id){
        return userDAO.findById(id);
    }
    public Boolean addUser(User user){
        try {
            userDAO.save(user);
            Optional<User> user1=getUserByEmail(user.getEmail());
            Cart cart=new Cart(0,user1.get(),new ArrayList<>());
            cartDao.save(cart);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public Optional<User>getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }
}
