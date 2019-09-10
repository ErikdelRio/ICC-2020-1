/**
 * Clase para guardar un libro, con atributos autor, titulo y anio de publicacion
 * @author Erik del Rio 
 * @version 1.0
 */
public class Libro {
    //Atributos
    String titulo, autor;
    int anioPublicacion;

    // Constructores
    /*
     * Crea un objeto libro con valores iniciales
     */
    public Libro () {
	titulo = "";
	autor = "";
	anioPublicacion = 0;
    }
    /*
     * Crea un objeto con valores iniciales que le da el usuario
     * @param nuevoTitulo String, el nombre del libro
     * @param nuevoAutor String, el nombre del autor
     * @param nuevoAnio int, el anio en el que fue publicado el libro
     */
    public Libro (String nuevoTitulo, String nuevoAutor, int nuevoAnio){
	titulo = nuevoTitulo;
	autor = nuevoAutor;
	anioPublicacion = nuevoAnio;
    }

    //Asignar
    /*
     * Asigna un nuevo valor al titulo del libro
     * @param nuevoTitulo String, el nombre del nuevo titulo
     */
    public void setTitulo(String nuevoTitulo){
	titulo = nuevoTitulo;
    }
    /*
     * Asigna un nuevo valor al autor del libro
     * @param nuevoAutor String, el nombre del autor
     */
    public void setAutor(String nuevoAutor){
	autor = nuevoAutor;
    }
    /*
     * Asigna un nuevo valor al anio de publicacion del libro
     * @param nuevoAnio int, fecha de publicacion del libro 
     */
    public void setAnioPublicacion(int nuevoAnio){
	anioPublicacion = nuevoAnio;
    }

    // Obtener
    /*
     * Obtiene el nombre del libro
     * @return String Titulo del libro
     */
    public String getTitulo(){
	return titulo;
    }
    /*
     * Obtiene el nombre del autor
     * @return String Autor del libro
     */   
    public String getAutor(){
	return autor;
    }
    /*
     * Obtiene el anio de publicacion
     * @return int Anio de publicacion
     */
    public int getAnioPublicacion(){
	return anioPublicacion;
    }
}
