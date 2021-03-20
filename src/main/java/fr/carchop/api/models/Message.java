package fr.carchop.api.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullName;
    private String email;
    private String phone;
    private String message;

    public Message(String fullName, String email, String phone, String message) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }
}
