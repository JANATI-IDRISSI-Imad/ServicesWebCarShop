package fr.carchop.api.controllers;

import fr.carchop.api.models.Car;
import fr.carchop.api.models.Cart;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/gatTotalCart/{email}")
    public Double gatTotalCart (@PathVariable String email){
        return cartService.gatTotalCart(email);
    }
    @RequestMapping("/addCarToCart/{email}/{id_Car}")
    public boolean addCarToCart(@PathVariable String email,@PathVariable Long id_Car) {
        return cartService.addCarToCart(email,id_Car);
    }

    @GetMapping("/getCarFromCart/{id_cart}")
    public List<Car> getCarFromCart(@PathVariable Long id_cart){
        return cartService.getCarFromCart(id_cart);
    }
    @GetMapping("/getCarFromCartByEmal/{email}")
    public List<Car> getCarFromCartByEmal(@PathVariable String email){
        return cartService.getCarFromCartByEmal(email);
    }
    @RequestMapping("/deleteCarFromCart/{email}/{id_Car}")
    public boolean deleteCarFromCart(@PathVariable String email,@PathVariable Long id_Car) {
        return cartService.deleteCarFromCart(email,id_Car);
    }
    @RequestMapping("/clearCart/{email}")
    public boolean clearCart(@PathVariable String email) {
        return cartService.clearCart(email);
    }
    @RequestMapping("/validateCart/{email}")
    public boolean validateCart(@PathVariable String email) {
        return cartService.validateCart(email);
    }
    @RequestMapping("/getSizeCarInCart/{email}")
    public int getSizeCarInCart(@PathVariable String email) {
        return cartService.getCarFromCartByEmal(email).size();
    }

}
