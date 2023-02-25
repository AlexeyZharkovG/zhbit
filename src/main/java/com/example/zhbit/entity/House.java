package com.example.zhbit.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id")
    private Street street;

    @OneToMany(mappedBy = "house")
    private List<Apartment> apartments;

    public House() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
