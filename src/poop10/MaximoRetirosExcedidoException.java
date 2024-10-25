/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop10;

/**
 * Excepción personalizada que se lanza cuando se intentan realizar más de 3 retiros.
 * 
 * @author Ivan Ocadiz
 */
public class MaximoRetirosExcedidoException extends Exception {
    public MaximoRetirosExcedidoException() {
    }

    public MaximoRetirosExcedidoException(String message) {
        super(message);
    }
}
