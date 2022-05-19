package com.Utis;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "oplata")
public class Oplata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "itogo")
    private Double itogo;

    @Column(name = "dataoplata")
    private LocalDate dataoplata;

    @Column(name = "forma", length = 15)
    private String forma;

    @OneToMany(mappedBy = "idOplata")
    private Set<Zaselenie> zaselenies = new LinkedHashSet<>();

    public Set<Zaselenie> getZaselenies() {
        return zaselenies;
    }

    public void setZaselenies(Set<Zaselenie> zaselenies) {
        this.zaselenies = zaselenies;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public LocalDate getDataoplata() {
        return dataoplata;
    }

    public void setDataoplata(LocalDate dataoplata) {
        this.dataoplata = dataoplata;
    }

    public Double getItogo() {
        return itogo;
    }

    public void setItogo(Double itogo) {
        this.itogo = itogo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}