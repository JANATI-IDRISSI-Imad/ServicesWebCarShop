package fr.carchop.api.repositories;

import fr.carchop.api.models.Cart;
import fr.carchop.api.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartDAO extends CrudRepository<Cart, Long> {
    public Optional<Cart> findCartByUser(User user);
}
