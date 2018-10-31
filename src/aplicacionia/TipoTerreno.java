package aplicacionia;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


public class TipoTerreno extends javax.swing.JFrame {

    /**
     * Creates new form TipoTerreno
     */
    
    public TipoTerreno(int [][]matrizMapa) {
        initComponents();
        this.setLocationRelativeTo(null); //CENTRAR FORM
        
        setIconImage(new ImageIcon(getClass().getResource("/aplicacionia/recursos/game.png")).getImage());//CAMBIA ICONO DE FORM
        
        jtTerrenos.getTableHeader().setFont(new Font("Dream Orphans", 1, 24));
        jtTerrenos.getTableHeader().setForeground(Color.red);
        
        this.matrizMapa=matrizMapa;
    }

    private TipoTerreno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<Integer> idTerrenos(){
        
        //int[] identificadores;
        List<Integer> ids = new ArrayList<>();
        int contador=0;
        boolean sacar=true;
        ids.add(this.matrizMapa[0][0]);
        
        int[][] matrizInt =this.matrizMapa;
        
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                contador = 0;
                System.out.println("Posicion a evaluar: "+i+" "+j );
                sacar=true;
                
                if(ids.contains(matrizInt[i][j])) {
                } else {
                    ids.add(matrizInt[i][j]);
                }
            }
        }
        System.out.println("Identificadores");
        System.out.println(ids);
        
        return ids;
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonAceptaSelec = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtTerrenos = new javax.swing.JTable();
        buttonAceptaSelec1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(482, 346));
        setMinimumSize(new java.awt.Dimension(482, 346));
        setUndecorated(true);
        setResizable(false);

        buttonAceptaSelec.setBackground(new java.awt.Color(255, 0, 0));
        buttonAceptaSelec.setFont(new java.awt.Font("Dream Orphans", 1, 20)); // NOI18N
        buttonAceptaSelec.setForeground(new java.awt.Color(255, 255, 255));
        buttonAceptaSelec.setText("Aceptar");
        buttonAceptaSelec.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonAceptaSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptaSelecActionPerformed(evt);
            }
        });

        jtTerrenos.setFont(new java.awt.Font("Dream Orphans", 0, 24)); // NOI18N
        jtTerrenos.setForeground(new java.awt.Color(255, 0, 51));
        jtTerrenos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"0", null},
                {"11", null}
            },
            new String [] {
                "TERRENO", "TIPO DE TERRENO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtTerrenos.setToolTipText("");
        jtTerrenos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jtTerrenos.setGridColor(new java.awt.Color(204, 204, 204));
        jtTerrenos.setMaximumSize(new java.awt.Dimension(482, 346));
        jtTerrenos.setMinimumSize(new java.awt.Dimension(482, 346));
        jtTerrenos.setRowHeight(50);
        jtTerrenos.setRowMargin(0);
        jtTerrenos.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jtTerrenos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtTerrenos);
        if (jtTerrenos.getColumnModel().getColumnCount() > 0) {
            jtTerrenos.getColumnModel().getColumn(0).setResizable(false);
            jtTerrenos.getColumnModel().getColumn(1).setResizable(false);
        }

        buttonAceptaSelec1.setBackground(new java.awt.Color(255, 0, 0));
        buttonAceptaSelec1.setFont(new java.awt.Font("Dream Orphans", 1, 20)); // NOI18N
        buttonAceptaSelec1.setForeground(new java.awt.Color(255, 255, 255));
        buttonAceptaSelec1.setText("Cerrar");
        buttonAceptaSelec1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonAceptaSelec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptaSelec1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAceptaSelec1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAceptaSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAceptaSelec, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAceptaSelec1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAceptaSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptaSelecActionPerformed
        List<Integer> aux;
        
        aux = idTerrenos();
        //Object[][] = aux
                
        //this.jtTerrenos.set
        
    }//GEN-LAST:event_buttonAceptaSelecActionPerformed

    private void buttonAceptaSelec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptaSelec1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonAceptaSelec1ActionPerformed

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
            java.util.logging.Logger.getLogger(TipoTerreno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoTerreno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoTerreno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoTerreno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TipoTerreno().setVisible(true);
            }
        });
    }
    private int[][] matrizMapa;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAceptaSelec;
    private javax.swing.JButton buttonAceptaSelec1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtTerrenos;
    // End of variables declaration//GEN-END:variables
}
