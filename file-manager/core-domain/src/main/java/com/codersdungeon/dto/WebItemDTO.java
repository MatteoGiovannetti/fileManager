package com.codersdungeon.dto;

import com.codersdungeon.temp.Utente;

import java.util.Date;

public class WebItemDTO {

    public String nome;

    public int dimensione;

    public String directory;

    private Date creationDate;

    private String owner;

    @Override
    public String toString() {
        return "WebItemDTO{" +
                "nome='" + nome + '\'' +
                ", dimensione=" + dimensione +
                ", directory='" + directory + '\'' +
                ", creationDate=" + creationDate +
                ", owner='" + owner + '\'' +
                '}';
    }
}
