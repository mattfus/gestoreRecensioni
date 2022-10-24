package com.example.gestorerecensioni.dao.postgres;

import com.example.gestorerecensioni.dao.PiattoDAO;
import com.example.gestorerecensioni.persistenza.model.Piatto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PiattoDaoPostgres implements PiattoDAO {
    Connection conn;

    public PiattoDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Piatto> findAll() {
        List<Piatto> listaPiatti = new ArrayList<Piatto>();
        String query = "select * from piatto";
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Piatto piatto = new Piatto();
                piatto.setId(rs.getLong("id"));
                piatto.setNome(rs.getString("nome"));
                listaPiatti.add(piatto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPiatti;
    }

    @Override
    public Piatto findByprimaryKey(Long id) {
        Piatto p = null;
        String query = "select * from piatto where id=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                p = new Piatto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return p;
    }

    @Override
    public void saveOrUpdate(Piatto piatto) {
        String query = "update piatto set nome=? where id=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, piatto.getNome());
            st.setLong(2, piatto.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Piatto piatto) {
        String query = "delete from piatto where id=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setLong(1, piatto.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
