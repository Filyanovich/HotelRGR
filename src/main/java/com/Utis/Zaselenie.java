package com.Utis;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "zaselenie")
public class Zaselenie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "databroni")
    private LocalDate databroni;

    @Column(name = "room")
    private Integer room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private Client idClient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_oplata")
    private Oplata idOplata;

    public Oplata getIdOplata() {
        return idOplata;
    }

    public void setIdOplata(Oplata idOplata) {
        this.idOplata = idOplata;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public LocalDate getDatabroni() {
        return databroni;
    }

    public void setDatabroni(LocalDate databroni) {
        this.databroni = databroni;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}