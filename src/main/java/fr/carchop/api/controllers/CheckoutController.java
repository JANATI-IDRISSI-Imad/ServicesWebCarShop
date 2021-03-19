package fr.carchop.api.controllers;

import fr.carchop.api.models.Cart;
import fr.carchop.api.models.Checkout;
import fr.carchop.api.services.CartService;
import fr.carchop.api.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Checkout")
public class CheckoutController {

    @Autowired
    CheckoutService checkoutService;
    @Autowired
    CartService cartService;

    @PostMapping("/addCheckout")
    public void addCheckout(@RequestBody Checkout checkout){
        cartService.validateCart(checkout.getEmail());
        checkoutService.addCheckout(checkout);
    }
}
