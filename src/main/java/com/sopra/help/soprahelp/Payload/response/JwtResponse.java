package com.sopra.help.soprahelp.Payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String nom;
    private String prenom;
    private String matricule;
    private String email;
    private List<String> roles;
    public JwtResponse(String accessToken, Long id, String nom, String prenom,String matricule, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.email = email;
        this.roles = roles;
    }


}
