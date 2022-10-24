package com.example.gestorerecensioni.dao;

import com.example.gestorerecensioni.persistenza.model.Utente;

import java.util.List;

public interface UtenteDAO {
    List<Utente> findAll();

    Utente findByPrimaryKey(String username);

    void updateOrSave(Utente utente);

    void delete(Utente utente);
}
