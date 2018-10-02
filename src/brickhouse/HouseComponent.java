/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickhouse;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author tonic
 */
public class HouseComponent extends JComponent {
    
    private Color bColor = Color.GREEN;
    private Color hColor = Color.RED;
    private int s1 = 1, s2 = 1;
    
    public HouseComponent() {
        
    }
    
    public void paintComponent(Graphics g) {
        //background
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 1000, 1000);
        if (s2 == 1) {
            g.setColor(Color.GREEN);
        }
        else if (s2 == 2) {
            g.setColor(Color.YELLOW);
        }
        g.fillRect(0, 350, 1000, 200);
        
        //house
        if (s1 == 1) {
            g.setColor(Color.RED); //this color changes
        }
        else if (s1 == 2) {
            g.setColor(Color.GREEN);
        }
        else if (s1 == 3) {
            g.setColor(Color.BLUE);
        }
        g.fillRect(150,175,200,200);
        
        //roof
        int[] x = {125, 250, 375};
        int[] y = {175, 75, 175};
        g.setColor(Color.DARK_GRAY);
        g.fillPolygon(x, y, 3);
        
        //windows
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(170, 215, 40, 40);
        g.setColor(Color.BLACK);
        g.fillRect(189, 215, 2, 40);
        g.fillRect(170, 234, 40, 2);
        
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(290, 215, 40, 40);
        g.setColor(Color.BLACK);
        g.fillRect(309, 215, 2, 40);
        g.fillRect(290, 234, 40, 2);
        
        //door
        g.setColor(Color.DARK_GRAY);
        g.fillRect(230, 295, 40, 80);
        g.setColor(Color.YELLOW);
        g.fillOval(260, 335, 6, 6);
        repaint();
    }
    
    public void setHouseColor(int i) {
        s1 = i;
    }
    
    public void setBackColor(int i) {
        s2 = i;
    }
}
