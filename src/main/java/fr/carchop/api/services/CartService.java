package fr.carchop.api.services;

import fr.carchop.api.models.Car;
import fr.carchop.api.models.Cart;
import fr.carchop.api.models.User;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartDAO cartDAO;
    @Autowired
    UserServise userServise;
    public Optional<Cart> getCartByUserEmail(String email){
        Optional<User> userByEmail=userServise.getUserByEmail(email);
        System.out.println(userByEmail.get().toString());
        if(userByEmail.get()!=null){
            return  cartDAO.findCartByUser(userByEmail.get());
        }
        else {
            return null;
        }
    }
    public Double gatTotalCart(Long id){
        Double d=0.;
        Optional<Cart> cart=cartDAO.findById(id);
        if(cart.get()!=null){
            for (Car car : cart.get().getCars()) {
                d=d+car.getPrice();
            }
        }
        return d;
    }
}
