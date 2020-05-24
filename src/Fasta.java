import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

public class Fasta {
	/**
	 * Clase Fasta
	 *
	 * No esta terminado pero va a contener informacion para devolver la cola para el número de errores junto al numero de linea donde se encuentra el gen encontrado
	 * @author Carlos Fernandez
	 * @version 1.0
	 * */
	//Estado
	
	/**
	 * Gen que deseamos buscar
	 */
	
	Gen gen;
	
	/**
	 * Fichero que seleccionamos para buscar el gen que deseamos
	 */

	String ficheroSeleccionado;
	
	/**
	 * Resultado de la búsqueda
	 */
	String resultado = "";
		
	//Comportamiento
	/**
	 * Constructor con 2 parametros
	 * @param migen gen
	 * @param fichero fichero donde deseamos buscar
	 */
	
	
    public Fasta(Gen migen, String fichero) {
    	gen = migen;
    	ficheroSeleccionado = fichero;
    }
    
	/**
	 * Comportamiento principal de búsqueda. Abrirá el fichero, creará la cola, la alimentará y le dará
	 * la cola a gen para comparar el contenido y así obtener el resultado.
	 * @throws IOException 
	 */

    public String buscaGen(){
		//Abrir el fichero
		char letra;
		String primeraLinea="";
		int contador_linea = 0;
		
		Queue<Character> cola = new LinkedList();
		
    	try {
    		FileInputStream ficheroEncontrado = new FileInputStream(ficheroSeleccionado);
    		BufferedInputStream leerCaracter = new BufferedInputStream(ficheroEncontrado); //Es más rápido. Se crea a partir del FileInputStream

    		
    		while((letra = (char) leerCaracter.read())!='\n') {
    			primeraLinea+=letra;
    		}
    		
    		//Creamos la cola
    		
    		
    		//El gen nunca es mayor que la cola
    		while (cola.size()!=gen.getDatos().length()) {
    			letra = (char) leerCaracter.read();
    			if (letra!='\n') {
    				cola.add(letra);
    			}
    		}
    		
	    	//Comparar
	    	//Devuelve la cantidad de byte. 
    		while(leerCaracter.available() !=0) {
    			letra = (char) leerCaracter.read();

    	    	if (letra!='\n') {
    				cola.add(letra);
    				cola.remove();
    				String resultadoComparacion = gen.compara(cola);
    				if (resultadoComparacion != ""){
    					resultado += resultadoComparacion + ";" + contador_linea + "\n";
					}
    			} else {
    				contador_linea ++;
    			}
    		}
    		
    		ficheroEncontrado.close();
	    	
    
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    
		return gen.getDatos() + ";" + gen.getMutaciones() + "\n" + primeraLinea + "\n" + resultado;
    }

	
}
