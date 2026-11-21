package _DT.Oficina.entities;

import jakarta.persistence.*;

@Entity
public class Service {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private Double value;
    private String description;

    public Service(int id, String name, String type, Double value, String description){
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.description = description;
    }
    public Service(String name, String type, Double value, String description){
        this.name = name;
        this.type = type;
        this.value = value;
        this.description = description;
    }

    public Service(){
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
