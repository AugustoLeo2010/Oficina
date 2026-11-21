package _DT.Oficina.entities;

import jakarta.persistence.*;

@Entity
public class Veiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String modelo;
    private String marca;
    private String cor;
    private String ano;
    private String tipo;
    private double kmr;

    public Veiculo(int id, String modelo, String marca, String cor, String ano, String tipo, double kmr){
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.ano = ano;
        this.tipo = tipo;
        this.kmr = kmr;
    }
    public Veiculo(String modelo, String marca, String cor, String ano, String tipo, double krm){
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.tipo = tipo;
        this.kmr = kmr;
    }

    public Veiculo(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getKmr() {
        return kmr;
    }

    public void setKmr(double kmr) {
        this.kmr = kmr;
    }
}