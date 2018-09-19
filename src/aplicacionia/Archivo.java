/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionia;

import java.io.*;
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
    
    public Archivo(String ruta_archivo){
        this.ruta_archivo=ruta_archivo;
    }
    
    public void setRutaArchivo(){
        
    }
    
    public void leerArchivo() throws IOException {
        try{
            this.archivo = new File(this.ruta_archivo);
            this.lector = new FileReader(this.archivo);
            this.buffer = new BufferedReader(this.lector);
            
            String linea;
            
            while(buffer.readLine()!=null){
                linea = buffer.readLine();
            }        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
