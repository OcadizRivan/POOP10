/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop10;

/**
 * Excepción personalizada que se lanza cuando se intenta depositar una cantidad mayor a $20,000.
 * 
 * @author Ivan Ocadiz
 */
public class DepositoExcedidoException extends Exception {
    public DepositoExcedidoException() {
    }

    public DepositoExcedidoException(String message) {
        super(message);
    }
}
