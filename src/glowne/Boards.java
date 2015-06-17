/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glowne;
import baza.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.Collection;
import java.util.Collections;
import java.util.Timer;

import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aga
 */
public class Boards extends JPanel implements MouseListener{
    
    private final String imageFile="card.jpg";

    private BufferedImage bi;
    private final int maxW=680;
    private final int maxH=680;
    private final int imgSize=150; //150x150
    private final Cards karty=new Cards();
    Point pointPrevClicked;
    Point pointClicked;
    Point p=new Point(0,0);
    private int nrMove=0;
    private Timer zegar;
    private long czas;
    private String nameUser;
    
    public Boards() throws IOException {
        this.zegar = new Timer();
        czas=System.currentTimeMillis();
        setPreferredSize(new Dimension(maxW,maxH));
        bi=ImageIO.read(new File(imageFile));
        pointPrevClicked=new Point(-1, -1);
        pointClicked=new Point(-1, -1);
        addMouseListener(this);
        
        this.setOpaque(false);
        //this.setNameUser(nameUser);
        repaint();
        

    }
    @Override
    public void paintComponent(Graphics g){
//         try {
//             bi = ImageIO.read(new File(imageFile));
//         } catch (IOException ex) {
//             Logger.getLogger(Boards.class.getName()).log(Level.SEVERE, null, ex);
//         }
        //super.paintComponent(g);
        drawCards(g);
    }
    void drawCards(Graphics g){
        int x,y;
        int dx=20;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                p = karty.tabCard[i][j].getPointCard();
                x = p.x;
                y = p.y;
                try {
                    
                    if (karty.tabCard[i][j].getStatusCard() == true) {
                        bi = ImageIO.read(new File(karty.tabCard[i][j].getImageCardFile()));
   
                    } else {
                        bi = ImageIO.read(new File(karty.backImageFile));
                        
                    }
                    g.drawImage(bi, x, y, this);

                } catch (IOException ex) {
                    Logger.getLogger(Boards.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

//        --------------------        try {
//                    
//                    if (karty.tabCard[i][j].getStatusCard() == true) {
//                        bi = ImageIO.read(new File(karty.tabCard[i][j].getImageCardFile()));
//                    }else{
//                        bi = ImageIO.read(new File(karty.backImageFile));
//                    }
//                   
//                } catch (IOException ex) {
//                    Logger.getLogger(Boards.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                p=karty.tabCard[i][j].getPointCard();
//                x=p.x;
//                y=p.y;
//                g.drawImage(bi, x,y, this);
//            }
//---------------------------------------------------------------------------------                
//                try {
//                    bi = ImageIO.read(new File(karty.tabCard[i][j].imageCardFile));
//                } catch (IOException ex) {
//                    Logger.getLogger(Boards.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                if (!karty.tabCard[i][j].statusCard) {
//                    g.drawImage(bi, karty.tabCard[i][j].x, karty.tabCard[i][j].y, this);
//                }
            
        }


        
    }
    public void mouseClicked(MouseEvent e) {
        int m_x = e.getX();
        int m_y = e.getY();
        int i=0, j=0;
        boolean clickedFL=check(m_x, m_y);
        System.out.print("CliCk ! ! ");
        //System.out.print(pointPrevClicked.x+pointPrevClicked.y);
        boolean pair=false; 
        if(clickedFL==true){
            
            //System.out.println("Prev[" + pointPrevClicked + "\n\tklicked kard: [" + pointClicked);
            move();
            //System.out.println(nrMove);
            //System.out.println("Prev[" + pointPrevClicked + "\n\tklicked kard: [" + pointClicked);
//            System.out.println("\tTRueClick M:"+nrMove+"M");
            if(nrMove==2){
                //checkPair(pointPrevClicked, pointClicked);
                removeMouseListener(this);
                pair=checkPair(pointPrevClicked, pointClicked);
                if(pair==true){
                    System.out.println("ZNALEZIONO PARE!!!!!!!!");
                    //JOptionPane.showMessageDialog(null, "Znaleziono Pare");
                    OneCard one=karty.tabCard[pointPrevClicked.x][pointPrevClicked.y];
                    OneCard two=karty.tabCard[pointClicked.x][pointClicked.y];
                    zegar.schedule(new RemindTask(one, two), 1000);
                    //addMouseListener(this);
                    
                }
                nrMove=0;
                
            }
                
                pointPrevClicked.x = pointClicked.x;
                pointPrevClicked.y = pointClicked.y;
//            try {
//                Thread.sleep(4000);
//                
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Boards.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            karty.tabCard[2][2].setStatusCard(false);
//            repaint();
        }
        repaint();
        if(checkFinish()==true){
            long stop=System.currentTimeMillis();
            Integer t=new Integer((int)(stop-czas)/1000);
            
            String txt="Twoj czas to:\n"+"\t"+t.toString()+"sek";
            JOptionPane.showMessageDialog(null, txt);
            zapiszWynik(t);
            
        }
        
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
                       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    private boolean check(int mx, int my){
        int x=10;
        int dx=20;
        int i=0;
        int j=0;
        boolean fl=false;

        for (i = 0; i < 4; i++) {
            int y = 10;
            for (j = 0; j < 4; j++) {
                if (mx>x && mx<x+150 && my>y && my<y+150 
                        && karty.tabCard[i][j].getActiveCard()==true 
                        && karty.tabCard[i][j].getStatusCard()==false){                         
                    fl=true;
                    pointClicked.x=i;
                    pointClicked.y=j;
                    if (pointPrevClicked.x == pointClicked.x && pointPrevClicked.y == pointClicked.y && nrMove==1) {
                        fl = false;
                        System.out.println("\t\t\tTo samo");
                    }
                    break;}
                y += dx + 150;
            }
            x += dx + 150;
        }


    return fl;    
    }

    private boolean checkPair(Point prev, Point point){
        OneCard one=karty.tabCard[prev.x][prev.y];
        OneCard two=karty.tabCard[point.x][point.y];
        System.out.print("idOne"+one.getIdCard());
        System.out.print("idTwo"+two.getIdCard());
        boolean flag=false;
        if(one.getIdCard()==two.getIdCard()){
            flag=true;        
            one.setActiveCard(false);
            two.setActiveCard(false);
            repaint();
        }else{ 
            
            zegar.schedule(new RemindTask(one, two), 100); //zakrycie kart 
            System.out.println("\t\t\tadasdasdasdas");

            
        }

        return flag;
    }
private void move(){
    nrMove++;
    System.out.println("\tTRueClick M:"+nrMove+"M");
    karty.tabCard[pointClicked.x][pointClicked.y].setStatusCard(true);
    repaint();
}

    private void zakryj(OneCard prevCard, OneCard card) {
        
        OneCard one=prevCard;
        OneCard two=card;
        if(one.getActiveCard()==true &&two.getActiveCard()==true){
            one.setStatusCard(false);
            two.setStatusCard(false);    
            
            repaint();
            

            
        }
          addMouseListener(this);
    }

    private void zapiszWynik(Integer t) {
        String czasT;
        czasT=t.toString();
        Ranking rank=new Ranking();
        rank.insertGracz(nameUser);
        rank.insertWynik(t, nameUser);
        rank.closeConnection();
        
        //rank.insertWynik(rank.getKey(), 2000);
    }

        

    class RemindTask extends TimerTask {
        OneCard one;
        OneCard two;
        public RemindTask(OneCard prevCard, OneCard card){
            one=prevCard;
            two=card;
            
        }
        @Override
        public void run() {
            System.out.format("Time's up!%n");
            zakryj(one, two);
            
            //zegar.cancel(); //Terminate the timer thread
            //zegar.cancel();
        }

    }
         boolean checkFinish() {
        boolean fl = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (karty.tabCard[i][j].getActiveCard() == true) {
                    fl = false;
                    break;
                }
            }

        }
        return fl;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
        //System.out.println("name-B"+nameUser);
    }


        
}
