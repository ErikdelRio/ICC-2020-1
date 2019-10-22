package ajedrez.piezas;

/**
 * Clase que prueba el comportamiento de una ficha de ajedrez Peon
 */
public class PruebaPeon {
    public static void main(String[] args) {
        Peon[] peones = new Peon[12];

        // Esquinas
        peones[0] = new Peon(Color.BLANCO, new Posicion(0,0));
        peones[1] = new Peon(Color.BLANCO, new Posicion(0,7));
        peones[2] = new Peon(Color.NEGRO, new Posicion(7,0));
        peones[3] = new Peon(Color.NEGRO, new Posicion(7,7));

        // Normal
        peones[4] = new Peon(Color.BLANCO, new Posicion(3,3));
        peones[5] = new Peon(Color.NEGRO, new Posicion(3,3));

        // Lados
        peones[6] = new Peon(Color.BLANCO, new Posicion(3,7));
        peones[7] = new Peon(Color.BLANCO, new Posicion(1,0));
        peones[8] = new Peon(Color.NEGRO, new Posicion(1,7));
        peones[9] = new Peon(Color.NEGRO, new Posicion(4,0));
        
        // Peon no se ha movido 
        peones[10] = new Peon(Color.BLANCO, new Posicion(6,4));
        peones[11] = new Peon(Color.NEGRO, new Posicion(1,4));

        int n = 0;
        for (Peon miPeon: peones) {
            System.out.println("Peon "+(n++)+" "+miPeon.obtenerColor());
            System.out.println("x: " + miPeon.obtenerPosicion().obtenerColumna());
            System.out.println("y: " + miPeon.obtenerPosicion().obtenerFila());
            System.out.println("Jugadas legales:");
            for (Posicion jugada: miPeon.obtenerJugadasLegales()) {
                System.out.println("Columna: " + jugada.obtenerColumna() +
                                   "\nFila: " + jugada.obtenerFila());
            }
            System.out.println("\n");
        }
    }
}
