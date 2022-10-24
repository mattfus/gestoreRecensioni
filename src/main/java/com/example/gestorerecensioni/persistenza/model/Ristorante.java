package com.example.gestorerecensioni.persistenza.model;

public class Ristorante {
    private Long id;
    private String name;
    private Long capUbicazione;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getCapUbicazione() {
        return capUbicazione;
    }
    public void setCapUbicazione(Long capUbicazione) {
        this.capUbicazione = capUbicazione;
    }
}
