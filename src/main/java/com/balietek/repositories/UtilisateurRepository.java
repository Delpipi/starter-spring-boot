package com.balietek.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balietek.exceptions.ResourceNoFoundException;
import com.balietek.models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
    Optional<Utilisateur> findByUsername(String username) throws ResourceNoFoundException;
}
