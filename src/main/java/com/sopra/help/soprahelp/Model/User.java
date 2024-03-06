package com.sopra.help.soprahelp.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "nom"),
                @UniqueConstraint(columnNames = "prenom"),
                @UniqueConstraint(columnNames = "matricule"),
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "password"),
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotBlank
    @Size(max = 20)
    private String nom;
    @Size(max = 20)
    @NotBlank
    private String prenom;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email ;
    @NotBlank
    @Size(max = 120)
    private String password;
    @NotBlank
    @Size(max = 120)
    private String matricule ;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
   private Set<Role> roles = new HashSet<>();
    public User(String nom,String prenom,String email,String password,String matricule){
        this.nom= nom;
        this.prenom=prenom;
        this.email=email;
        this.password=password;
        this.matricule=matricule;

    }
}
