package fr.carchop.api.services;

import fr.carchop.api.models.Notification;
import fr.carchop.api.models.User;
import fr.carchop.api.repositories.NotificationDao;
import fr.carchop.api.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class NotificationService {

    @Autowired
    NotificationDao notificationDao;
    @Autowired
    UserServise userServise;
    @Autowired
    UserDAO userDAO;
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
           userDAO.save(user.get());
           return true;
        }
        return false;
    }


    public boolean notifyByEmail( String email){
        try {

            String emailM="Bonjour " +"\n" +
                    "Felicitation,l'achat est bien effectue"+
                    "\n" +
                    "Meilleures salutations, \n" +
                    "\n*** Veuillez noter qu'il s'agit d'un courrier électronique généré automatiquement qui ne peut pas recevoir de réponses ***\n" ;

            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);
            mailSender.setUsername("noreplycarshopapp@gmail.com");
            mailSender.setPassword("xqsfkatkqxqgpyfs");
            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreplycarshopapp@gmail.com");
            message.setTo(email);
            message.setSubject("Merci beaucoup pour votre achat");
            message.setText(emailM);
            mailSender.send(message);
            return  true;
        }
        catch (Exception e){

        }
        return false;
    }



}
