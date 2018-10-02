/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickhouse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author tonic
 */
public class HouseFrame extends JFrame {
    
    private JLabel houseColorLabel, landscape, sqft;
    private JComboBox houseColor = new JComboBox();
    private JRadioButton grass = new JRadioButton("Grass");
    private JRadioButton desert = new JRadioButton("Desert");
    private JPanel controlPanel, g1, g2, g3;
    private HouseComponent house = new HouseComponent();
    private ChoiceListener l1;
    String tempHColor = "Red";
    
    public HouseFrame() {
        
        ChoiceListener l1 = new ChoiceListener();
        JLabel houseColorLabel = new JLabel("House Color: ");
        houseColor.setEditable(false);
        houseColor.addItem("Red");
        houseColor.addItem("Green");
        houseColor.addItem("Blue");
        houseColor.getModel().setSelectedItem("Red");
        houseColor.addActionListener(l1);
        
        JLabel landscape = new JLabel("Landscape: ");
        grass.setSelected(true);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(grass);
        radioGroup.add(desert);
        grass.addActionListener(l1);
        desert.addActionListener(l1);
        
        JLabel sqft = new JLabel("Square Feet: " + BrickHouse.getResult());
        
        JPanel g1 = new JPanel();
        JPanel g2 = new JPanel();
        JPanel g3 = new JPanel();
        
        g1.add(houseColorLabel);
        g1.add(houseColor);
        g1.setPreferredSize(new Dimension(400,30));
        
        g2.add(landscape);
        g2.add(grass);
        g2.add(desert);
        g3.setPreferredSize(new Dimension(400,30));
        
        g3.add(sqft);
        g3.setPreferredSize(new Dimension(400,30));
        
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(3,1));
        controlPanel.add(g1);
        controlPanel.add(g2);
        controlPanel.add(g3);
        controlPanel.setPreferredSize(new Dimension(400,120));
        add(controlPanel, BorderLayout.NORTH);
        
        house.setPreferredSize(new Dimension(400,480));
        add(house, BorderLayout.CENTER);
    }
        
    class ChoiceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            changeHouse();
        }
    }
            
    public void changeHouse() {
        
        String tempHColor = (String) houseColor.getSelectedItem();

        if (tempHColor.equals("Red")) {
            house.setHouseColor(1);
        }
        else if (tempHColor.equals("Green")) {
            house.setHouseColor(2);
        }
        else if (tempHColor.equals("Blue")) {
            house.setHouseColor(3);
        }

        if (grass.isSelected()) {
            house.setBackColor(1);
        }
        else if (desert.isSelected()) {
            house.setBackColor(2);
        }
        house.repaint();
    }
}
