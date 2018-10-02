/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickhouse;

/**
 *
 * @author tonic
 */
public class InvalidSizeException extends Exception {
    String message;

    public InvalidSizeException (int a) {
        message = a + 
                " is an invalid size: Size should be between 0 and 10,000 square feet.";
    }

    public String toString() {
        return message;
    }
}

