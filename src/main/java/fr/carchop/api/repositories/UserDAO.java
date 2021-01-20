package fr.carchop.api.repositories;

import fr.carchop.api.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO  extends CrudRepository<User, Long> {
    public Optional<User>getUserByEmail(String email);
    Optional<User>getUserByName(String name);
}
