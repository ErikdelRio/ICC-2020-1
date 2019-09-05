import java.util.Date;
import java.util.Scanner;

/** Programa para 
 * @author del Rio Pulido Erik Federico
 * @date 
 */
public class Tarea2 {
    public static void main(String[] pps) {
                      // Declaracion de variables
	Scanner in = new Scanner(System.in);
	int dia, mes, anio;
	long edad;
	Date hoy = new Date(), cumple;
	    // Solicitar la fecha de nacimiento
	System.out.println("Dame tu fecha de nacimiento");
        System.out.print("Dia: ");
	dia = in.nextInt();

	System.out.print("Mes: ");
	mes = in.nextInt();
	
	System.out.print("Año: ");
	anio = in.nextInt();
	
	    // Adaptar la fecha normal al formato de Date
	cumple = new Date(anio-1900,mes-1,dia);

	if (cumple.getTime() > hoy.getTime()){
	    System.out.println("No se permiten viajeros en el tiempo!");
	} else {
	    //Mostrar las fechas
	    System.out.println("\n\nCumple: "+cumple.toString());
	    System.out.println("Hoy: "+hoy.toString());

	    //Calcular la edad de una persona.

	    //Años
	    edad = hoy.getYear() - cumple.getYear();

	    if(hoy.getMonth()<cumple.getMonth() && hoy.getDate()<cumple.getDate()){
		edad -= 1;
	    }
	    System.out.println("Hoy: "+hoy.getDate());
	    System.out.println("Cumple: "+cumple.getDate());

	    // Meses
	    int meses = cumple.getMonth()-hoy.getMonth();
	    System.out.println("Cumple meses="+cumple.getMonth()+" Hoy meses="+hoy.getMonth());
	    if(meses <= 0){
		meses *= -1; // Convertir a positivo
	    } else {
		meses = 12 - meses;
	    }

	    // dias
	    int dias = cumple.getDate() - hoy.getDate();
	    if(dias <= 0){
		dias *= -1;
	    } else {
		int cont = 0, mesActual = cumple.getMonth();
		cumple.setMonth(cumple.getMonth()-1);
		while(cumple.getMonth() != mesActual){
		    cumple.setDate(cumple.getDate()+1);
		    cont += 1;
		}
		dias = cont + hoy.getDate();
	    }
	    // Mostrar resultados.
	    System.out.println("Tu edad es: " + edad + " años, "+ meses+" meses, "+ dias+" días");
	}
	
            // Mostrar las fechas
	    //Calcular la edad de una persona. 

	    // Mostrar resultados.
    }
}
