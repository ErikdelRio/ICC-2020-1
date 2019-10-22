package ajedrez.piezas;

import java.util.List;
import ajedrez.piezas.Posicion;

/**
 * Clase que describe una pieza de ajedrez
 */
public abstract class Pieza {
    private Color color;
    private Posicion posicion;

    /**
     * Constructor que crea una pieza a partir de su color y posicion
     * @param color Color del que es la pieza
     * @param posicion Posicion inicial de la pieza
     */
    public Pieza(Color color, Posicion posicion) {
        this.color = color;
        this.posicion = posicion;
    }

    /**
     * Obtiene las jugadas posibles de la pieza a partir de su posicion
     */
    public abstract List<Posicion> obtenerJugadasLegales();

    /**
     * Obtiene el color de la pieza
     * @return Color El color de la pieza
     */
    public Color obtenerColor() {
        return color;
    }

    /**
     * Obtiene la posicion de la pieza
     * @return Posicion La posicion de la pieza
     */
    public Posicion obtenerPosicion() {
        return posicion;
    }

    /**
     * Asigna una nueva posicion a partir de otra
     * @param Posicion nueva de la pieza 
     */
    public void asignarPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pieza otra = (Pieza) obj;
        return color == otra.color && posicion.equals(otra.obtenerPosicion());
    }
}
