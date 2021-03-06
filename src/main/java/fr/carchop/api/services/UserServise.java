package fr.carchop.api.services;

import fr.carchop.api.models.Cart;
import fr.carchop.api.models.User;
import fr.carchop.api.models.UserL;
import fr.carchop.api.repositories.CarDao;
import fr.carchop.api.repositories.CartDAO;
import fr.carchop.api.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Properties;

@Service
public class UserServise {
    @Autowired
    UserDAO userDAO;
    @Autowired
    CartDAO cartDao;

    public Optional<User> getUserbyId(Long id){
        return userDAO.findById(id);
    }
    public Optional<User> getUserByName(String name){return userDAO.getUserByName(name);}
    public Boolean addUser(User user){
        try {
            user.setNotification(new ArrayList<>());
            userDAO.save(user);
            Optional<User> user1=getUserByEmail(user.getEmail());
            Cart cart=new Cart(0,user1.get(),new ArrayList<>());
            cartDao.save(cart);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public Optional<User>getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }

    public Boolean login(UserL user){
            Optional<User>ouser =getUserByEmail(user.getEmail());
            if(ouser.get()!=null){
                if(ouser.get().getPassword().equals(user.getPassword()))return true;
                return false;
            }
        return false;
    }


    public boolean passforget(String code, String email){
        try {

            String emailM="Bonjour " +"\n" +
                    "votre code de validation est : "+code+" \n" +
                    "Ce code est valable seulement 1 heures. Si vous ne réinitialisez pas votre mot de passe dans ce délai, vous devez demander un autre email de réinitialisation du mot de passe.\n" +
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
            message.setSubject("Réinitialiser le mot de passe");
            message.setText(emailM);
            mailSender.send(message);
            return  true;
        }
        catch (Exception e){

        }
        return false;
    }



    public boolean changepassword(String email,String pass){
        try{
            Optional<User> user=getUserByEmail(email);
            if(user.get()!=null){
                user.get().setPassword(pass);
                userDAO.save(user.get());
                return true;
            }
        }
        catch (Exception e){

        }
        return false;
    }



    public  Boolean updateUser(UserL userL){
        try {
            Optional<User> user=getUserByEmail(userL.getEmail());
            if(user.get()!=null){
                user.get().setName(userL.getName());
                user.get().setPassword(userL.getPassword());
               // user.get().setAdress(userL.getAdress());
                userDAO.save(user.get());
                return  true;
            }
        }catch (Exception e){

        }
        return false;
    }
}
