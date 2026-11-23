package _DT.Oficina.Entities;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String mark;
    private String color;
    private String year;
    private String type;
    private double kmr;

    public Vehicle(int id, String model, String mark, String color, String year, String type, double kmr){
        this.id = id;
        this.model = model;
        this.mark = mark;
        this.color = color;
        this.year = year;
        this.type = type;
        this.kmr = kmr;
    }
    public Vehicle(String model, String mark, String color, String year, String type, double kmr){
        this.model = model;
        this.mark = mark;
        this.color = color;
        this.year = year;
        this.type = type;
        this.kmr = kmr;
    }

    public Vehicle(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getKmr() {
        return kmr;
    }

    public void setKmr(double kmr) {
        this.kmr = kmr;
    }
}