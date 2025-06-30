/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads.calculadora;

/**
 *
 * @author 20241070130005
 */
public class CustomException extends Exception {
    
    public CustomException() {
    
    }
    
    public CustomException(String message) {
        super(message);
    }
    
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
