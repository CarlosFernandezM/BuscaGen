import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase Controlador
 *
 * @author Carlos Fernandez
 * @version 1.0
 * */

public class Controlador {
	
	/**
	 * LÃ­neas a leer desde el fichero para mostrar en la GUI
	 */
	private static final byte FASTA_HEAD_LINES = 10;  
	
	private static Controlador singleton;
	
        //Constructor privado. No hay que meterle cÃ³digo ninguno...
	private Controlador() {
		
	}

	/**
	 * Obtención del singleton	
	 */
	public static Controlador getSingleton() {
		if (singleton == null ) {
			singleton = new Controlador();
		}
		return singleton;
		
	}
	

	/**
	 * Comportamiento principal de la aplicaciÃ³n	
	 * @param gen
	 * @param mutaciones
	 * @param fichero
	 * @throws IOException 
	 */
	public void realizaBusqueda(String gen, String mutaciones,String fichero){
		Gen genes = new Gen(gen,Byte.parseByte(mutaciones));
		Fasta fasta = new Fasta(genes,fichero);
		String resultado = fasta.buscaGen();
		escribeFichero(resultado);
		 
	}
	
	
	/**
	 * Método auxiliar para escribir el String resultado de la búsqueda. Es llamado desde realizaBusqueda
	 * @param resultado
	 */
	private void escribeFichero(String resultado) {
		File fichero = new File("resultado.txt");
		try {
			FileWriter escritor = new FileWriter(fichero,false);
			escritor.write(resultado);
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Comportamiento que proporciona las primeras FASTA_HEAD_LINES para meter en el JTextArea
	 * @param fichero
	 * @return fichero
	 * @throws IOException 
	 */
         
	public String cargaHeadFasta(String fichero) throws IOException {
		File file = new File(fichero);
        String resultado = "";

        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int i = 0;

            while((linea = br.readLine()) != null && i <= FASTA_HEAD_LINES){
                resultado += linea+"\n";
                i++;
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

		return resultado;
	
	}
	
	
}
