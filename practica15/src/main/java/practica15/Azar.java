package practica15;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Clase para generar numeros al azar
 */
public class Azar {
    /**
     * Metodo que genera cincuenta enteros al azar, entre el 0 y 1000, que sean multiplos de k. Los regresa en forma de String.
     * @param k todos los numeros generados van a ser multiplos de k
     * @return List<String> 50 numeros al azar en forma de String, entre 0 y 1000, que sean multiplos de k  
     */
    public static List<String> genera50 (int k) {
        int n = (1000 / k) + 1;

        return new Random()
            .ints(0, n)
            .limit(50)
            .map(m -> m*k)
            .boxed() // Convertir de IntStream a un stream de Integers 
            .map(m -> Integer.toString(m))
            .collect(Collectors.toList()); // Convertir a lista
    }
}
