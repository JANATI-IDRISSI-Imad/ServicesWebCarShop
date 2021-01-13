package fr.carchop.api.repositories;

import fr.carchop.api.models.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarDao extends CrudRepository<Car, Long> {


}
