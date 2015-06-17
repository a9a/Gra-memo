/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

/**
 *
 * @author Aga
 */
public class Wynik {
    private int idWyniku;
    private int idGracza;
    private int wynik;
    private String nazwaGracza;

    public Wynik(int idWyniku, int idGracza, int wynik, String nazwaGracza) {
        this.idWyniku = idWyniku;
        this.idGracza = idGracza;
        this.wynik = wynik;
        this.nazwaGracza=nazwaGracza;
    }

    public void setIdWyniku(int idWyniku) {
        this.idWyniku = idWyniku;
    }

    public void setIdGracza(int idGracza) {
        this.idGracza = idGracza;
    }

    public void setWynik(int wynik) {
        this.wynik = wynik;
    }

    public int getIdWyniku() {
        return idWyniku;
    }

    public int getIdGracza() {
        return idGracza;
    }

    public int getWynik() {
        return wynik;
    }

    public String getNazwaGracza() {
        return nazwaGracza;
    }

    public void setNazwaGracza(String nazwaGracza) {
        this.nazwaGracza = nazwaGracza;
    }

    @Override
    public String toString() {
        return "Wynik{" + "idWyniku=" + idWyniku + ", idGracza=" + idGracza + ", wynik=" + wynik + ", nazwaGracza=" + nazwaGracza + '}';
    }


   
    
}
