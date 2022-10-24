package com.example.gestorerecensioni.dao.postgres;

import com.example.gestorerecensioni.dao.RistoranteDAO;
import com.example.gestorerecensioni.persistenza.model.Ristorante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RistoranteDaoPostgres implements RistoranteDAO {
    Connection conn;

    public RistoranteDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Ristorante> findAll() {
        List<Ristorante> listaRistoranti = new ArrayList<Ristorante>();
        String query = "select * from ristorante";
        try {
            Statement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Ristorante r = new Ristorante();
                r.setId(rs.getLong("id"));
                r.setName(rs.getString("nome"));
                r.setCapUbicazione(rs.getLong("capubicazione"));
                listaRistoranti.add(r);
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e.getMessage(), e);
        }

        return listaRistoranti;
    }

    @Override
    public Ristorante findByPrimaryKey(Long id) {
        Ristorante r = null;
        String query = "select * from ristorante where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                r = new Ristorante();
                r.setId(rs.getLong("id"));
                r.setName(rs.getString("nome"));
                r.setCapUbicazione(rs.getLong("capubicazione"));
            }
        }catch (SQLException e){
            throw new RuntimeException("SQL error: " + e.getMessage(), e);
        }
        return r;
    }

    @Override
    public void saveOrUpdate(Ristorante ristorante) {
        String query = "update ristorante set nome =?,capubicazione =? where id =?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, ristorante.getName());
            st.setLong(2, ristorante.getCapUbicazione());
            st.setLong(3, ristorante.getId());
            st.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(Ristorante ristorante) {
        String query = "delete from ristorante where id =?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, ristorante.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("SQL error: " + e.getMessage(), e);
        }
    }
}
