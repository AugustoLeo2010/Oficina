package _DT.Oficina.entities;

import jakarta.persistence.*;

@Entity
public class Service {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String tipo;
    private Double valor;
    private String descricao;

    public Service(int id, String nome, String tipo, Double valor, String descricao){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }
    public Service(String nome, String tipo, Double valor, String descricao){
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Service(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
