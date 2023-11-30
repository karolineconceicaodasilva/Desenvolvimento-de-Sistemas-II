package com.example.acessobanco.database.entidades;

public class Aluno {

    private int id;
    private String nome;
    private double peso;
    private String cpf;



    public Aluno(String nome, double peso , String cpf) {
        this.nome = nome;
        this.peso = peso;
        this.cpf = cpf;
    }

    public Aluno(int id, String nome, double peso, String cpf) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.cpf = cpf;
    }

    public Aluno() {}

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}
}
