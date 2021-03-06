package fr.carchop.api.controllers;

import fr.carchop.api.models.Car;
import fr.carchop.api.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("Car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/get/{id}")
    public Optional<Car> getCarById(@PathVariable Long id){
        return carService.getCarById(id);
    }

    @GetMapping("/getByName/{name}")
    public Optional<Car> getCarByName(@PathVariable String name){
        return carService.getCarByName(name);
    }

    @GetMapping("getByModel/{model}")
    public Optional<Car> getCarByModel(@PathVariable String model){
        return carService.getCarByModel(model);
    }

    @GetMapping("getByAdress/{adress}")
    public Optional<Car> getCarByAdress(@PathVariable String adress){ return carService.getCarByAdress(adress);}

    @GetMapping("/getAllCars")
    public Iterable<Car> getAllCars(){return carService.getAllCar();}

    @PostMapping("/addCar")
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

}
