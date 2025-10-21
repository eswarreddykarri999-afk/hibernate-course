package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
//@Table(name="alien_table")
public class Alien {

    @Id
    private  int aid;

    @Column(name="alien_name")
    private String aname;

   // @Transient // It will not allow to create column in database
    private String tech;

    //@OneToOne // here laptop table has alien_id & vice-versa
    //@OneToMany // it creates 3rd table
    //to avoid that, write as
    @OneToMany(mappedBy = "alien")
    private List<Laptop> laptops;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptops +
                '}';
    }
}