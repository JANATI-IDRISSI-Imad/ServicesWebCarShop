package fr.carchop.api.repositories;

import fr.carchop.api.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarDao extends CrudRepository<Car, Long> {
    public Optional<Car> getCarByName(String name);
    public Optional<Car> getCarByModel(String model);
    public Optional<Car> getCarByAdress(String adress);
}
