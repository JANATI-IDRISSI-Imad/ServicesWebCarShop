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

public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String model;
    @Column(name = "img", length = 1000000000)
    private byte[] img;
    private double price;
    private String description;


}
