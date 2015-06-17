/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aga
 */
public class Ranking {
    
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:gra.db";
 
    private Connection conn;
    private Statement stat;
    private int key;


    public Ranking() {
        try {
            Class.forName(Ranking.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
    }
        public boolean insertGracz(String nazwa) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Gracz values (NULL, ?);");
            String n;
            prepStmt.setString(1, nazwa);
            //System.out.println(prepStmt.getGeneratedKeys().getInt("id_gracza"));
            //prepStmt.getGeneratedKeys();
            prepStmt.execute();
            //key=(prepStmt.getGeneratedKeys()).getInt("id_gracza");
            //
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu gracza");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean insertWynik(int wynik, String name) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into Wynik values (NULL, ?, ?);");
            //prepStmt.setInt(1, idGracza);
            prepStmt.setInt(1, wynik);
            prepStmt.setString(2, name);
            prepStmt.execute();
            
        } catch (SQLException e) {
            System.err.println("Blad przy insert wynik");
            return false;
        }
        return true;
    }
    public List<Wynik> selectWyniki() {
        List<Wynik> wyniki = new LinkedList<Wynik>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Wynik");
            int id;
            int wynik;
            int idG=0;
            String n;
            //ResultSet result2=stat.executeQuery("SELECT nazwa_gracza FROM Gracz WHERE id_gracza=2");
            //ResultSet result2;
            while(result.next()) {
                id = result.getInt("id_wyniku");
                //idG = result.getInt("id_gracza");
                wynik = result.getInt("wynik");
                n=result.getString("nazwa_gracza");
                wyniki.add(new Wynik(id, idG, wynik, n));
                
            }
            //setNameUsers(wyniki);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return wyniki;
    }
        public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }

    private void setNameUsers(List<Wynik> wyniki) {
        String polecenie="SELECT nazwa_gracza FROM Gracz WHERE id_gracza=";
        int idG;
        String name;
        for(Wynik w: wyniki){
            idG=w.getIdGracza();
            polecenie=polecenie+Integer.toString(idG);
            try {
                ResultSet result = stat.executeQuery(polecenie);
                

            //ResultSet result2=stat.executeQuery("SELECT nazwa_gracza FROM Gracz WHERE id_gracza=2");
                //ResultSet result2;
                while (result.next()) {
                    name = result.getString("nazwa_gracza");
                    w.setNazwaGracza(name);

                }
             
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }   
    }
    public int getKey(){
        return key;
    }
}
