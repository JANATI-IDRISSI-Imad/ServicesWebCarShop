package fr.carchop.api.models;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String password;
    public long getId() {
        return id;
    }
    @OneToMany(cascade = {CascadeType.ALL})
    public List<Notification> notification;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
