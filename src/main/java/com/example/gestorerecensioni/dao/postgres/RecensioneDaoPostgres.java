package com.example.gestorerecensioni.dao.postgres;

import com.example.gestorerecensioni.dao.RecensioneDAO;
import com.example.gestorerecensioni.persistenza.model.Recensione;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecensioneDaoPostgres implements RecensioneDAO {
    Connection conn;

    public RecensioneDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Recensione> findAll() {
        List<Recensione> listaRecensioni = new ArrayList<Recensione>();
        String query = "select * from recensione";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Recensione r = new Recensione();
                r.setId(rs.getLong("id"));
                r.setTitolo(rs.getString("titolo"));
                r.setTesto(rs.getString("testo"));
                r.setNumeroMiPiace(rs.getLong("numeromipiace"));
                r.setNumeroNonMiPiace(rs.getLong("numerononmipiace"));
                r.setRistorante(rs.getLong("ristorante"));
                r.setScrittoDa(rs.getString("scrittoda"));

                listaRecensioni.add(r);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaRecensioni;
    }

    @Override
    public Recensione findByPrimaryKey(Long id) {
        Recensione r = null;
        String query = "select * from recensione where id =?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                r = new Recensione();
                r.setId(rs.getLong("id"));
                r.setTitolo(rs.getString("titolo"));
                r.setTesto(rs.getString("testo"));
                r.setNumeroMiPiace(rs.getLong("numeromipiace"));
                r.setNumeroNonMiPiace(rs.getLong("numerononmipiace"));
                r.setRistorante(rs.getLong("ristorante"));
                r.setScrittoDa(rs.getString("scrittoda"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return r;
    }

    @Override
    public void updateOrSave(Recensione recensione) {
        String query = "update recensione set titolo =?, testo =?, numeroMiPiace =?, numeroNonMiPiace =?, ristorante =?, scrittoDa =? where id =?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, recensione.getTitolo());
            st.setString(2, recensione.getTesto());
            st.setLong(3, recensione.getNumeroMiPiace());
            st.setLong(4, recensione.getNumeroNonMiPiace());
            st.setLong(5, recensione.getRistorante());
            st.setString(6, recensione.getScrittoDa());
            st.setLong(7, recensione.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Recensione recensione) {
        String query = "delete from recensione where id =?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, recensione.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
