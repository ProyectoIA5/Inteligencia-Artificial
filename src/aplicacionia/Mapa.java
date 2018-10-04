
package aplicacionia;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mapa extends javax.swing.JPanel
{
    private ImageIcon agua, pared, nieve, lava, mountain, negro, gris;
    //private int idTerreno = -1;
    private Cuadro [][] cuadro;
        
    public Mapa() {
        initComponents();
    }
    
    public Mapa(int sizeX, int sizeY, int idTerreno) {
        initComponents();
        int x, y, aux = 0;
        //setLayout(new java.awt.GridLayout(sizeX+1, sizeY+1));
        cargarImagenes();
        cuadro = new Cuadro[sizeX+1][sizeY+1];
        
        if(sizeY == 15){
            aux = 61;
        }else if(sizeY == 14){
            aux = 65;   //65 PARA Y CON 14
        }else if(sizeY == 13){
            aux = 70;   //70 PARA Y CON 13
        }else if(sizeY == 12){
            aux = 76;   //76 PARA Y CON 12
        }else{
            aux = 83;  //83 PARA EL RESTO DE TAMAÑOS
        }
                
        for (int i = 0; i <= sizeX; i++)
        {
            for (int j = 0; j <= sizeY; j++)
            {
                cuadro[i][j] = new Cuadro(this);
                
                if(i == 0 && j != 0)
                {
                    x = (i * 41) + 1;
                    y = (j * aux) + 1;
                    cuadro[i][j].setFondo(gris);
                    cuadro[i][j].setBounds(x+(aux/2), y, (aux-1)/2, aux-1);
                    this.add(cuadro[i][j]);
                    
                }else if(j == 0 && i != 0)
                {
                    x = (i * aux) + 1;
                    y = (j * 41) + 1;
                    cuadro[i][j].setFondo(gris);
                    cuadro[i][j].setBounds(x, y+(aux/2), aux-1, (aux-1)/2);
                    this.add(cuadro[i][j]);
                }else if(i == 0 && j == 0){
                    
                }
                else{
                    x = (i * aux) + 1;
                    y = (j * aux) + 1;
                    cuadro[i][j].setFondo(negro);
                    cuadro[i][j].setBounds(x, y, aux-1, aux-1);
                    this.add(cuadro[i][j]);                    
                }
               
            }
        }
    }
    
    
    public void pintar(int x, int y){
        this.cuadro[x][y].setFondo(pared);
        this.repaint();
    }
    
    private void cargarImagenes() {
        this.agua = this.cargarFondo("/aplicacionia/recursos/agua.jpg");
        this.pared = this.cargarFondo("/aplicacionia/recursos/pared.jpg");
        this.nieve = this.cargarFondo("/aplicacionia/recursos/nieve.jpg");
        this.lava = this.cargarFondo("/aplicacionia/recursos/lava.png");
        this.mountain = this.cargarFondo("/aplicacionia/recursos/montaña.jpg");
        this.negro = this.cargarFondo("/aplicacionia/recursos/negro.jpg");
        this.gris = this.cargarFondo("/aplicacionia/recursos/gris.jpg");
        
    }
    
    protected static ImageIcon cargarFondo(String ruta) {
        java.net.URL localizacion = Mapa.class.getResource(ruta);
        if (localizacion != null) {
            return new ImageIcon(localizacion);
        } else {
            System.err.println("No se ha encontrado el archivo: " + ruta);
            return null;
        }
    }
    
    public int[] getCoordenadas(Cuadro cuadro) {
        int [] coordenadas = new int[2];
        for (int i=0; i < this.cuadro.length; i++) {
            for (int j=0; j < this.cuadro.length; j++) {
                if (this.cuadro[i][j] == cuadro) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }
    
    public Cuadro[][] getCuadro() {
        return cuadro;
    }
    
    public void setCuadro(Cuadro[][] cuadro) {
        this.cuadro = cuadro;
    }
                              
    private void initComponents() {
        setLayout(null);
        //setBackground(new java.awt.Color(255 , 255, 255));
        //setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(970, 970)); //DIMENSION DEL MAPA
    }                      
                     
}
