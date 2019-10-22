package ajedrez.piezas;

import java.util.List;
import java.util.LinkedList;

/**
 * Clase que describe una pieza de ajedrez "peon"
 */
public class Peon extends Pieza {
    public Peon(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public List<Posicion> obtenerJugadasLegales() {
        LinkedList<Posicion> jugadas = new LinkedList<>();
        int fila = obtenerPosicion().obtenerFila(),
            columna = obtenerPosicion().obtenerColumna();

        int direccion = obtenerColor() == Color.BLANCO? -1 : 1;
        int inicio = (columna == 0)? 0 : - 1, // Esta en la orilla derecha
            fin = (columna == 7)? 0 : 1; // Esta en la orilla izquierda
        
        if (obtenerColor() == Color.BLANCO) {
            if (fila > 0) {
                for(int col = inicio; col <= fin; col++) {
                    jugadas.add(new Posicion(fila + direccion, columna + col));
                }
            }
            if (fila == 6) {
                jugadas.add(new Posicion(fila - 2, columna));
            }
        } else {
            if (fila < 7) {
                for(int col = inicio; col <= fin; col++) {
                    jugadas.add(new Posicion(fila + direccion, columna + col));
                }
            }
            if (fila == 1) {
                jugadas.add(new Posicion(fila + 2, columna));
            }
        }
        
        return jugadas;
    }
}
