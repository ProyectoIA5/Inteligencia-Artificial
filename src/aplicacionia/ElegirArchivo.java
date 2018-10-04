
package aplicacionia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ElegirArchivo extends javax.swing.JFrame {

    /**
     * Creates new form ElegirArchivo
     */
    public ElegirArchivo() {
        initComponents();
        this.setLocationRelativeTo(null); //CENTRAR FORM
        
        setIconImage(new ImageIcon(getClass().getResource("/aplicacionia/recursos/game.png")).getImage());//CAMBIA ICONO DE FORM
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ruta:");

        jButton1.setText("Abrir...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //Crea instancia de clase JFileChooser
            int resultado;
            JFileChooser selectorArchivos = new JFileChooser();
            File archivo = null;
            Archivo archivo1;
            
            FileNameExtensionFilter filtroTXT =new FileNameExtensionFilter("TXT","txt");//Instancia para filtrar por TXT
            //Se setea el selector
            selectorArchivos.setFileFilter(filtroTXT);
            //muestra el cuadro de dialogo para elegir el archivo
            //selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
            //Indica cual fue la accion del usuario sobre el JFileChooser
            resultado = selectorArchivos.showOpenDialog(null);
            
            if(resultado == JFileChooser.APPROVE_OPTION){
            
                archivo = selectorArchivos.getSelectedFile();
                archivo1= new Archivo(archivo.getName());
                try {
                    archivo1.leerArchivo();
                } catch (IOException ex) {
                    Logger.getLogger(ElegirArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(archivo.canRead())
                {
                    if(archivo.getName().endsWith("txt"))
                    {//SI EL ARCHIVO SELECCIONADO ES TXT
                        this.jTextField1.setText(archivo.getAbsolutePath());
                        
                        Scanner scan = new Scanner(archivo);
            
                        while(scan.hasNext()){
                            this.jTextArea1.insert(scan.nextLine()+"\n", this.jTextArea1.getText().length());
                        }
                        //-----------------------------------------------------------------------------------------
                        
                        //-----------------------------------------------------------------------------------------
                        int filas, columnas;
                        String[] aux, idauxiliar = null, identificadores = null;
                        
                        aux = jTextArea1.getText().split("\n");
                        filas = aux.length;                     //SEPARA POR SALTO DE LINEA PARA CONSEGUIR EL NUM DE FILAS
                        
                        idauxiliar = aux[0].split(",");     //SEPARA POR COMA (EN LA PRIMER FILA) PARA OBTENER EL NUM DE COLUMNAS NECESARIAS
                        columnas = idauxiliar.length;   
                        
                        
                       //VALIDAR SI TODAS LAS COLUMNAS TIENEN LA MISMA CANTIDAD DE COLUMNAS
                        identificadores = jTextArea1.getText().split(",");
                        
                        if (identificadores.length % filas != 0)    //NO FUNCIONA
                        {
                            //JOptionPane.showMessageDialog(null,"Mapa Incorrecto");
                        }
                        
                        //JOptionPane.showMessageDialog(null,identificadores);
                        //JOptionPane.showMessageDialog(null,columnas);
                        JOptionPane.showMessageDialog(null,identificadores.length);
                        
                        
                        
                    }
                    else
                    {//ERROR SI EL ARCHIVO NO ES TXT
                        JOptionPane.showMessageDialog(null,"Archivo No Compatible");
                    }
                }//FIN DE IF
            }//FIN DE IF
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ElegirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ElegirArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirArchivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElegirArchivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
