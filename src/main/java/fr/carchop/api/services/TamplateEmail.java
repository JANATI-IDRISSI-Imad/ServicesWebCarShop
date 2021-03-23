package fr.carchop.api.services;

import fr.carchop.api.models.Car;
import fr.carchop.api.models.Cart;

import java.util.List;

public class TamplateEmail {
    Cart cart;

    public TamplateEmail(Cart cart) {
        this.cart = cart;
    }
    public TamplateEmail() {
    }

    public String getMessage(){
        String a= "Bonjour "+cart.getUser().getName() +" \n" +
                "Felicitation,l'achat est bien effectue"+
                "        "+"         voiture          "+"    Prix   "+" \n";
                for(Car c: cart.getCars()){
                    a=a+"        "+c.getName()+"         voiture          "+"    Prix   "+" \n";
                }

        return a;
    }
}
