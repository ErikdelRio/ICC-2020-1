public class Ecuacion {

	public static void main(String[] args) {
		double a = 3, b = 17, c = 10, d = -5.7, e = 3.5;
		int i = 1, n = 100000000;
		double suma = 0;
		while (i <= n) {
			/* Escribe en la línea 9 */
			
			/* ************************ */
		    double
			term1 = a+((i*(b-a))/n),
			term2 = (49*c*(d+e)) / (34*((3*d)+c));
		    suma += -550*(term1*term1) + 2992*term1 - term2;
		    i++;
		}

		System.out.println("Resultado = " + (((b - a) / n) * suma));
	}

}
