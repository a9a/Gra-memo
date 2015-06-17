/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glowne;

import baza.Ranking;
import baza.Wynik;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Caret;

/**
 *
 * @author Aga
 */
public class PanelStart extends JPanel{
    private JButton newGameButton;
    private JButton rankButton;
    private final String playLocationImage="/Image/play.jpg";
    private final String rankingLocationImage= "/Image/score.jpg";
    private MwFrame okno;
    private javax.swing.JTextField jTextNameUser;
    private String nameUser;
    
    

    public PanelStart(MwFrame ramka) {
        //super();
        okno=ramka;//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        initComponents();
        
    }
    
    private void initComponents(){
        newGameButton=new JButton();
        rankButton=new JButton();
        jTextNameUser=new javax.swing.JTextField();
        jTextNameUser.setText("Gracz");
        //jTextNameUser.setSize(10, 50);
        this.setImagetoButtons();
        this.add(Box.createRigidArea(new java.awt.Dimension(60, 150)));
        this.add(jTextNameUser);
        this.add(Box.createRigidArea(new java.awt.Dimension(0, 50)));
        this.add(newGameButton);
        this.add(Box.createRigidArea(new java.awt.Dimension(20, 60)));
        this.add(rankButton);
        this.clicked();//
     
        this.setVisible(true);
        
    }
    private void setImagetoButtons(){
        try {
            Image newGameIcon = ImageIO.read(getClass().getResource(playLocationImage));
            Image rankIcon = ImageIO.read(getClass().getResource(rankingLocationImage));
            newGameButton.setIcon(new ImageIcon(newGameIcon));
            rankButton.setIcon(new ImageIcon(rankIcon));
        } catch (java.io.IOException ex) {}
        
        newGameButton.setBorderPainted(false);
        newGameButton.setContentAreaFilled(false);     
        rankButton.setBorderPainted(false);
        rankButton.setContentAreaFilled(false);
        jTextNameUser.setOpaque(false);
        jTextNameUser.setSize(10,20);
        //jTextNameUser.setBorder(null);
        jTextNameUser.setBackground(new Color(63, 157, 209));
        jTextNameUser.setForeground(new Color(39,121,165));
        jTextNameUser.setCaretColor(new Color(39,121,165));
        jTextNameUser.setFont(new java.awt.Font("Snap ITC", 0, 36));
        jTextNameUser.setHorizontalAlignment(JTextField.CENTER);
        jTextNameUser.setCaretPosition(5);
        //jTextNameUser.setMargin(null);
        
        
        newGameButton.setAlignmentX(PanelStart.CENTER_ALIGNMENT);
        rankButton.setAlignmentX(PanelStart.CENTER_ALIGNMENT);
        jTextNameUser.setAlignmentX(PanelStart.CENTER_ALIGNMENT);
    }
    
    private void clicked(){
        newGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    newGameButtonMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(PanelStart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    rankButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    rankButtonMouseClicked(evt);
                } catch (IOException ex) {
                    Logger.getLogger(PanelStart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private void newGameButtonMouseClicked(java.awt.event.MouseEvent evt) throws IOException {                                      
        // TODO add your handling code here:
        nameUser=jTextNameUser.getText();
        okno.removeM();
        okno.addNewGame();
        okno.setVisible(true);   

    }
    private void rankButtonMouseClicked(java.awt.event.MouseEvent evt) throws IOException {                                      
        // TODO add your handling code here:
        Ranking rank=new Ranking();
        //JOptionPane.showMessageDialog(null, "nlanla"); 
        List <Wynik> listaRank=rank.selectWyniki();
        String name="user";
        int min=listaRank.get(0).getWynik();
        name=listaRank.get(0).getNazwaGracza();
        for(Wynik w: listaRank)
            {
                if(min>w.getWynik()){
                    min=w.getWynik();
                    name=w.getNazwaGracza();
                }
            }
            JOptionPane.showMessageDialog(null, "\nNazwa gracza: "+name+"\nWynik="+Integer.toString(min)+" sek\n"); 
            rank.closeConnection();

    }

    public String getNameUser() {
        return nameUser;
    }


    
}
