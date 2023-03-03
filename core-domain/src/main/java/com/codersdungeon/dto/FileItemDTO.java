package com.codersdungeon.dto;

public class FileItemDTO {

    public String nome;
    public int dimensione;

    public String directory;

    public FileItemDTO(String nome) {
        this.nome = nome;
    }

    public FileItemDTO(String nome, String directory) {
        this.nome = nome;
    }

    public FileItemDTO() {
    }

    @Override
    public String toString() {
        return "FileItemDTO{" +
                "nome='" + nome + '\'' +
                ", dimensione=" + dimensione +
                '}';
    }
}
