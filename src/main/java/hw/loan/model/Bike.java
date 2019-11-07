package hw.loan.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "valueBrand", nullable = false)
    private String brand;

    @Column(name = "valueColor", nullable = false)
    private String color;

    @Column(name = "valueCondition", nullable = false)
    private String condition;

    @Column(name = "valueRentable", nullable = false)
    private int rentable;

    @Column(name = "valueUnderRepair", nullable = false)
    private int underRepair;

    public Bike(String brand, String color, String condition, int rentable, int underRepair){
        this.brand = brand;
        this.color = color;
        this.condition = condition;
        this.rentable = rentable;
        this.underRepair = underRepair;
    }

    protected Bike(){}

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getCondition() {
        return condition;
    }

    public int getRentable() {
        return rentable;
    }
}