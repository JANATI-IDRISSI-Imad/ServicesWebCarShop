package fr.carchop.api.controllers;

import fr.carchop.api.models.Notification;
import fr.carchop.api.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("Notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;
    @GetMapping("/getNotifByUser/{email}")
    public List<Notification> getNotificationByUser(@PathVariable String email){
        return notificationService.getNotifByUser(email);
    }

    @RequestMapping("/notify/{email}")
    public Boolean notify(@PathVariable String email){
        return notificationService.notify(email);
    }

    @RequestMapping("/notifyByEmail/{email}")
    public Boolean notifyByEmail(@PathVariable String email){
        return notificationService.notifyByEmail(email);
    }
}
