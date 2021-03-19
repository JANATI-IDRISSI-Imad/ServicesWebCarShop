package fr.carchop.api.repositories;

import fr.carchop.api.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDAO  extends CrudRepository<User, Long> {
    public Optional<User>getUserByEmail(String email);
    Optional<User>getUserByName(String name);
}
