package alglin;

/**
 * Representa una matriz de mxn con entradas en los reales.
 *
 */
public class Matriz {
    
    private double[][] datos;
    private int m, n;
    
    /**
     * Crea una matriz de mxn donde todas las entradas son cero.
     *
     * @param m el número de filas
     * @param n el número de columnas
     */
    public Matriz(int m, int n) {
        if(m > 0 && n > 0) {
            this.m = m;
            this.n = n;
            datos = new double[m][n];
        }
    }
    
    /**
     * Regresa la entrada en la i-ésima fila y j-ésima columna de esta matriz.
     *
     * @param i la fila de la entrada deseada
     * @param j la columna de la entrada deseada
     * @return la entrada i,j
     */
    public double obtenerEntrada(int i, int j) {
        return datos[i][j];
    }
    
    /**
     * Inserta el dato dado en la i-ésima fila y j-ésima columna de esta matriz.
     *
     * @param dato el número que se insertará en esta matriz
     * @param i    la fila donde se insertará <code>dato</code>
     * @param j    la columna donde se insertará <code>dato</code>
     */
    public void asignarEntrada(double dato, int i, int j) {
        if(i < m && i >= 0  &&  j < n && j >= 0) {
            datos[i][j] = dato;
        }
    }
    
    /**
     * Suma esta matriz con otra. Regresa <code>null</code> si las matrices no tienen las mismas
     * dimensiones.
     *
     * @param otra la otra matriz con la cual se sumará esta
     * @return una matriz nueva que resulta de sumar esta con <code>otra</code>
     */
    public Matriz sumar(Matriz otra) {
        if(m != otra.m || n!= otra.n) {
            return null;
        }
        Matriz sumaM = new Matriz(m, n);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                double suma = obtenerEntrada(i, j) + otra.obtenerEntrada(i, j);
                sumaM.asignarEntrada(suma, i, j);
            }
        }
        return sumaM;
    }
    
    /**
     * Multiplica esta matriz por un escalar.
     *
     * @param c el escalar real
     * @return una matriz nueva que resulta de multiplicar esta por <code>c</code>
     */
    public Matriz escalar(double c) {
        Matriz escalarM = new Matriz(m ,n);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                double mult = c * obtenerEntrada(i, j);
                escalarM.asignarEntrada(mult, i, j);
            }
        }
        return escalarM;
    }
    
    /**
     * Elimina una fila de esta matriz.
     *
     * @param k la fila a eliminar
     * @return una matriz nueva que resulta de eliminar la k-ésima fila de esta matriz
     */
    public Matriz eliminarFila(int k) {
        Matriz sinFila = new Matriz(m - 1, n);
        int iPrima = 0;
        for(int i = 0; i < m; i++) {
            if(i != k) {
                for(int j = 0; j < n; j++) {
                    sinFila.asignarEntrada(obtenerEntrada(i, j), iPrima, j);
                }
                iPrima++;
            }
        }
        return sinFila;
    }
    
    /**
     * Elimina una columna de esta matriz.
     *
     * @param k la columna a eliminar
     * @return una matriz nueva que resulta de eliminar la k-ésima columna de esta matriz
     */
    public Matriz eliminarColumna(int k) {
        Matriz sinColumna = new Matriz(m, n-1);
        for(int i = 0; i < m; i++) {
            int jPrima = 0;
            for(int j = 0; j < n; j++) {
                if(j != k) {
                    sinColumna.asignarEntrada(obtenerEntrada(i, j), i, jPrima);
                    jPrima++;
                }
            }
        }
        return sinColumna;
    }
    
    /**
     * Calcula el determinante de esta matriz.
     *
     * @return el determinante de esta matriz
     */
    public double determinante() {
        if(n == 1) {
            return obtenerEntrada(0, 0);
        }
        double det = 0;
        for(int i = 0; i < m; i++) {
            double sumaOResta = Math.pow(-1, 2 + i);
            Matriz casoMenor = eliminarFila(0).eliminarColumna(i);
            det += sumaOResta * obtenerEntrada(0, i) * casoMenor.determinante();
        }
        return det;
    }
    
    /**
     * Regresa los datos de esta matriz de tal forma que las columnas están separadas por un espacio
     * y las filas están separadas por un salto de línea. Por ejemplo: <br>
     * "2.0 3.0 0.0 1.0 <br>
     * &nbsp;4.0 0.0 9.0 8.0 <br>
     * &nbsp;5.0 7.0 2.0 4.0"
     *
     * @return la representación en <code>String</code> de esta matriz
     */
    @Override
    public String toString() {
        String cadena = "";
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                cadena += obtenerEntrada(i, j);
                if(j < n - 1) {
                    cadena += " ";
                }
            }
            if(i < m-1) {
                cadena += "\n";
            }
        }
        return cadena;
    }
    
    /**
     * Regresa <code>true</code> si y sólo si <code>obj</code> es una instancia de 
     * {@link alglin.Matriz} y las matrices son iguales entrada por entrada.
     *
     * @param obj el objeto a comparar
     * @return <code>true</code> si <code>this</code> y <code>obj</code> son iguales entrada por
     *         entrada
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Matriz otra = (Matriz) obj;
        if (m != otra.m || n != otra.n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (datos[i][j] != otra.datos[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
