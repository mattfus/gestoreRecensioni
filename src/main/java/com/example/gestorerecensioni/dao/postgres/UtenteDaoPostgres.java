package com.example.gestorerecensioni.dao.postgres;

import com.example.gestorerecensioni.dao.UtenteDAO;
import com.example.gestorerecensioni.persistenza.model.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDaoPostgres implements UtenteDAO {
    Connection conn;
    public UtenteDaoPostgres(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Utente> findAll() {
        List<Utente> listaUtenti = new ArrayList<Utente>();
        String query = "select * from utente";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                Utente utente = new Utente();
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setDataNascita(rs.getDate("datanascita"));

                listaUtenti.add(utente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUtenti;
    }

    @Override
    public Utente findByPrimaryKey(String username) {
        Utente utente = null;
        String query = "select * from utente where username =?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                utente = new Utente();
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setDataNascita(rs.getDate("datanascita"));
                utente.setRuolo(rs.getString("ruolo"));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return utente;
    }

    @Override
    public void updateOrSave(Utente utente) {
        String query = "update utente set password=?, nome=?, cognome=?, datanascita=?, ruolo=? where username=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,utente.getPassword());
            st.setString(2,utente.getNome());
            st.setString(3,utente.getCognome());
            st.setDate(4, new java.sql.Date(utente.getDataNascita().getTime()));
            st.setString(5,utente.getRuolo());
            st.setString(6, utente.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Utente utente) {
        String query = "delete from utente where username=?";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, utente.getUsername());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
