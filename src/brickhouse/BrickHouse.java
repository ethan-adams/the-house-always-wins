/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickhouse;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author tonic
 */
public class BrickHouse {

    /**
     * @param args the command line arguments
     */
    
    
    public static int result = 0;
    
    public static void main(String[] args) {
        boolean sentinel = true;
        
        do {
            try {
                String input = JOptionPane.showInputDialog
                ("What is the square footage of your house? [please enter an integer]");
                result = Integer.parseInt(input);
                if (result < 0 || result > 10000) {
                    throw new InvalidSizeException(result);
                }
                else
                    sentinel = false;
            } catch (NumberFormatException e) {
                System.err.printf("Exception: %s\n", e);
                System.err.println("Invalid input, please enter an integer!");
            } catch (InvalidSizeException f) {
                System.err.println(f.toString());
            } 
        } while(sentinel);
        
        HouseFrame frame = new HouseFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500,600);
        frame.setLocation(400,400);
        frame.setTitle("Build-a-House");
    }
    
    public static int getResult() {
        return result;
    }
}
