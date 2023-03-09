package com.codersdungeon.temp;

public class FileItem {

    private String nome;

    private int dimensione;

    private String directory = "file-manager/core-domain/";

    private String creationDate;

    public FileItem(String nome, int dimensione, String directory, String creationDate) {
        this.nome = nome;
        this.dimensione = dimensione;
        this.directory = directory;
        this.creationDate = creationDate;
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

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
