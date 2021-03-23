package fr.carchop.api.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullname;
    private String adresse;
    private long zipcode;
    private String city;
    private String creditcard;
    private int ccv;
    private String expdate;
    private String email;
}
