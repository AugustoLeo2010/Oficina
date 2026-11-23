package _DT.Oficina.Entities;

import jakarta.persistence.*;

@Entity
public class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String date;
    private String hours;
    private String numberPhone;


    public Appointment(int id, String name, String numberPhone, String date, String hours){
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
        this.date = date;
        this.hours = hours;
    }
    public Appointment(String name, String numberPhone, String date, String hours){
        this.name = name;
        this.numberPhone = numberPhone;
        this.date = date;
        this.hours = hours;
    }

    public Appointment(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}

