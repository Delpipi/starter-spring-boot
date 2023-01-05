package com.balietek.services.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.balietek.exceptions.ResourceNoFoundException;
import com.balietek.exceptions.UserAlreadyExistException;
import com.balietek.models.Utilisateur;
import com.balietek.repositories.UtilisateurRepository;
import com.balietek.services.MyUserService;

@Service
public class MyUserServiceImpl implements MyUserService{

    Logger logger = LoggerFactory.getLogger(MyUserServiceImpl.class);

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Utilisateur> getAllUtilisateurs(){
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) throws ResourceNoFoundException {
        return utilisateurRepository.findById(id).orElseThrow(()-> new ResourceNoFoundException("Utilisateur","Id", id));
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) throws Exception {

        if(utilisateur != null && utilisateur.getUsername() != null && !utilisateur.getUsername().trim().equals("")){
            Optional<Utilisateur> existingUtilisateur = utilisateurRepository.findByUsername(utilisateur.getUsername());
            if(existingUtilisateur != null && existingUtilisateur.isPresent()){
                throw new UserAlreadyExistException("Le nom utilisateur est existant, Merci d'en definir un autre");
            }else{
                utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
                return utilisateurRepository.save(utilisateur);
            }
        }else{
            throw new Exception("La sauvegarde à echouer");
        }
    }

    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long id) throws ResourceNoFoundException {
        Optional<Utilisateur> deletedUtilisateur = utilisateurRepository.findById(id);
        if(deletedUtilisateur.isPresent()){
            return utilisateurRepository.save(utilisateur);
        }else{
            throw new ResourceNoFoundException("Utilisateur","Id", id);
        }
    }

    @Override
    public Utilisateur deleteUtilisateur(Long id) throws ResourceNoFoundException{
        Optional<Utilisateur> deletedUtilisateur = utilisateurRepository.findById(id);
        if(deletedUtilisateur.isPresent()){
            utilisateurRepository.deleteById(id);
            return deletedUtilisateur.get();
        }else{
            throw new ResourceNoFoundException("Utilisateur","Id", id);
        }
    }
}