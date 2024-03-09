package com.vdoderovic.usermanagementapp.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kompanija")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "naziv")
    private String companyName;
    @Column(name = "broj_zaposlenih")
    private Integer numOfEmployees;

    @OneToMany(mappedBy = "company")
    @JsonManagedReference
    private List<User> userList = new ArrayList<>();
}
