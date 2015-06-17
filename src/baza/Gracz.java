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
public class Gracz {
    private int idGracz;
    private String nameGracz;

    public Gracz(int idGracz, String nameGracz) {
        this.idGracz = idGracz;
        this.nameGracz = nameGracz;
    }

    public int getId() {
        return idGracz;
    }

    public String getNazwaGracza() {
        return nameGracz;
    }

    public void setId(int id) {
        this.idGracz = id;
    }

    public void setNazwaGracza(String nazwaGracza) {
        this.nameGracz = nazwaGracza;
    }

    @Override
    public String toString() {
        return "Gracz{" + "idGracz=" + idGracz + ", nameGracz=" + nameGracz + '}';
    }
    
    
}
