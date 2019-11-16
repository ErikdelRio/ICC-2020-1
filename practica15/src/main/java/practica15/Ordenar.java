package practica15;

import java.util.stream.Stream;
import java.util.List;

/**
 * Clase para ordenar Listas
 */
public class Ordenar {
    /**
     * Metodo que ordena de mayor a menor segun la longitud de una cadena
     * @param list La lista con las cadenas a ordenar
     * @return Stream<String> con las cadenas ordenadas segun su tamanio de mayor a menor
     */
    public static Stream<String> ordena(List<String> list) {
        return list.stream()
            .sorted((s1, s2) -> {
                return s2.length() - s1.length();
            });
    }
}
