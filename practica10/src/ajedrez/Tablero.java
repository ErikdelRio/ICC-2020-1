package ajedrez;

import processing.core.PApplet;
// javac -classpath lib/core.jar -d build src/paquete/A.java (direccion)
// java --classpath build:lib/core paquete.Clase
// fill(int, int, int) | fill(int)
// rect(x,y,w,h)

public class Tablero extends PApplet {
    int ancho;
    public static void main(String[] args){
	PApplet.main("ajedrez.Tablero");
    }

    @Override
    public void settings(){
	ancho = displayHeight * 2 / 3;
	size(ancho, ancho);
    }
    
    @Override
    public void setup(){
    }
    
    @Override
    public void draw(){
	int negro = 0xFF666666, blanco = 0xFFFFFFFF;
	int tam = ancho/8;
	for (int i=0; i<8; i++){
	    for(int j=0; j<8; j++){
		int color =  ((i+j)%2 == 0)? blanco : negro;
		fill(color);

		rect(i*tam, j*tam, tam, tam);
	    }
	}
    }
    
}
