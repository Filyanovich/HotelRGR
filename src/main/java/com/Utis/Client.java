package com.Utis;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "passport", length = 15)
    private String passport;

    @Column(name = "databirthday")
    private LocalDate databirthday;

    @Column(name = "email", length = 50)
    private String email;

    @OneToMany(mappedBy = "idClient")
    private Set<Zaselenie> zaselenies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idClient")
    private Set<Bronirovanie> bronirovanies = new LinkedHashSet<>();

    public Set<Bronirovanie> getBronirovanies() {
        return bronirovanies;
    }

    public void setBronirovanies(Set<Bronirovanie> bronirovanies) {
        this.bronirovanies = bronirovanies;
    }

    public Set<Zaselenie> getZaselenies() {
        return zaselenies;
    }

    public void setZaselenies(Set<Zaselenie> zaselenies) {
        this.zaselenies = zaselenies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDatabirthday() {
        return databirthday;
    }

    public void setDatabirthday(LocalDate databirthday) {
        this.databirthday = databirthday;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}