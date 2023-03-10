package com.balietek.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.balietek.utils.LocalDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity(name = "utilisateur")
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La valeur est obligatoire")
    private String fullName;

    @NotBlank(message = "La valeur est obligatoire")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "La valeur est obligatoire")
    @Size(min = 8, message = "8 caractères requis")
    private String password;

    @Email(message = "Email invalide")
    private String email;

    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$", message = "Votre numéro est invalide")
    private String contact;
  
    @Type(StringArrayType.class)
    @Column(columnDefinition = "text[]")
    private String[] roles;

    private String gender;

    private Boolean activated;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime added;

    public Utilisateur() {
    }

    public Utilisateur(Long id, String fullName, String username,
            String password,String email,String contact,String gender,
            String[] roles, Boolean activated, LocalDateTime added) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.gender = gender;
        this.roles = roles;
        this.activated = activated;
        this.added = added;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", fullName=" + fullName + ", username=" + username + ", password=" + password
                + ", email=" + email + ", contact=" + contact + ", roles=" + Arrays.toString(roles) + ", gender="
                + gender + ", activated=" + activated + ", added=" + added + "]";
    }

    
}
