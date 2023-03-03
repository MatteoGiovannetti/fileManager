package com.codersdungeon.temp;

public class Utente {

    private String nome;

    public String saluta(){
        return "ciao sono "+nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Utente(String nome) {
        this.nome = nome;
    }
}
