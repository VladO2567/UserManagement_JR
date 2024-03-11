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
@Table(name = "grad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "naziv")
    private String cityName;

    @Column(name = "postanski_kod")
    private String zip_code;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    private List<User> userList = new ArrayList<>();
}
