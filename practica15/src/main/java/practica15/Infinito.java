package practica15;

import java.util.stream.Stream;
import java.util.function.Supplier;

/**
 * Clase que para generar una sucesion infinita de de cadenas
 */
public class Infinito {
    /**
     * Metodo que genera una cadena infinita, primero es vacia, luego s, luego ss y asi sucesivamente.
     * @param s String que se va a repetir
     * @return Stream<String> donde cada elemento es una nueva iteracion de la sucesion
     */
    public static Stream<String> f(String s) {
        return Stream.generate(new Supplier <String>(){
            int i = 0;
            public String get() {
                return s.repeat(i++);
            }
        });
    }
}

