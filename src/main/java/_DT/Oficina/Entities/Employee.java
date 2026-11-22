package _DT.Oficina.Entities;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double wage;
    private String name;
    private String cpf;
    private String numberPhone;
    private String email;

    public Employee(int id, int wage, String name, String cpf, String numberPhone, String email){
        this.id = id;
        this.wage = wage;
        this.name = name;
        this.cpf = cpf;
        this.numberPhone = numberPhone;
        this.email = email;
    }
    public Employee(int wage, String name, String cpf, String numberPhone, String email){
        this.wage = wage;
        this.name = name;
        this.cpf = cpf;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public Employee(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
