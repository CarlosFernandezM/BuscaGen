import java.util.Queue;

/**
 * Clase Gen
 *
 * Contiene informacion para devolver la cola para el número de errores
 * @author Carlos Fernandez
 * @version 1.0
 * */

public class Gen {
	//Estado
	
	String datos;
	
	/**
	 * Numero de mutaciones permitidas
	 */
	byte mutaciones;
	
	
	
	 //Comportamiento
	/**
	 * Constructor con 2 parametros
	 * @param datos datos
	 * @param mutaciones mutaciones
	 */

    public Gen(String datos, byte mutaciones) {
		this.datos = datos;
		this.mutaciones = mutaciones;
	}

        //Getter
    /**
     * Devuelve los datos
     * @return datos
     */
    public String getDatos() {
		return datos;
	}


	/**
	 * Comportamiento clave. Se llamarÃ¡ cada vez que el fichero cambie la cola. Nos dan una cola y la comparamos con nuestro
	 * String caracter a caracter contando los fallos/errores. Se debe devolver una cadena "cola;erroresencontrados"
	 * @param cola
	 */

    public String compara(Queue<Character> cola) {
    	int numerovariaciones = 0;
    	String resultado = "";
    	int i = 0;
    	boolean coincide = true;
    	
		for (char caracter: cola) {
			if (datos.charAt(i) != caracter) {
				numerovariaciones = numerovariaciones +1;
				if (numerovariaciones > mutaciones) {
					coincide = false;
					break;
				}
			}
			resultado += caracter;
			i ++;
		}
		
		if (coincide) {
			return resultado + ";" + numerovariaciones;
		} else {
			return "";
		}
    }
	
	
        //Getter
    /**
     * Devuelve la mutacion
     * @return mutacion
     */
	public byte getMutaciones() {
		return mutaciones;
	}


	
	
	

}
