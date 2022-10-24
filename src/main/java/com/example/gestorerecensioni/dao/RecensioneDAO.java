package com.example.gestorerecensioni.dao;

import com.example.gestorerecensioni.persistenza.model.Recensione;

import java.util.List;

public interface RecensioneDAO {
    List<Recensione> findAll();

    Recensione findByPrimaryKey(Long id);

    void updateOrSave(Recensione recensione);

    void delete(Recensione recensione);
}
