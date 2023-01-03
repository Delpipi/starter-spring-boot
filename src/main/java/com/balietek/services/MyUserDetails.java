package com.balietek.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.balietek.models.Utilisateur;

public class MyUserDetails implements UserDetails{

    private String username;
    private String password;
    private Boolean activated;
    private Collection<? extends GrantedAuthority> authorities;
    private Utilisateur utilisateur;

    public MyUserDetails(Utilisateur utilisateur) {
        this.username = utilisateur.getUsername();
        this.password = utilisateur.getPassword();
        this.activated = utilisateur.getActivated();
        this.authorities = Arrays.asList(utilisateur.getRoles()).stream()
        .map(role ->  new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activated;
    }
    
}
