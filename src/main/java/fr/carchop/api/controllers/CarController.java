package fr.carchop.api.controllers;

import fr.carchop.api.models.Car;
import fr.carchop.api.services.CarServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Car")
public class CarController {
    @Autowired
    CarServise carServise;

    @GetMapping("/get/{id}")
    public Optional<Car> getCarById(@PathVariable Long id){
        return carServise.getCarById(id);
    }

}
