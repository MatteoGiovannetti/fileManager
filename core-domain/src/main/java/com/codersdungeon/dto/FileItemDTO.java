package com.codersdungeon.dto;

import java.util.Date;

public class FileItemDTO {

    public String nome;
    public int dimensione;

    public String directory;

    public String creationDate;

    public FileItemDTO(String nome, int dimensione, String directory, String creationDate) {
        this.nome = nome;
        this.dimensione = dimensione;
        this.directory = directory;
        this.creationDate = creationDate;
    }

    public FileItemDTO(){

    }

    @Override
    public String toString() {
        return "FileItemDTO{" +
                "nome='" + nome + '\'' +
                ", dimensione=" + dimensione +
                '}';
    }
}
