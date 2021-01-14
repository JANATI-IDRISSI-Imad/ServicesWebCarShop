package fr.carchop.api.controllers;

import fr.carchop.api.models.Car;
import fr.carchop.api.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("Car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/get/{id}")
    public Optional<Car> getCarById(@PathVariable Long id){
        System.out.println("#######################"+id);
        return carService.getCarById(id);
    }
    @GetMapping("/getByEmail/{email}")
    public Optional<Car> getCarByName(@PathVariable String name){
        return carService.getCarByName(name);
    }
}
