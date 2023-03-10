package com.codersdungeon.dto;

import java.util.Date;
import java.util.Objects;

public class FileItemDTO {

    public String nome;
    public Long dimensione;
    public String type;

    public FileItemDTO(){

    }
    public FileItemDTO(String nome, Long dimensione, String type) {
        this.nome = nome;
        this.dimensione = dimensione;
        this.type = type;
    }

    @Override
    public String toString() {
        return "FileItemDTO{" +
                "nome='" + nome + '\'' +
                ", dimensione=" + dimensione +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileItemDTO itemDTO = (FileItemDTO) o;
        return Objects.equals(nome, itemDTO.nome) && Objects.equals(dimensione, itemDTO.dimensione) && Objects.equals(type, itemDTO.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dimensione, type);
    }
}
