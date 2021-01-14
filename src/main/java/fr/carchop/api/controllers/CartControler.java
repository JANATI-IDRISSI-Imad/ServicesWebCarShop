package fr.carchop.api.controllers;

import fr.carchop.api.models.Car;
import fr.carchop.api.models.Cart;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/addCarToCart/{email}/{id_Car}")
    public boolean addCarToCart(@PathVariable String email,@PathVariable Long id_Car) {
        return cartService.addCarToCart(email,id_Car);
    }
}
