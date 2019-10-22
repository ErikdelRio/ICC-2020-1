package ajedrez.piezas;

/**
 * Clase que describe la posicion en filas y columnas
 */
public class Posicion {
    private int fila;
    private int columna;

    /**
     * Constructor que crea una posicion a partir de una fila y columna
     * @param fila La fila de la posicion 
     * @param columna La columna de la posicion
     */
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Metodo que obtiene la fila de la posicion
     * @return int La fila de la posicion
     */
    public int obtenerFila() {
        return fila;
    }

    /**
     * Metodo que obtiene la columna de la posicion
     * @return int La columna de la posicion
     */
    public int obtenerColumna() {
        return columna;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Posicion otra = (Posicion) obj;
        return fila == otra.fila && columna == otra.columna;
    }
}
