package fr.carchop.api.repositories;

import fr.carchop.api.models.Checkout;
import org.springframework.data.repository.CrudRepository;

public interface CheckoutDao extends CrudRepository<Checkout, Long> {
}
