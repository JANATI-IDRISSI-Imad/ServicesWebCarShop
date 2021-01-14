package fr.carchop.api.repositories;

import fr.carchop.api.models.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationDao extends CrudRepository<Notification,Long> {

}
