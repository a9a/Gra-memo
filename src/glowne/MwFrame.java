/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glowne;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import static javax.swing.JSplitPane.BOTTOM;

/**
 *
 * @author Aga
 */
public class MwFrame extends JFrame {
    //private int size=680;
    public PanelStart buttons;
    public Background  bG;
    private Boards plansza;
    private String user;

    public MwFrame(){
        super("MemoO");
        //this.setSize(new Dimension(size,size));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
 
        bG=new Background();
        this.add(bG);
        buttons=new PanelStart(this);
        

        //bG.add(jTextNameUser);
        bG.add(buttons);
        
        pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    public void removeM(){
        bG.remove(buttons);
    }
    public void addNewGame() throws IOException{
        plansza=new Boards();
        plansza.setNameUser(buttons.getNameUser());
        
        bG.add(plansza);
        pack();
    }
}
