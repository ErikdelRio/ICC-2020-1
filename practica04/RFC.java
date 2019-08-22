import java.util.Scanner;

public class RFC {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String nombreComp, apPat, apMat, nombre, fecha, dia, mes, anio;

	// Leer nombre
	System.out.println("Dame tu nombre completo empezando por nombre:");
	nombreComp = scanner.nextLine();
	nombreComp = nombreComp.trim();
	// Leer fecha
	System.out.println("Dame tu fecha de naciemiento en formato dd/mm/aaaa:");    
	fecha = scanner.nextLine();
	nombreComp = nombreComp.trim();

	// Nombre
	int pos = nombreComp.indexOf(" "),
	    pos2 = nombreComp.lastIndexOf(" ");
	nombre = nombreComp.substring(0, pos);
	// Apellido paterno y materno
	apPat = nombreComp.substring(pos+1,pos2);
	apMat = nombreComp.substring(pos2+1, nombreComp.length());

	//Fecha de nac
	pos = fecha.indexOf("/");
	pos2 = fecha.lastIndexOf("/");

	dia = fecha.substring(0,pos);
	mes = fecha.substring(pos+1,pos2);
	anio = fecha.substring(pos2+1,fecha.length());
	// Crear el rfc
	String rfc;
	rfc = apPat.substring(0,2);
	rfc += apMat.substring(0,1);
	rfc += nombre.substring(0,1);
	rfc += anio.substring(2,4);
	rfc += mes;
	rfc += dia;

	rfc = rfc.toUpperCase();
	System.out.println("El RFC de "+nombreComp+" es: "+rfc);
    }
}
