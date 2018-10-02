package aplicacionia;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cuadro extends javax.swing.JPanel implements MouseListener
{
    
    private Mapa tablero;
    private ImageIcon fondo;
    private static int [] casillaMarcada = new int[2];
    
    public Cuadro()
    {        
        // este constructor no se usará, se deja para poder crear el bean.        
    }
    
    public Cuadro (Mapa t)
    {
        initComponents();        
        this.tablero = t;
        if(this.tablero.getTipoTablero() == true){// tablero responde a clics?
            this.addMouseListener(this);
        }
    }
    
    public void setFondo(ImageIcon fondo){
        this.fondo = fondo;
    }
    
    public ImageIcon getFondo(){        
        return this.fondo;
    }
    
                          
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
    }                       
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0,0,this.getWidth(),this.getHeight(),this);
    }
    
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
            this.setCasillaMarcada(tablero.getCoordenadas((Cuadro)e.getComponent())); 
            this.tablero.pintar(this.getCasillaMarcada()[0],this.getCasillaMarcada()[1]);
    }
    public void mouseReleased(MouseEvent e){}
    
    public static int[] getCasillaMarcada() {
        return casillaMarcada;
    }
    public static void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }                  
    
}

