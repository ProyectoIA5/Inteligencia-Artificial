/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionia;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**  
 *
 * @author Dell
 */
public class Archivo {
    
    private String ruta_archivo;
    private File archivo;
    private FileReader lector;
    private BufferedReader buffer;
    public static final String SEPARADOR = ",";
    private String[][] matrizMapa = new String[15][15];
    
    public Archivo(String ruta_archivo){
        this.ruta_archivo=ruta_archivo;
    }
    
    public String getRutaArchivo(){
        return this.ruta_archivo;
    }
    public void setArchivo(String archivo){
        this.archivo= new File(archivo);
    }
    public File getArchivo(){
        return this.archivo;
    }
    public FileReader getLector(){
        return this.lector;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    public void leerArchivo() throws IOException {
        int i=0;
        
        try{
            this.archivo = new File(getRutaArchivo());
            this.lector = new FileReader(getArchivo());
            this.buffer = new BufferedReader(getLector());
            
            String linea;
            
            while(buffer.readLine()!=null){
                linea = buffer.readLine();
                String [] arrAux = linea.split(SEPARADOR);
                System.out.println(Arrays.toString(arrAux));
                this.matrizMapa[i] = arrAux;
                System.out.println(Arrays.toString(matrizMapa[i]));
                
                i++;
            }        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return this.matrizMapa;
    }
    
}
