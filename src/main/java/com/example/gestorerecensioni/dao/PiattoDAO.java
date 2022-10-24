package com.example.gestorerecensioni.dao;

import com.example.gestorerecensioni.persistenza.model.Piatto;

import java.util.List;

public interface PiattoDAO {
    List<Piatto> findAll();

    Piatto findByprimaryKey(Long id);

    void saveOrUpdate(Piatto piatto);

    void delete(Piatto piatto);
}
