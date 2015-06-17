/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glowne;

import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Aga
 */
public class OneCard {
    private String imageCardFile;
    private boolean statusCard;  //zakryta=false odkryta
    private boolean activeCard;  //para znaleziona=false
    public Point pointCard;
    private int idCard;

    

    public OneCard() {
        this.imageCardFile = "";
        this.statusCard = false;
        this.activeCard = true;
        pointCard=new Point(0,0);
        
        
    }

    public String getImageCardFile() {
        return imageCardFile;
    }

    public void setImageCardFile(String imageCardFile) {
        this.imageCardFile = imageCardFile;
    }

    public boolean getStatusCard() {
        return statusCard;
    }
    public boolean setStatusCard() {
        return statusCard;
    }

    public void setStatusCard(boolean statusCard) {
        this.statusCard = statusCard;
    }
    

    public boolean getActiveCard() {
        return activeCard;
    }
    public boolean setActiveCard() {
        return activeCard;
    }
    public void setActiveCard(boolean activeCard) {
        this.activeCard = activeCard;
    }

    public Point getPointCard() {
        return pointCard;
    }
    public void setPointCard(Point pointCard) {
        this.pointCard=pointCard;
    }
    public void setPointCard(int x, int y) {
        this.pointCard.x=x;
        this.pointCard.y=y;
    }


    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }
    
    
}
