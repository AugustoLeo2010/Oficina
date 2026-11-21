package _DT.Oficina.entities;

import jakarta.persistence.*;

@Entity
public class ServiceOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String cpf;
    private String numberPhone;
    private String email;

    public ServiceOrder(int id, String name, String cpf, String numberPhone, String email){
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.numberPhone = numberPhone;
        this.email = email;
    }
    public ServiceOrder(String name, String cpf, String numberPhone, String email){
        this.name = name;
        this.cpf = cpf;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public ServiceOrder(){
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
