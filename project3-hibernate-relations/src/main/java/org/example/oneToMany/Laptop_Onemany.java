package org.example.oneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.example.embedable.Alien;

@Entity
public class Laptop_Onemany {

    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;
    @ManyToOne
    private Alien_Onemany alien_onemany;

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Alien_Onemany getAlien_onemany() {
        return alien_onemany;
    }

    public void setAlien_onemany(Alien_Onemany alien_onemany) {
        this.alien_onemany = alien_onemany;
    }

    @Override
    public String toString() {
        return "Laptop_One{" +
                "lid='" + lid + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
