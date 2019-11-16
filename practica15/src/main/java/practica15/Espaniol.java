package practica15;

import java.util.stream.Stream;
import java.util.List;

/**
 * Clase para convertir enteros en su representacion en espaniol
 */
public class Espaniol {
    /**
     * Metodo que convierte un Stream de Integers en un stream de Strings con su nombre en espaniol. Ignora los numeros negativos y los mayores o iguales a 10
     * @param nums Un Stream<Integer> con los numeros que se convertiran en su representacion en espaniol
     * @return Stream<String> Los digitos en su representacion en espaniol
     */
    public static Stream<String> nombreDigitos(Stream<Integer> nums) {
        String[] numsCadenas = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        return nums.filter(n -> n >=0 && n <= 9)
            .map(n -> numsCadenas[n]);
    }
}
