package svg;

import java.io.Writer;
import java.io.OutputStream;
import java.io.IOException;
import geometria.Punto;
import geometria.Linea;
import geometria.Triangulo;
// import geometria.Circulo;

/**
 * Clase para crear imágenes básicas en formato SVG.
 */
public class SVG {

    private static final String INDENTACION = "  ";

    private StringBuilder contenido;
    private double longitud, altura;
    private int nivel;

    /**
     * Crea una imagen SVG con el elemento &lt;svg width="L" height="A" 
     *   xmlns="http://www.w3.org/2000/svg"&gt;, donde L y A son las dimensiones dadas.
     * @param longitud la longitud
     * @param altura la altura
     */
    public SVG(double longitud, double altura) {
        this.longitud = longitud;
        this.altura = altura;
        contenido = new StringBuilder();
        concatenar(String.format(
            "<svg width=\"%.2f\" height=\"%.2f\" xmlns=\"http://www.w3.org/2000/svg\">", 
            longitud, altura));
        nivel = 1;
    }

    /**
     * Agrega el elemento &lt;line x1="a" y1="b" x2="c" y2="d" 
     *   style="stroke: black; stroke-width: 1; fill: none" /&gt; a esta imagen, donde (a, b) y 
     * (c, d) son los dos puntos que conforman la línea dada.
     * @param linea contiene los dos puntos entre los cuales se trazará una línea
     */
    public void agregarLinea(Linea linea) {
        // Implementar
	Punto p1 = linea.getP1(),
	    p2 = linea.getP2();
	double x1 = p1.getX(), y1 = altura - p1.getY(),
	    x2 = p2.getX(), y2 = altura - p2.getY();
	concatenar(
		   "<line x1=\"" + x1 +"\" y1=\""+ y1 +
		   "\" x2=\""+x2+"\" y2=\""+y2 +
		   "\" style=\"stroke: black; stroke-width: 1; fill: none\" />");
    }

    /**
     * Agrega tres elementos de tipo &lt;line&gt; a esta imagen, tales que representan un triángulo.
     * @param triangulo contiene los tres puntos entre los cuales se trazarán tres líneas
     */
    public void agregarTriangulo(Triangulo triangulo) {
        // Implementar
	agregarLinea(new Linea(triangulo.getA(), triangulo.getB()));
	agregarLinea(new Linea(triangulo.getA(), triangulo.getC()));
	agregarLinea(new Linea(triangulo.getB(), triangulo.getC()));
    }

    /**
     * Agrega el elemento &lt;circle cx="h" cy="k" r="ra" 
     *   style="stroke: black; stroke-width: 1; fill: none" /&gt; a esta imagen, donde (h, k) es el
     * centro del círculo dado y ra es el radio.
     * @param circulo indica el centro del círculo y su radio
     */
    /*public void agregarCirculo(Circulo circulo) {
        // OPCIONAL
	}*/

    /**
     * Cierra este SVG (&lt;/svg&gt;) y escribe la cadena acumulada en el <code>Writer</code> dado.
     * @param escritor la salida
     * @throws IOException si hay un error escribiendo la salida
     */
    public void escribir(Writer escritor) throws IOException {
        nivel = 0;
        concatenar("</svg>");
        escritor.write(contenido.toString());
    }

    /**
     * Cierra este SVG (&lt;/svg&gt;) y escribe la cadena acumulada en el <code>OutputStream</code> dado.
     * @param salida la salida
     * @throws IOException si hay un error escribiendo la salida
     */
    public void escribir(OutputStream salida) throws IOException {
        nivel = 0;
        concatenar("</svg>");
        salida.write(contenido.toString().getBytes());
    }

    /**
     * Agrega la cadena dada con la indentación especificada por la variable nivel, seguida de
     * un salto de línea.
     * @param info la cadena de texto a agregar
     */
    private void concatenar(String info) {
        contenido.append(INDENTACION.repeat(nivel) + info);
        contenido.append(System.lineSeparator());
    }

}
