package geometria;

/**
 * Representa un polígono de tres lados. Está definido por tres puntos en el plano cartesiano.
 * @author del Rio Pulido Erik Federico
 * @version 1.0
 */
public class Triangulo{
    private Punto a;
    private Punto b;
    private Punto c;

    /**
     * Triángulo con todos sus lados de la misma longitud.
     */
    public static final int EQUILATERO = 0;

    /**
     * Triángulo con exactamente dos lados de la misma longitud.
     */
    public static final int ISOSCELES = 1;

    /**
     * Triángulo con todos sus lados de longitud distinta.
     */
    public static final int ESCALENO = 2;

    /**
     * Crea un triángulo con los tres puntos dados.
     * @param a - primer punto
     * @param b - segundo punto
     * @param c - tercer punto
     */
    public Triangulo(Punto a, Punto b, Punto c){
	this.a = new Punto(a.getX(), a.getY());
	this.b = new Punto(b.getX(), b.getY());
	this.c = new Punto(c.getX(), c.getY());
    }

    /**
     * Crea un triángulo equilátero de lado 1 con vértices en (0,0), (1,0) y (0,5, sin(π / 3)).
     */
    public Triangulo(){
	this.a = new Punto(0,0);
	this.b = new Punto(1,0);
	this.c = new Punto(0.5, Math.sin(Math.PI/3));
    }

    /**
     * Determina si los vértices de este triángulo están alineados.
     * @return true si los vértices están alineados
     */
    public boolean tieneVerticesAlineados(){
	return a.estanAlineados(b, c);
    }

    /**
     * Ve si el triángulo es equilatero
     * @return true si es triangulo es equilatero
     */
    public boolean esEquilatero(){
	double AB = a.distancia(b),
	    AC = a.distancia(c),
	    BC = b.distancia(c);
	return AB==AC && AB==BC;
    }

    /**
     * Ve si el triángulo es escaleno
     * @return true si el triangulo es escaleno
     */
    public boolean esEscaleno(){
	double AB = a.distancia(b),
	    AC = a.distancia(c),
	    BC = b.distancia(c);

	return AB!=AC && AB!=BC && AC!=BC;
    }

    /**
     * Regresa el tipo de este triángulo según la longitud de sus lados; puede ser equilátero, isóceles o escaleno.
     * @return entero, el tipo de este triángulo
     */
    public int tipo(){
	if(esEquilatero()){
	    return EQUILATERO;
	}
	if(esEscaleno()){
	    return ESCALENO; 
	}
	return ISOSCELES;
    }
}
