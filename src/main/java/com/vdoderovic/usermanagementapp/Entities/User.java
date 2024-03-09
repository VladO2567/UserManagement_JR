package com.vdoderovic.usermanagementapp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vdoderovic.usermanagementapp.Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "korisnik")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "ime")
    private String firstName;
    @Column(name = "prezime")
    private String lastName;
    @Column(name = "datum_rodj")
    private LocalDate dob;
    @Column(name = "pol", columnDefinition = "TINYINT")
    private Gender gender;
    @Column(name = "datum_kreiranja")
    private LocalDate createdAt;
    @Column(name = "aktivan")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grad_id")
    @JsonBackReference
    private City city;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zemlja_id")
    @JsonBackReference
    private Country country;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija_id")
    @JsonBackReference
    private Company company;
}
