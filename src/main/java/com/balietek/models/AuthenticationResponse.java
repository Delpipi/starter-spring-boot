package com.balietek.models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    
    private String jwt;
    private Utilisateur utilisateur;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String jwt, Utilisateur utilisateur) {
        this.jwt = jwt;
        this.utilisateur = utilisateur;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
}
