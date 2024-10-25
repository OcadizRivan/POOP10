/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poop10;

/**
 * Clase que simula una cuenta bancaria simple, permitiendo realizar operaciones
 * como depósito, retiro y consulta de saldo. 
 * 
 * @author Nadia
 */
public class Cuenta {
    private double saldo;
    private int retirosRealizados; // Contador de retiros

    /**
     * Constructor vacío que inicializa la cuenta sin saldo.
     */
    public Cuenta() {
        retirosRealizados = 0; // Inicia con 0 retiros
    }

    /**
     * Constructor que inicializa la cuenta con un saldo inicial.
     * 
     * @param saldo el saldo inicial de la cuenta.
     */
    public Cuenta(double saldo) {
        this.saldo = saldo;
        retirosRealizados = 0; // Inicia con 0 retiros
    }

    /**
     * Método que permite depositar un monto a la cuenta.
     * Si el monto es mayor a $20,000, se lanza una excepción `DepositoExcedidoException`.
     * 
     * @param monto el monto a depositar en la cuenta.
     * @throws DepositoExcedidoException si el monto a depositar es mayor a $20,000.
     */
    public void depositar(double monto) throws DepositoExcedidoException {
        if (monto > 20000) {
            throw new DepositoExcedidoException("No se pueden depositar más de $20,000.");
        }
        saldo += monto;
    }

    /**
     * Método que permite retirar un monto de la cuenta.
     * Se lanza una excepción `SaldoInsuficienteException` si el saldo es insuficiente,
     * o `MaximoRetirosExcedidoException` si ya se han realizado 3 retiros.
     * 
     * @param monto el monto a retirar de la cuenta.
     * @throws SaldoInsuficienteException si el monto a retirar es mayor que el saldo disponible.
     * @throws MaximoRetirosExcedidoException si se intentan realizar más de 3 retiros.
     */
    public void retirar(double monto) throws SaldoInsuficienteException, MaximoRetirosExcedidoException {
        if (retirosRealizados >= 3) {
            throw new MaximoRetirosExcedidoException("Solo se pueden realizar un máximo de 3 retiros.");
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retiro.");
        }
        saldo -= monto;
        retirosRealizados++; // Incrementa el número de retiros
    }

    /**
     * Método que consulta y devuelve el saldo actual de la cuenta.
     * 
     * @return el saldo actual de la cuenta.
     */
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "saldo=" + saldo + ", retirosRealizados=" + retirosRealizados + '}';
    }
}