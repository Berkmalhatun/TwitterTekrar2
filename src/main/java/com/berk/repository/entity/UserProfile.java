package com.berk.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="tbluserprofile")
@NamedQueries({
        @NamedQuery(name = "UserProfile.existByUsername",
                query = "SELECT COUNT(p)>0 FROM UserProfile p WHERE p.username = :username"),
        @NamedQuery(name = "UserProfile.doLogin",
                query = "SELECT COUNT(p)>0 FROM UserProfile p " +
                        "WHERE p.username = :username AND p.password = :password"),
        @NamedQuery(name = "UserProfile.findByUsername",
                query = "SELECT p FROM UserProfile p WHERE p.username = :username")
})
public class UserProfile extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    String name;
    String surname;
    String website;
    String profileimg;
    String backgroundimg;
    Long memberdate;
    String memberdateview;
    boolean verifiadaccount;

}
