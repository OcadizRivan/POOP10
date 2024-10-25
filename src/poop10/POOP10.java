package poop10;

/**
 * 
 * El programa demuestra el manejo de excepciones en Java, tanto excepciones de tipo 
 * `ArrayIndexOutOfBoundsException` como `ArithmeticException`. 
 * Además de implementar un mecanismo de propagación de excepciones.
 * 
 * - Demostración de excepciones aritméticas y de desbordamiento de arreglo.
 * - Implementación de un método para realizar divisiones y otro para la suma, el cual aún no está soportado.
 * - Simulación de una cuenta bancaria con operaciones de depósito y retiro, gestionando una excepción personalizada `SaldoInsuficienteException`.
 * 
 * @author Ivan Ocadiz
 */
public class POOP10 {

    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * Se realizan diversas operaciones aritméticas y manejo de excepciones como ejemplos de flujo del programa.
     * 
     * @param args los argumentos de línea de comandos (no utilizados en esta práctica).
     */
    public static void main(String[] args) {
        // Salida de bienvenida
        System.out.println("Hola mundo");

        // Ejemplo de una división entera
        int a = 5;
        int c = a / 5; 
        System.out.println(c);

        // Inicialización de un arreglo de tamaño 5
        int[] b = new int[5];
        
        // Llenado del arreglo con valores multiplicados por 10
        for (int i = 0; i < 5; i++) {
            b[i] = i * 10;
        }

        // Manejo de excepción ArrayIndexOutOfBoundsException
        try {
            // Error provocado al intentar acceder a un índice fuera del rango del arreglo
            for (int i = 0; i <= 5; i++) { 
                System.out.println(b[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Excepción de desbordamiento de memoria.");
        }

        // Este mensaje se imprimirá si la excepción anterior es capturada
        System.out.println("Hola, he sobrevivido.");

        // Manejo de excepción ArithmeticException (división por cero)
        try {
            float d = 4 / 0;
            System.out.println(d);
        } catch (ArithmeticException e) {
            System.out.println("Excepción aritmética segundo caso.");
        }

        // Uso del método personalizado para realizar divisiones
        float n = miMetodoDivision(100, 2);
        System.out.println(n);

        // Manejo de excepción aritmética propagada desde un método
        try {
            float m = miMetodoDivision(100, 0);
            System.out.println(m);
        } catch (ArithmeticException e) {
            System.out.println("Excepción aritmética permeada.");
            e.printStackTrace(); // Imprime la traza del error
        }

        // Continuación del programa tras la excepción
        System.out.println("A pesar de todo seguimos en el programa.");
        float x = miMetodoDivision(20, 5);
        System.out.println(x);

        // Ejemplo de uso de un método no soportado, lanzando una excepción personalizada
        try {
            int w = suma(3, 7);
        } catch (UnsupportedOperationException e) {
            System.out.println("Excepción de operación no soportada.");
            System.out.println("Atributo mensaje: " + e.getMessage());
        }

        /*
        // Simulación de operaciones bancarias con manejo de excepción personalizada
        try {
            Cuenta cuenta = new Cuenta(100);
            System.out.println("Saldo inicial: " + cuenta.consultarSaldo());
            cuenta.depositar(100);
            System.out.println("Saldo después de depósito: " + cuenta.consultarSaldo());
           cuenta.retirar(300); // Provocará la excepción personalizada
            System.out.println("Saldo después de retiro: " + cuenta.consultarSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Excepción presentada: Saldo insuficiente.");
            System.out.println(e.getMessage());
        }
        */
            Cuenta cuenta = new Cuenta(10000);

        try {
            cuenta.depositar(25000); // Intento de depositar más de $20,000
        } catch (DepositoExcedidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            cuenta.retirar(2000); // Primer retiro
            cuenta.retirar(2000); // Segundo retiro
            cuenta.retirar(2000); // Tercer retiro
            cuenta.retirar(2000); // Cuarto retiro, debería lanzar la excepción
        } catch (MaximoRetirosExcedidoException e) {
            System.out.println(e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Saldo final: " + cuenta.consultarSaldo());

    }

    /**
     * Método que realiza una división entre dos enteros.
     * 
     * @param f el dividendo
     * @param f0 el divisor
     * @return el cociente de la división
     * @throws ArithmeticException si el divisor es cero
     */
    private static int miMetodoDivision(int f, int f0) throws ArithmeticException {
        return f / f0;
    }

    /**
     * Método que simula una operación de suma que aún no está soportada.
     * Lanza una excepción `UnsupportedOperationException` cuando es invocado.
     * 
     * @param i primer número a sumar
     * @param i0 segundo número a sumar
     * @throws UnsupportedOperationException siempre que se invoca
     */
    private static int suma(int i, int i0) {
        throw new UnsupportedOperationException("Operación no soportada aún.");
    }
    
}