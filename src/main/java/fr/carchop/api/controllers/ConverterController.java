package fr.carchop.api.controllers;


import fr.carchop.api.converter.Converter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/currency")
public class ConverterController {

    @GetMapping(path = "/{currency}")
    public double convert(@PathVariable(value = "currency")  String currency){
        Converter converter = new Converter();
        return  converter.getRateFromDevise(currency);
    }
}