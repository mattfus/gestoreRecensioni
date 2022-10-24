package com.example.gestorerecensioni.dao;

import com.example.gestorerecensioni.persistenza.model.Ristorante;

import java.util.List;

public interface RistoranteDAO {
    List<Ristorante> findAll();

    Ristorante findByPrimaryKey(Long id);

    void saveOrUpdate(Ristorante ristorante);

    void delete(Ristorante ristorante);
}
