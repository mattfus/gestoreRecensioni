package com.example.gestorerecensioni.persistenza.model;

public class Recensione {

    private Long id;
    private String titolo;
    private String testo;
    private Long numeroMiPiace;
    private Long numeroNonMiPiace;
    private Long ristorante;
    private String scrittoDa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo= titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Long getNumeroMiPiace() {
        return numeroMiPiace;
    }

    public void setNumeroMiPiace(Long numeroMiPiace) {
        this.numeroMiPiace = numeroMiPiace;
    }

    public Long getNumeroNonMiPiace() {
        return numeroNonMiPiace;
    }

    public void setNumeroNonMiPiace(Long numeroNonMiPiace) {
        this.numeroNonMiPiace = numeroNonMiPiace;
    }

    public Long getRistorante() {
        return ristorante;
    }

    public void setRistorante(Long ristorante) {
        this.ristorante = ristorante;
    }

    public String getScrittoDa() {
        return scrittoDa;
    }

    public void setScrittoDa(String scrittoDa) {
        this.scrittoDa = scrittoDa;
    }
}
