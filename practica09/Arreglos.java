/**
 * Clase para practicar el uso de arreglos y la estructura for.
 */
public class Arreglos {

    /**
     * Regresa el índice de un elemento en el arreglo dado, o -1 si no aparece.
     * @param arr el arreglo en el cual se buscará el parámetro k
     * @param k el entero a buscar
     * @return el índice de k en arr, o -1 si no aparece
     */
    public static int buscar(int[] arr, int k) {
	int num = -1;
	for(int i=0; i<arr.length && num==-1; i++){
	    if (arr[i] == k){
		num = i;
	    }
	}
        return num;
    }

    /**
     * Regresa el mayor entero de un arreglo. Puedes suponer que arr contiene al menos un elemento.
     * @param arr el arreglo
     * @return el elemento máximo de arr
     */
    public static int max(int[] arr) {
	int maximo = arr[0];
	for(int i=0; i<arr.length; i++){
	    if(arr[i]>maximo){
		maximo = arr[i];
	    }
	}
        return maximo;
    }

    /**
     * Determina si existen dos elementos consecutivos en el arreglo dado que sumen a k.
     * @param arr el arreglo en el que se buscará
     * @param k el número a buscar
     * @return true si existen dos elementos consecutivos que sumen a k
     */
    public static boolean consecutivos(int[] arr, int k) {
	boolean consecutivos = false;
	for(int i=0; i<arr.length-1 && !consecutivos; i++){
	    if(arr[i]+arr[i+1] == k){
		consecutivos = true;
	    }
	}
        return consecutivos;
    }

    /**
     * Suma todos los enteros de un arreglo
     * @param arr Arreglo del que se van a sumar sus elementos
     * @return int la suma de los elementos del arreglo 
     */
    public static int sumaArreglo(int[] arr){
	int suma = 0;
	for(int i=0; i<arr.length; i++){
	    suma += arr[i];
	}
	return suma;
    }
    
    /**
     * Pruebas unitarias para verificar que tus implementaciones son correctas.
     */
    public static void main(String[] args) {
        pruebasDe2a4();
	prueba5();
        // Tus pruebas
        
    }

    private static void prueba5(){
	boolean bien = true;

	int[] arr1 = {23, 6, -15, 2, 9};
	int[] arr2= {};
	int[] arr3 = {0, -1, 1};

	int suma1 = sumaArreglo(arr1);
	int suma2 = sumaArreglo(arr2);
	int suma3 = sumaArreglo(arr3);

	if (suma1 != 25){
	    System.out.println("La suma de arr1 deberia ser 25, pero da: "+suma1);
	    bien = false;
	}
	if (suma2 != 0){
	    System.out.println("La suma de arr2 deberia ser 0, pero da: "+suma2);
	    bien = false;
	}
	if (suma3 != 0){
	    System.out.println("La suma de arr3 deberia ser 0, pero da: "+suma3);
	    bien = false;
	}
	if(bien){
	    System.out.println("Suma esta bien");
	}
    }
    
    private static void pruebasDe2a4() {
        var random = new java.util.Random();
        int COTA = 20, N = 15 + random.nextInt(10);
        var mal = false;
        var arrI = new Integer[N];
        int aPos = 0, bPos = 0;
        while (aPos == bPos) {
            aPos = random.nextInt(arrI.length);
            bPos = random.nextInt(arrI.length);
        }
        arrI[0] = random.nextInt(COTA);
        for (int i = 1; i < arrI.length; i++) {
            arrI[i] = arrI[i - 1] + random.nextInt(COTA) + 1;
        }
        
        java.util.Collections.shuffle(java.util.Arrays.asList(arrI));
        int[] arr = java.util.Arrays.stream(arrI).mapToInt(Integer::intValue).toArray();
        int a = arr[aPos], b = arr[bPos];

        // Buscar
        if (buscar(arr, a) != aPos) {
            imprimir("arr = %s", java.util.Arrays.toString(arr));
            imprimir("buscar(arr, %d) debió regresar %d pero regresó %d.\n", a, aPos, buscar(arr, a));
            mal = true;
        }
        if (buscar(arr, b) != bPos) {
            imprimir("arr = %s", java.util.Arrays.toString(arr));
            imprimir("buscar(arr, %d) debió regresar %d pero regresó %d.\n", b, bPos, buscar(arr, b));
            mal = true;
        }
        if (buscar(arr, Integer.MIN_VALUE) != -1) {
            imprimir("arr = %s", java.util.Arrays.toString(arr));
            imprimir("buscar(arr, %d) debió regresar %d pero regresó %d.\n", 
                Integer.MIN_VALUE, -1, buscar(arr, Integer.MIN_VALUE));
            mal = true;
        }

        // Max
        int max = java.util.Arrays.stream(arr).max().getAsInt();
        if (max(arr) != max) {
            imprimir("arr = %s", java.util.Arrays.toString(arr));
            imprimir("max(arr) debió regresar %d pero regresó %d.\n", max, max(arr));
            mal = true;
        }

        // Consecutivos
        if (consecutivos(arr, -10)) {
            imprimir("arr = %s", java.util.Arrays.toString(arr));
            imprimir("consecutivos(arr, -10) debió regresar false pero regresó true.\n");   
            mal = true;
        }
        int c = aPos < arr.length - 1 ? aPos : bPos;
        if (!consecutivos(arr, arr[c] + arr[c + 1])) {
            imprimir("arr = %s", java.util.Arrays.toString(arr));
            imprimir("consecutivos(arr, %d) debió regresar true pero regresó false.\n",
                arr[c] + arr[c + 1]);
            mal = true;
        }

        if (!mal) {
            System.out.println("Los incisos 2, 3, y 4 están bien.");
        }
    }
    
    private static void imprimir(String format, Object... objs) {
        System.out.println(String.format(format, objs));
    }

}
