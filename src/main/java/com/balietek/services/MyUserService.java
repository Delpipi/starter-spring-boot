package com.balietek.services;

import java.util.List;

import com.balietek.exceptions.ResourceNoFoundException;
import com.balietek.models.Utilisateur;

public interface MyUserService {
    public List<Utilisateur> getAllUtilisateurs();
    public Utilisateur getUtilisateurById(Long id) throws ResourceNoFoundException;
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) throws Exception;
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long id) throws ResourceNoFoundException;
    public Utilisateur deleteUtilisateur(Long id) throws ResourceNoFoundException;
}
