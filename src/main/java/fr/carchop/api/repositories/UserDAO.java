package fr.carchop.api.repositories;

import fr.carchop.api.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO  extends CrudRepository<User, Long> {
}
