package fr.carchop.api.services;

import fr.carchop.api.models.Cart;
import fr.carchop.api.models.Checkout;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckoutService {
    @Autowired
    CartDAO cartDAO;

    @Autowired
    UserDAO userDAO;

    public Boolean addCheckout(Checkout checkout, String email) {
        try {

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
