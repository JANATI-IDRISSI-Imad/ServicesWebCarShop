package fr.carchop.api.services;

import fr.carchop.api.models.Cart;
import fr.carchop.api.models.User;
import fr.carchop.api.models.UserL;
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
    public Optional<User> getUserByName(String name){return userDAO.getUserByName(name);}
    public Boolean addUser(UserL user){
        try {
            User user2=new User(Long.valueOf(1),user.getName(),user.getEmail(),user.getPassword(),new ArrayList<>());
            userDAO.save(user2);
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

    public Boolean login(UserL user){
            Optional<User>ouser =getUserByEmail(user.getEmail());
            if(ouser.get()!=null){
                if(ouser.get().getPassword().equals(user.getPassword()))return true;
                return false;
            }
        return false;
    }
}
