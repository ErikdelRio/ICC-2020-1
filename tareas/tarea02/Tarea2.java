import java.util.Date;
import java.util.Scanner;

/** Programa para calcular la edad de una persona en años, meses y días
 * @author del Rio Pulido Erik Federico
 * @date 8 de septiembre de 2019 
 */
public class Tarea2 {
    public static void main(String[] pps) {
            // Declaracion de variables
	Scanner in = new Scanner(System.in);
	int dia, mes, anio;
	int edad, meses, dias, mesesActuales, diaCumple;
	long tiempo;
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
	    System.out.println("¡No se permiten viajeros en el tiempo!");
	} else if(cumple.getYear()<0){
	    System.out.println("Tienes demasiados años");
	} else {
	    //Mostrar las fechas
	    System.out.println("\nTu cumple es: "+cumple.getDate()+"/"+(cumple.getMonth()+1)+"/"+(cumple.getYear()+1900) + "/");
	    System.out.println("Hoy es: "+hoy.getDate()+"/"+(hoy.getMonth()+1)+"/"+(hoy.getYear()+1900) + "/");

	    //Calcular la edad de una persona.

	    //Años
	    edad = 0;
	    tiempo = cumple.getTime();
	    cumple.setYear(cumple.getYear()+1);
	    while(cumple.getTime() < hoy.getTime()){
		tiempo = cumple.getTime();
		cumple.setYear(cumple.getYear()+1);
		edad += 1;
	    }
	    cumple.setTime(tiempo);

	    // Meses
	    meses = 0;
	    mesesActuales = cumple.getMonth();
	    diaCumple = cumple.getDate();
	    do{
		tiempo = cumple.getTime();
		cumple.setMonth(cumple.getMonth()+1);
		cumple.setDate(diaCumple);
		while(cumple.getMonth()>(mesesActuales+1)%12){ // Si 31 pasa a 30-28
		    cumple.setDate(cumple.getDate()-1);
		}
		meses += 1;
		mesesActuales += 1; 
	    }while(cumple.getTime() < hoy.getTime());
	    cumple.setTime(tiempo);
	    meses -= 1;

	    // dias
	    dias = 0;
	    cumple.setDate(cumple.getDate()+1);
	    while(cumple.getTime() <= hoy.getTime()){
		tiempo = cumple.getTime();
		cumple.setDate(cumple.getDate()+1);
		dias += 1;
	    }
	    cumple.setTime(tiempo);

	    // Mostrar resultados.
	    System.out.println("Tu edad es: " + edad + " años, "+ meses+" meses, "+ dias+" días");
	}
    }
}
