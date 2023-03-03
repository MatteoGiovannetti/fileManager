package com.codersdungeon.temp;

public class FileItem {

    private String nome;

    private int dimensione;

    public FileItem(String nome, int dimensione) {
        this.nome = nome;
        this.dimensione = dimensione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDimensione() {
        return dimensione;
    }

    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }
}
