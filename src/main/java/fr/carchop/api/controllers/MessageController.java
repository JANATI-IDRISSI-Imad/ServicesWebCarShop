package fr.carchop.api.controllers;

import fr.carchop.api.models.Checkout;
import fr.carchop.api.models.Message;
import fr.carchop.api.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/ContactUs")
    public void addCheckout(@RequestBody Message message){
        messageService.saveMessage(message);
    }
    @GetMapping("t")
    public void test(){
        messageService.test("imad.janati.idrissi@gmail.com");
    }
}
