package practica14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.LinkedList;

/**
 * Clase para leer archivos CSV
 */
public class LectorCSV {
    /**
     * Metodo que lee un archivo CSV y devuelve en una lista su contenido sin comas
     * @param ruta Un String que es la ruta del archivo que se va a abrir
     * @return Lista de arreglos de cadenas, el contenido del archivo sin comas
     */
    public static List<String[]> leer(String ruta) throws IOException {
        System.out.println("Ruta Actual:" + Paths.get(".").toAbsolutePath());
        List<String> lineas = Files.readAllLines(Paths.get(ruta));

        LinkedList<String[]> lineasSeparadas = new LinkedList<>();
        for(String linea: lineas) {
            String[] valores = linea.split(",");

            for(int i=0; i<valores.length; i++) {
                valores[i] = valores[i].trim();
            }
            if (!valores[0].equals("x") && !valores[0].isBlank() && !valores[1].isBlank()) {
                lineasSeparadas.add(valores);
            }
        }
        
        return lineasSeparadas;
    }
}
