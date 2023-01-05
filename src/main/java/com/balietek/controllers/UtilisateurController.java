package com.balietek.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balietek.exceptions.ResourceNoFoundException;
import com.balietek.exceptions.UserAlreadyExistException;
import com.balietek.models.Utilisateur;
import com.balietek.services.MyUserDetails;
import com.balietek.services.MyUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UtilisateurController {

    Logger logger = LoggerFactory.getLogger(UtilisateurController.class);

    @Autowired
    private MyUserService myUserService;


    @GetMapping()
    public ResponseEntity<?> getAllUtilisateurs() {
        return ResponseEntity.ok(myUserService.getAllUtilisateurs());
    }

    @GetMapping(value="{id}")
    public ResponseEntity<?> getUtilisateurById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(myUserService.getUtilisateurById(id));
        } catch (ResourceNoFoundException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping(value = "register")
    public ResponseEntity<?> saveUtilisateur(@Valid  @RequestBody Utilisateur utilisateur) {
        logger.info("Utilisateur info:" + utilisateur.toString());
        try {
            return ResponseEntity.ok(myUserService.saveUtilisateur(utilisateur));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    // @PostMapping(value = "authenticate")
    // public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
    //     logger.info("Authentication Request info:" + authenticationRequest.toString());
    //     try {
    //         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

    //         SecurityContextHolder.getContext().setAuthentication(authentication);

    //         MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();

    //         final String jwt = jwtTokenUtil.generateToken(myUserDetails);
            
    //         return ResponseEntity.ok(new AuthenticationResponse(jwt, myUserDetails.getUtilisateur()));
    //     } catch (BadCredentialsException e) {
    //         return ResponseEntity.internalServerError().body("Erreur");
    //     }
    // }

    @PutMapping(value="{id}")
    public ResponseEntity<?> updateUtilisateur(@PathVariable("id") Long id, @Valid  @RequestBody Utilisateur utilisateur) {
        try {
            return ResponseEntity.ok(myUserService.updateUtilisateur(utilisateur, id));
        } catch (ResourceNoFoundException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(myUserService.deleteUtilisateur(id));
        } catch (ResourceNoFoundException e) {
            logger.error("=== Error database" + e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    
}
