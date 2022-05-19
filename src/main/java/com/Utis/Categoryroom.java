package com.Utis;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "categoryroom")
public class Categoryroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "category", length = 20)
    private String category;

    @Column(name = "countroom")
    private Integer countroom;

    @Column(name = "countmest")
    private Integer countmest;

    @Column(name = "cost")
    private Double cost;

    @OneToMany(mappedBy = "idCategoryroom")
    private Set<Room> rooms = new LinkedHashSet<>();

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getCountmest() {
        return countmest;
    }

    public void setCountmest(Integer countmest) {
        this.countmest = countmest;
    }

    public Integer getCountroom() {
        return countroom;
    }

    public void setCountroom(Integer countroom) {
        this.countroom = countroom;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}