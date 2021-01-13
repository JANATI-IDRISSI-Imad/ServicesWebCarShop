package fr.carchop.api.services;

import fr.carchop.api.models.Car;
import fr.carchop.api.repositories.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServise {

    @Autowired
    CarDao carDao;
    public Optional<Car>getCarById(Long id){
        return carDao.findById(id);
    }
}
