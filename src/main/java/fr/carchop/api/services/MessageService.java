package fr.carchop.api.services;

import fr.carchop.api.models.Message;
import fr.carchop.api.repositories.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MessageService {
    @Autowired
    MessageDao messageDao;
    public void sendEmail(String email){
        try {

            String emailM="Bonjour " +"\n" +
                    "Nous avons bien reçu votre message" +"\n" +
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
            message.setSubject("Message reçu");
            message.setText(emailM);
            mailSender.send(message);
        }
        catch (Exception e){

        }
    }
    public void saveMessage(Message message){
        messageDao.save(message);
        sendEmail(message.getEmail());
    }
}
