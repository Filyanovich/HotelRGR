package com.Utis;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bronirovanie")
public class Bronirovanie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "datazayavki")
    private LocalDate datazayavki;

    @Column(name = "countpeople")
    private Integer countpeople;

    @Column(name = "datazaezda")
    private LocalDate datazaezda;

    @Column(name = "dataviezda")
    private LocalDate dataviezda;

    @Column(name = "cost")
    private Double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client idClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    private Room idRoom;

    public Room getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Room idRoom) {
        this.idRoom = idRoom;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDate getDataviezda() {
        return dataviezda;
    }

    public void setDataviezda(LocalDate dataviezda) {
        this.dataviezda = dataviezda;
    }

    public LocalDate getDatazaezda() {
        return datazaezda;
    }

    public void setDatazaezda(LocalDate datazaezda) {
        this.datazaezda = datazaezda;
    }

    public Integer getCountpeople() {
        return countpeople;
    }

    public void setCountpeople(Integer countpeople) {
        this.countpeople = countpeople;
    }

    public LocalDate getDatazayavki() {
        return datazayavki;
    }

    public void setDatazayavki(LocalDate datazayavki) {
        this.datazayavki = datazayavki;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}