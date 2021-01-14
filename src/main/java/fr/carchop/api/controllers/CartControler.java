package fr.carchop.api.controllers;

import fr.carchop.api.models.Car;
import fr.carchop.api.models.Cart;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("Cart")
public class CartControler {
    @Autowired
    CartService cartService;

    @GetMapping("/getByEmailUser/{email}")
    public Optional<Cart> getCartByUserEmail(@PathVariable String email){
        return cartService.getCartByUserEmail(email);
    }
    @GetMapping("/gatTotalCart/{id}")
    public Double gatTotalCart (@PathVariable Long id){
        return cartService.gatTotalCart(id);
    }
}
