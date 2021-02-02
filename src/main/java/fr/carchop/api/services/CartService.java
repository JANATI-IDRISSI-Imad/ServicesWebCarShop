package fr.carchop.api.services;

import fr.carchop.api.models.Car;
import fr.carchop.api.models.Cart;
import fr.carchop.api.models.User;
import fr.carchop.api.repositories.CarDao;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartDAO cartDAO;
    @Autowired
    UserServise userServise;
    @Autowired
    CarDao carDAO;
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
    public List<Car> getCarFromCartByEmal(String email){
        Optional<User> userByEmail=userServise.getUserByEmail(email);
        System.out.println(userByEmail.get().toString());
        if(userByEmail.get()!=null){
            return  cartDAO.findCartByUser(userByEmail.get()).get().getCars();
        }
        else {
            return null;
        }
    }
    public Double gatTotalCart(String email){
        Double d=0.;
        Optional<Cart> cart=getCartByUserEmail(email);
        if(cart.get()!=null){
            for (Car car : cart.get().getCars()) {
                d=d+car.getPrice();
            }
        }
        return d;
    }
    public Boolean addCarToCart(String email, Long id){
        Optional<Cart> cart=getCartByUserEmail(email);
        Optional<Car>car=carDAO.findById(id);
        if (car.get()!=null&& cart.get()!=null){
            Cart cart1=cart.get();
            cart1.getCars().add(car.get());
            cartDAO.save(cart1);
            return true;
        }
        return false;
    }

    public List<Car> getCarFromCart(Long id_cart){
        Optional<Cart> cart = cartDAO.findById(id_cart);
        if(cart.get() != null){
            return cart.get().getCars();
        }
        return null;

    }
    public Boolean deleteCarFromCart(String email, Long id){
        Optional<Cart> cart=getCartByUserEmail(email);
        Optional<Car>car=carDAO.findById(id);
        if (car.get()!=null&& cart.get()!=null){
            Cart cart1=cart.get();
            cart1.getCars().remove(car.get());
            cartDAO.save(cart1);
            return true;
        }
        return false;
    }

    public Boolean clearCart(String email){
        Optional<Cart> cart=getCartByUserEmail(email);
        if ( cart.get()!=null){
            cart.get().getCars().clear();
            cartDAO.save(cart.get());
            return true;
        }
        return false;
    }

    public Boolean validateCart(String email){
        Optional<Cart> cart=getCartByUserEmail(email);
        if ( cart.get()!=null){
            cart.get().getCars().clear();
            cartDAO.save(cart.get());
            return true;
        }
        return false;
    }
}
