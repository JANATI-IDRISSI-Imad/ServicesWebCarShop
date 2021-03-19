package fr.carchop.api.repositories;

import fr.carchop.api.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageDao extends CrudRepository<Message, Long> {
}
