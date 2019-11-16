package practica15;

import java.util.Arrays;
import java.util.List;

/**
 * Clase para probar practica15
 */
public class Prueba {
    public static void main(String[] args) {
        System.out.println("----------Infinito----------");
        Infinito.f("ab").limit(10)
            .forEach(System.out::println);

        System.out.println("\n----------Ordenar----------");
        List<String> list = Arrays.asList("b", "aa", "", "a", "bab", "z", "");
        Ordenar.ordena(list)
            .forEach(System.out::println);

        System.out.println("\n----------Espaniol----------");
        List<Integer> nums = Arrays.asList(-1000,-158,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,20,23,109,10293);
        Espaniol.nombreDigitos(nums.stream())
            .forEach(System.out::println);

        System.out.println("\n----------Azar----------");

        System.out.println("\n---------- 1000");
        Azar.genera50(500)
            .forEach(System.out::println);

        System.out.println("\n---------- 2");
        Azar.genera50(2)
            .forEach(System.out::println);
    }
}

