package fr.carchop.api.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserL {
    private String name;
    private String email;
    private String password;
}
