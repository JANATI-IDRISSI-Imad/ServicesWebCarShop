package fr.carchop.api.services;

import fr.carchop.api.models.Notification;
import fr.carchop.api.models.User;
import fr.carchop.api.repositories.NotificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NotificationService {

    @Autowired
    NotificationDao notificationDao;
    @Autowired
    UserServise userServise;
    public List<Notification> getNotifByUser(String email){
       Optional<User> user = userServise.getUserByEmail(email);
       if(user.get() != null){
           return user.get().getNotification();
       }
       return null;
    }

    public Boolean notify(String email){
        Optional<User> user = userServise.getUserByEmail(email);
        if(user.get() != null){
           user.get().notification.add(new Notification(Long.valueOf(0),"Felicitation,l'achat est bien effectue"));
           userServise.addUser(user.get());
           return true;
        }
        return false;
    }



}
