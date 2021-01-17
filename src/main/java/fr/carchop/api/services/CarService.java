package fr.carchop.api.services;

import fr.carchop.api.models.Car;
import fr.carchop.api.repositories.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarDao carDao;
    public Optional<Car>getCarById(Long id){
        return carDao.findById(id);
    }
    public Optional<Car>getCarByName(String name){return carDao.getCarByName(name);}
    public void addCar(Car car){carDao.save(car);}
    public Optional<Car>getCarByModel(String model){return carDao.getCarByModel(model);}
    public Optional<Car>getCarByAdress(String adress){return carDao.getCarByAdress(adress);}
}
