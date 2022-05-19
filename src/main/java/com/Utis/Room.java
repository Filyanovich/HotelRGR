package com.Utis;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status", length = 15)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoryroom")
    private Categoryroom idCategoryroom;

    @OneToMany(mappedBy = "idRoom")
    private Set<Bronirovanie> bronirovanies = new LinkedHashSet<>();

    public Set<Bronirovanie> getBronirovanies() {
        return bronirovanies;
    }

    public void setBronirovanies(Set<Bronirovanie> bronirovanies) {
        this.bronirovanies = bronirovanies;
    }

    public Categoryroom getIdCategoryroom() {
        return idCategoryroom;
    }

    public void setIdCategoryroom(Categoryroom idCategoryroom) {
        this.idCategoryroom = idCategoryroom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}