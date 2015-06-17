/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glowne;

import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author Aga
 */
public class Cards {
    public OneCard[][] tabCard=new OneCard[4][4];
    String[] tabImageFile=new String[8];
    String backImageFile="card.jpg";

    public Cards() {
        arrangeCards();
        randomImage();
    }
    private void arrangeCards(){
        int dx=20;
        int x=10; 
        int y=10;       
        for (int i = 0; i < 4; i++) {
            y = 10;
            for (int j = 0; j < 4; j++) {
                tabCard[i][j] = new OneCard();
                tabCard[i][j].setPointCard(x,y);
                y += dx + 150;
                System.out.println(tabCard[i][j].getPointCard());
            }
            x += dx + 150;           
        }
        
        System.out.println("\t\t\t2222"+tabCard[0][0].getPointCard());
    }
    private void setTabImageFile(){
        
        tabImageFile[0]="karty/fish.jpg";   
        tabImageFile[1]="karty/cat.jpg";   
        tabImageFile[2]="karty/boath.jpg";
        tabImageFile[3]="karty/elephant.jpg";
        tabImageFile[4]="karty/car.jpg";
        tabImageFile[5]="karty/sun.jpg";
        tabImageFile[6]="karty/sweat.jpg";
        tabImageFile[7]="karty/train.jpg";     
    }
    private void randomImage(){
        setTabImageFile();
        Integer sizeList=15;
        LinkedList <Integer>liczby=new LinkedList<Integer>();
        for (int i=0; i<=sizeList; i++) {    //initialList
                        liczby.add(new Integer(i));
                        liczby.add(new Integer(i));
                        
        }
        while(sizeList>0){    //initialList
//                Integer k = (int) (Math.random() * sizeList);
//                k = liczby.get(k);
//                liczby.remove(k);
//                sizeList--;
                Integer k;
                for(int i=0; i<4; i++){
                    for(int j=0; j<4; j++){
                        k = (int) (Math.random() * sizeList);
                        k = liczby.get(k);
                        liczby.remove(k);
                        sizeList--;
                        tabCard[i][j].setImageCardFile(tabImageFile[k]);
                        tabCard[i][j].setIdCard(k);
                        //System.out.print(" "+tabCard[i][j].getIdCard()); 
                    }
                }
        }//while
        for(int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" " + tabCard[j][i].getIdCard());
            }
            System.out.println("");
        } 
        System.out.println("\n\t\t[2][2]| "+tabCard[2][2].getIdCard()+" |");
    }

    
}
