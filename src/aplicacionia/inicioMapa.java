package aplicacionia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class inicioMapa extends javax.swing.JFrame
{
    Mapa mapa;
    //int[] Identificadores;
    
    private void initComponents(int fila, int columna, int[][] MatrizIDs)
    {
        Mapa mapa= new Mapa(fila, columna, MatrizIDs);
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout mapaLayout = new javax.swing.GroupLayout(mapa);
        mapa.setLayout(mapaLayout);
        mapaLayout.setHorizontalGroup(
            mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        mapaLayout.setVerticalGroup(
            mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                //.addContainerGap(45,50)
                .addComponent(mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE)) //TAMAÑO HORIZONTAL
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                //.addContainerGap(45,50)
                .addComponent(mapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))  //TAMAÑO VERTICAL
        );
        pack();
        
    }
    
    public inicioMapa(int fila, int columna, int[][] MatrizIDs)
    {
        initComponents(fila, columna, MatrizIDs);
        this.setLocationRelativeTo(null); //CENTRAR FORM
        setIconImage(new ImageIcon(getClass().getResource("/aplicacionia/recursos/game.png")).getImage());//CAMBIA ICONO DE FORM
    }
    
    
}
