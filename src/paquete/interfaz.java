package paquete;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
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
        cogerLiga.removeAllItems();
        ArrayList<String> lista = new ArrayList<String>();
        lista = gc.llenarLigas();
        for (int i = 0; i < lista.size(); i++) {
            cogerLiga.addItem(lista.get(i));
        }

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
        titulo = new javax.swing.JLabel();
        jugadores_consultar = new javax.swing.JButton();
        equipos_consultar = new javax.swing.JButton();
        ligas_consultar = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        id_texto = new javax.swing.JLabel();
        coger_id = new javax.swing.JTextField();
        jugadores_eliminar = new javax.swing.JButton();
        coger_nombreEquipo = new javax.swing.JTextField();
        nombreEquipo = new javax.swing.JLabel();
        nombreCiudad = new javax.swing.JLabel();
        coger_nombreCiudad = new javax.swing.JTextField();
        nombreEstadio = new javax.swing.JLabel();
        nombrePresidente = new javax.swing.JLabel();
        fundado = new javax.swing.JLabel();
        coger_anno = new javax.swing.JTextField();
        a_favor = new javax.swing.JLabel();
        coger_aFavor = new javax.swing.JTextField();
        en_contra = new javax.swing.JLabel();
        coger_enContra = new javax.swing.JTextField();
        nombreLiga = new javax.swing.JLabel();
        insertar_equipoBoton = new javax.swing.JButton();
        coger_nombrePresidente = new javax.swing.JTextField();
        coger_nombreEstadio = new javax.swing.JTextField();
        cogerLiga = new javax.swing.JComboBox<>();

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

        titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("LAS LIGAS 17/18");

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
        coger_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_idMouseClicked(evt);
            }
        });

        jugadores_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jugadores_eliminar.setText("Eliminar Jugador");
        jugadores_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadores_eliminarActionPerformed(evt);
            }
        });

        coger_nombreEquipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nombreEquipo.setText("Nombe Equipo");

        nombreEquipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEquipo.setText("Nombre");

        nombreCiudad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreCiudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCiudad.setText("Ciudad");

        coger_nombreCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nombreCiudad.setText("Ciudad");

        nombreEstadio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreEstadio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEstadio.setText("Estadio");

        nombrePresidente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombrePresidente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePresidente.setText("Presidente");

        fundado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fundado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fundado.setText("Año fundado");

        coger_anno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_anno.setText("Año");

        a_favor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        a_favor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_favor.setText("Goles a favor");

        coger_aFavor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_aFavor.setText("a favor");

        en_contra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        en_contra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        en_contra.setText("Goles en contra");

        coger_enContra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_enContra.setText("en contra");

        nombreLiga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreLiga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreLiga.setText("Nombre Liga");

        insertar_equipoBoton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertar_equipoBoton.setText("Insertar equipo");
        insertar_equipoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_equipoBotonActionPerformed(evt);
            }
        });

        coger_nombrePresidente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nombrePresidente.setText("Presidente");

        coger_nombreEstadio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nombreEstadio.setText("Estadio");

        cogerLiga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cogerLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cogerLigaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
                            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombreEquipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coger_nombreEquipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombreCiudad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coger_nombreCiudad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombrePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(coger_nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(coger_nombrePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fundado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coger_anno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(a_favor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coger_aFavor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(en_contra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coger_enContra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreLiga, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(cogerLiga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insertar_equipoBoton))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreLiga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(coger_nombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(coger_nombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(coger_nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nombrePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fundado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(coger_anno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(coger_nombrePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(en_contra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(a_favor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(coger_aFavor)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(coger_enContra)
                                    .addComponent(cogerLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(insertar_equipoBoton, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
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
        gc.eliminarJugador(coger_id.getText());
        jugadores_consultarActionPerformed(evt);
        error.setText(gc.cadena_resultado);
    }//GEN-LAST:event_jugadores_eliminarActionPerformed

    private void coger_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_idMouseClicked
        coger_id.setText("");
    }//GEN-LAST:event_coger_idMouseClicked

    private void insertar_equipoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_equipoBotonActionPerformed

    }//GEN-LAST:event_insertar_equipoBotonActionPerformed

    private void cogerLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cogerLigaActionPerformed

    }//GEN-LAST:event_cogerLigaActionPerformed
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
    private javax.swing.JLabel a_favor;
    private javax.swing.JComboBox<String> cogerLiga;
    private javax.swing.JTextField coger_aFavor;
    private javax.swing.JTextField coger_anno;
    private javax.swing.JTextField coger_enContra;
    private javax.swing.JTextField coger_id;
    private javax.swing.JTextField coger_nombreCiudad;
    private javax.swing.JTextField coger_nombreEquipo;
    private javax.swing.JTextField coger_nombreEstadio;
    private javax.swing.JTextField coger_nombrePresidente;
    private javax.swing.JTable datos;
    private javax.swing.JLabel en_contra;
    private javax.swing.JButton equipos_consultar;
    private javax.swing.JLabel error;
    private javax.swing.JLabel fundado;
    private javax.swing.JLabel id_texto;
    private javax.swing.JButton insertar_equipoBoton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jugadores_consultar;
    private javax.swing.JButton jugadores_eliminar;
    private javax.swing.JButton ligas_consultar;
    private javax.swing.JLabel nombreCiudad;
    private javax.swing.JLabel nombreEquipo;
    private javax.swing.JLabel nombreEstadio;
    private javax.swing.JLabel nombreLiga;
    private javax.swing.JLabel nombrePresidente;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
