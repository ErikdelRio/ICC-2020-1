package ajedrez.piezas;

import ajedrez.Tablero;
import java.util.List;
import java.util.LinkedList;

public class Dama extends Pieza {
    public Dama(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public List<Posicion> obtenerJugadasLegales() {
        LinkedList<Posicion> jugadas = new LinkedList<>();
        Tablero tab = Tablero.obtenerInstancia();

        int fila = obtenerPosicion().obtenerFila(),
            columna = obtenerPosicion().obtenerColumna();
        
        // Arriba
        Pieza p = null; //tab.obtenerPieza(fila, i);
        for(int i = fila-1; i>=0 && p==null; i--) {
            p = agregarPos(jugadas, new Posicion(i, columna));
        }

        // Abajo
        p = null; 
        for(int i = fila+1; i<=7 && p==null; i++) {
            p = agregarPos(jugadas, new Posicion(i, columna));
        }

        // Derecha
        p = null; 
        for(int i = columna+1; i<=7 && p==null; i++) {
            p = agregarPos(jugadas, new Posicion(fila, i));
        }

        // Izquierda
        p = null; 
        for(int i = columna-1; i>=0 && p==null; i--) {
            p = agregarPos(jugadas, new Posicion(fila, i));
        }
        
        // Diagonal arriba derecha
        p = null; 
        for(int i = fila-1, j = columna+1; i>=0 && j<=7 && p==null; i--, j++) {
            p = agregarPos(jugadas, new Posicion(i, j));
        }

        // Diagonal abajo derecha
        p = null; 
        for(int i = fila+1, j = columna+1; i<=7 && j<=7 && p==null; i++, j++) {
            p = agregarPos(jugadas, new Posicion(i, j));
        }

        // Diagonal arriba izquierda
        p = null; 
        for(int i = fila-1, j = columna-1; i>=0 && j>=0 && p==null; i--, j--) {
            p = agregarPos(jugadas, new Posicion(i, j));
        }

        // Diagonal abajo izquierda
        p = null; 
        for(int i = fila+1, j = columna-1; i<=7 && j>=0 && p==null; i++, j--) {
            p = agregarPos(jugadas, new Posicion(i, j));
        }

        return jugadas;
        
    }

    private Pieza agregarPos(LinkedList<Posicion> lista, Posicion pos) {
        Tablero tab = Tablero.obtenerInstancia();
        Pieza p = tab.obtenerPieza(pos.obtenerFila(), pos.obtenerColumna());
        if(p == null) {
            lista.add(pos);
        } else {
            if(p.obtenerColor() != obtenerColor()) {
                lista.add(pos);
            }
        }
        return p;
    }
}
