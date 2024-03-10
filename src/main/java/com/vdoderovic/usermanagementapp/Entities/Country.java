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
@Table(name = "drzava")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "naziv")
    String countryName;

    @Column(name = "populacija")
    Integer population;

    @OneToMany(mappedBy = "country")
    @JsonManagedReference
    private List<User> userList = new ArrayList<>();
}
