/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop10;

/**
 * Clase que define una excepción llamada SaldoInsuficienteException.
 * Esta excepción es lanzada cuando se intenta retirar un monto superior al saldo disponible
 * en una cuenta bancaria.
 * 
 * @author maiap
 */
public class SaldoInsuficienteException extends Exception {

    /**
     * Constructor vacio.
     */
    public SaldoInsuficienteException() {
    }
    
    /**
     * Constructor lleno.
     * 
     * @param message el mensaje personalizado que describe el error.
     */
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}