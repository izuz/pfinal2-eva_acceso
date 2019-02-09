package paquete;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 * @author Gonzalo Izuzquiza
 */
public class interfaz extends javax.swing.JFrame {
    
    DefaultTableModel tabla_mostrar;
    String errores = "";

    /**
     * Creates new form interfaz
     */
    public interfaz() {
        initComponents();
        this.getContentPane().setBackground(Color.green); // damos color al fondo del jFrame
        this.setLocationRelativeTo(null); // con esto hacemos que la pnatalla se abra en el centro de la pantalla
        //this.setSize(730, 500);

        try {
            gc.conn1.setAutoCommit(false);

            Statement sta = gc.conn1.createStatement();

            String query = "SELECT * FROM liga ";

            ResultSet rs = sta.executeQuery(query);
            ResultSetMetaData metaDatos = rs.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

            DefaultTableModel modelo = new DefaultTableModel();

            this.datos.setModel(modelo);

            for (int i = 1; i <= numColumnas; i++) {
                modelo.addColumn(metaDatos.getColumnLabel(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        datos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jugadores_consultar = new javax.swing.JButton();
        equipos_consultar = new javax.swing.JButton();
        ligas_consultar = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        id_texto = new javax.swing.JLabel();
        coger_id = new javax.swing.JTextField();
        jugadores_eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(datos);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LAS LIGAS 17/18");

        jugadores_consultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jugadores_consultar.setText("Consultar Jugadores");
        jugadores_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadores_consultarActionPerformed(evt);
            }
        });

        equipos_consultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        equipos_consultar.setText("Consultar Equipos");
        equipos_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipos_consultarActionPerformed(evt);
            }
        });

        ligas_consultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ligas_consultar.setText("Consultar Ligas");
        ligas_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ligas_consultarActionPerformed(evt);
            }
        });

        id_texto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        id_texto.setText("id_jugador");

        coger_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_id.setText("1");
        coger_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coger_idActionPerformed(evt);
            }
        });

        jugadores_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jugadores_eliminar.setText("Eliminar Jugador");
        jugadores_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadores_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jugadores_consultar)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(id_texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(coger_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(equipos_consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jugadores_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ligas_consultar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadores_consultar)
                    .addComponent(equipos_consultar)
                    .addComponent(ligas_consultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coger_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugadores_eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jugadores_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadores_consultarActionPerformed
        try {
            gc.conn1.setAutoCommit(false);

            String query = "SELECT * FROM jugadores ";

            Statement sta = gc.conn1.createStatement();

            ResultSet rs = sta.executeQuery(query);
            ResultSetMetaData metaDatos = rs.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

            tabla_mostrar = new DefaultTableModel();

            this.datos.setModel(tabla_mostrar);

            for (int i = 1; i <= numColumnas; i++) {
                tabla_mostrar.addColumn(metaDatos.getColumnLabel(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                tabla_mostrar.addRow(fila);
            }

            rs.close();

            sta.close();

        } catch (Exception e) {
            e.printStackTrace();
            errores = e.toString();
            error.setText(errores);
        }
    }//GEN-LAST:event_jugadores_consultarActionPerformed

    private void equipos_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipos_consultarActionPerformed
        try {
            gc.conn1.setAutoCommit(false);

            String query = "SELECT * FROM equipo ";

            Statement sta = gc.conn1.createStatement();

            ResultSet rs = sta.executeQuery(query);
            ResultSetMetaData metaDatos = rs.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

            tabla_mostrar = new DefaultTableModel();

            this.datos.setModel(tabla_mostrar);

            for (int i = 1; i <= numColumnas; i++) {
                tabla_mostrar.addColumn(metaDatos.getColumnLabel(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                tabla_mostrar.addRow(fila);
            }

            rs.close();

            sta.close();

        } catch (Exception e) {
            e.printStackTrace();
            errores = e.toString();
            error.setText(errores);
        }
    }//GEN-LAST:event_equipos_consultarActionPerformed

    private void ligas_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ligas_consultarActionPerformed
       try {
            gc.conn1.setAutoCommit(false);

            String query = "SELECT * FROM liga ";

            Statement sta = gc.conn1.createStatement();

            ResultSet rs = sta.executeQuery(query);
            ResultSetMetaData metaDatos = rs.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

            tabla_mostrar = new DefaultTableModel();

            this.datos.setModel(tabla_mostrar);

            for (int i = 1; i <= numColumnas; i++) {
                tabla_mostrar.addColumn(metaDatos.getColumnLabel(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                tabla_mostrar.addRow(fila);
            }

            rs.close();

            sta.close();

        } catch (Exception e) {
            e.printStackTrace();
            errores = e.toString();
            error.setText(errores);
        }
    }//GEN-LAST:event_ligas_consultarActionPerformed

    private void jugadores_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadores_eliminarActionPerformed
        try {
            gc.conn1.setAutoCommit(false);

            //String query = "DELETE FROM jugadores WHERE id_jugador like" + coger_id.getText();

            Statement sta = gc.conn1.createStatement();

            ResultSet rs = sta.executeUpdate("DELETE FROM jugadores WHERE id_jugar like" + coger_id.getText());
            ResultSetMetaData metaDatos = rs.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

            tabla_mostrar = new DefaultTableModel();

            this.datos.setModel(tabla_mostrar);

            for (int i = 1; i <= numColumnas; i++) {
                tabla_mostrar.addColumn(metaDatos.getColumnLabel(i));
            }

            while (rs.next()) {
                Object[] fila = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                tabla_mostrar.addRow(fila);
            }

            rs.close();

            sta.close();

        } catch (Exception e) {
            e.printStackTrace();
            errores = e.toString();
            error.setText(errores);
        }
    }//GEN-LAST:event_jugadores_eliminarActionPerformed

    private void coger_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coger_idActionPerformed
        coger_id.setText("");
    }//GEN-LAST:event_coger_idActionPerformed
    GestorConexion gc = new GestorConexion();
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
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField coger_id;
    private javax.swing.JTable datos;
    private javax.swing.JButton equipos_consultar;
    private javax.swing.JLabel error;
    private javax.swing.JLabel id_texto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jugadores_consultar;
    private javax.swing.JButton jugadores_eliminar;
    private javax.swing.JButton ligas_consultar;
    // End of variables declaration//GEN-END:variables
}
