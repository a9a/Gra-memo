/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glowne;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Aga
 */
public class Background extends JPanel{
    private final String imageFile="background.jpg";
    //private final Image imgBg;
    private BufferedImage bi;
    private final int maxW=680;
    private final int maxH=680;
    public Background() {
        setPreferredSize(new Dimension(maxW,maxH));
        this.setOpaque(true);
        //imgBg=Toolkit.getDefaultToolkit().getImage(imageFile);
        repaint();
    }
    @Override
    public void paintComponent(Graphics g){
         try {
             bi = ImageIO.read(new File(imageFile));
         } catch (IOException ex) {
             Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
         }
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, this);
        

    }
}
