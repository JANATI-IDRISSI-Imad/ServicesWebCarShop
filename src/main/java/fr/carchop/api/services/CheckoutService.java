package fr.carchop.api.services;

import fr.carchop.api.models.Cart;
import fr.carchop.api.models.Checkout;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.repositories.CheckoutDao;
import fr.carchop.api.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CheckoutService {

    @Autowired
    CheckoutDao checkoutDao;

    public void addCheckout(Checkout checkout) {
        checkoutDao.save(checkout);
    }
}
