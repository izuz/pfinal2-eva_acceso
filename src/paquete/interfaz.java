package paquete;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
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
        this.getContentPane().setBackground(Color.GREEN); // damos color al fondo del jFrame
        this.setLocationRelativeTo(null); // con esto hacemos que la pnatalla se abra en el centro de la pantalla
        llenarLiga();
        llenarEquipo();

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
        coger_nombreJugador = new javax.swing.JTextField();
        nombreJugador = new javax.swing.JLabel();
        coger_posicion = new javax.swing.JTextField();
        nombrePosicon = new javax.swing.JLabel();
        coger_nacionalidad = new javax.swing.JTextField();
        nombrenacionalidad = new javax.swing.JLabel();
        cogerEquipo = new javax.swing.JComboBox<>();
        nombreTeam = new javax.swing.JLabel();
        insertar_jugador = new javax.swing.JButton();
        coger_nombreLiga = new javax.swing.JTextField();
        nombre_LIGA = new javax.swing.JLabel();
        coger_pais = new javax.swing.JTextField();
        pais_texto = new javax.swing.JLabel();
        coger_equipos = new javax.swing.JTextField();
        equipos_texto = new javax.swing.JLabel();
        coger_partidos = new javax.swing.JTextField();
        partidos_texto = new javax.swing.JLabel();
        insertar_liga = new javax.swing.JButton();
        pelota = new javax.swing.JLabel();
        ligas = new javax.swing.JLabel();
        datos_tabla_insertar = new javax.swing.JButton();
        modifica_nombreLiga = new javax.swing.JTextField();
        modifica_pais = new javax.swing.JTextField();
        modifica_equipos = new javax.swing.JTextField();
        modifica_partidos = new javax.swing.JTextField();
        modificar_liga = new javax.swing.JButton();
        nombre_LIGA1 = new javax.swing.JLabel();
        pais_texto1 = new javax.swing.JLabel();
        equipos_texto1 = new javax.swing.JLabel();
        partidos_texto1 = new javax.swing.JLabel();

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
        coger_nombreEquipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_nombreEquipoMouseClicked(evt);
            }
        });

        nombreEquipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEquipo.setText("Nombre");

        nombreCiudad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreCiudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreCiudad.setText("Ciudad");

        coger_nombreCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nombreCiudad.setText("Ciudad");
        coger_nombreCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_nombreCiudadMouseClicked(evt);
            }
        });

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
        coger_anno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_annoMouseClicked(evt);
            }
        });

        a_favor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        a_favor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        a_favor.setText("Goles a favor");

        coger_aFavor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_aFavor.setText("a favor");
        coger_aFavor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_aFavorMouseClicked(evt);
            }
        });

        en_contra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        en_contra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        en_contra.setText("Goles en contra");

        coger_enContra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_enContra.setText("en contra");
        coger_enContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_enContraMouseClicked(evt);
            }
        });

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
        coger_nombrePresidente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_nombrePresidenteMouseClicked(evt);
            }
        });

        coger_nombreEstadio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nombreEstadio.setText("Estadio");
        coger_nombreEstadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_nombreEstadioMouseClicked(evt);
            }
        });

        coger_nombreJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nombreJugador.setText("Nombe Jugador");
        coger_nombreJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_nombreJugadorMouseClicked(evt);
            }
        });

        nombreJugador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreJugador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreJugador.setText("Nombre");

        coger_posicion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_posicion.setText("Posición");
        coger_posicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_posicionMouseClicked(evt);
            }
        });

        nombrePosicon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombrePosicon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrePosicon.setText("Posición");

        coger_nacionalidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nacionalidad.setText("Nacionalidad");
        coger_nacionalidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_nacionalidadMouseClicked(evt);
            }
        });

        nombrenacionalidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombrenacionalidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombrenacionalidad.setText("Nacionalidad");

        nombreTeam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreTeam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreTeam.setText("Nombre Equipo");

        insertar_jugador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertar_jugador.setText("Insertar jugador");
        insertar_jugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_jugadorActionPerformed(evt);
            }
        });

        coger_nombreLiga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_nombreLiga.setText("Nombre Liga");
        coger_nombreLiga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_nombreLigaMouseClicked(evt);
            }
        });

        nombre_LIGA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombre_LIGA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre_LIGA.setText("Nombre Liga");

        coger_pais.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_pais.setText("Pais");
        coger_pais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_paisMouseClicked(evt);
            }
        });

        pais_texto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pais_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pais_texto.setText("Pais");

        coger_equipos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_equipos.setText("Nº Equipos");
        coger_equipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_equiposMouseClicked(evt);
            }
        });

        equipos_texto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        equipos_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipos_texto.setText("Número Equipos");

        coger_partidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coger_partidos.setText("Nº Partidos");
        coger_partidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coger_partidosMouseClicked(evt);
            }
        });

        partidos_texto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        partidos_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partidos_texto.setText("Número Partidos");

        insertar_liga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertar_liga.setText("Insertar Liga");
        insertar_liga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertar_ligaActionPerformed(evt);
            }
        });

        pelota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ligas.jpg"))); // NOI18N

        ligas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/balon.jpg"))); // NOI18N

        datos_tabla_insertar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        datos_tabla_insertar.setText("INSERTAR DATOS DE LA TABLA");
        datos_tabla_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datos_tabla_insertarActionPerformed(evt);
            }
        });

        modifica_nombreLiga.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        modifica_pais.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        modifica_equipos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        modifica_partidos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        modificar_liga.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        modificar_liga.setText("Modificar Liga");
        modificar_liga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_ligaActionPerformed(evt);
            }
        });

        nombre_LIGA1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombre_LIGA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombre_LIGA1.setText("Nombre Liga");

        pais_texto1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pais_texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pais_texto1.setText("Pais");

        equipos_texto1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        equipos_texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipos_texto1.setText("Número Equipos");

        partidos_texto1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        partidos_texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        partidos_texto1.setText("Número Partidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jugadores_consultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equipos_consultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ligas_consultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_texto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coger_id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jugadores_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombreEquipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coger_nombreEquipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombreCiudad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coger_nombreCiudad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(coger_nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nombrePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(coger_nombrePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombreJugador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coger_nombreJugador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(nombrePosicon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(coger_posicion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coger_nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombrenacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cogerEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombreTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(coger_enContra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(insertar_jugador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ligas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreLiga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cogerLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insertar_equipoBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pelota, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nombre_LIGA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coger_nombreLiga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pais_texto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coger_pais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(equipos_texto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coger_equipos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(partidos_texto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(coger_partidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertar_liga, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(modifica_nombreLiga, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(nombre_LIGA1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(pais_texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(equipos_texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(modifica_pais, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(modifica_equipos, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(datos_tabla_insertar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(partidos_texto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modifica_partidos, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificar_liga, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jugadores_consultar)
                        .addComponent(equipos_consultar)
                        .addComponent(ligas_consultar)
                        .addComponent(id_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(coger_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jugadores_eliminar))
                    .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(coger_nombreEstadio))
                    .addComponent(nombreEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coger_anno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coger_nombrePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(en_contra, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(a_favor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(coger_aFavor)
                                    .addComponent(coger_enContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(nombrePresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fundado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cogerLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(insertar_equipoBoton)))
                            .addComponent(nombreLiga, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(nombreCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coger_nombreEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coger_nombreCiudad))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreTeam, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cogerEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(insertar_jugador)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nombrePosicon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nombrenacionalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coger_nacionalidad)
                                    .addComponent(coger_nombreJugador)
                                    .addComponent(coger_posicion))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(partidos_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(insertar_liga)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(coger_partidos)
                                        .addGap(1, 1, 1))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nombre_LIGA, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(coger_nombreLiga, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pais_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(equipos_texto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(coger_equipos)
                                        .addComponent(coger_pais)))))
                        .addGap(17, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ligas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pelota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datos_tabla_insertar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre_LIGA1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(equipos_texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(partidos_texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pais_texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar_liga)
                            .addComponent(modifica_partidos)
                            .addComponent(modifica_equipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifica_pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifica_nombreLiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))))
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
        JOptionPane.showMessageDialog(null, "Jugador eliminado correctamente");
    }//GEN-LAST:event_jugadores_eliminarActionPerformed

    private void coger_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_idMouseClicked
        coger_id.setText("");
    }//GEN-LAST:event_coger_idMouseClicked

    private void insertar_equipoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_equipoBotonActionPerformed
        gc.insertarEquipo(coger_nombreEquipo.getText(), coger_nombreCiudad.getText(),
                coger_nombreEstadio.getText(), coger_nombrePresidente.getText(), coger_anno.getText(),
                coger_aFavor.getText(), coger_enContra.getText(), (String) cogerLiga.getSelectedItem());
        equipos_consultarActionPerformed(evt);
        error.setText(gc.cadena_resultado);
        JOptionPane.showMessageDialog(null, "Equipo insertado correctamente");
        llenarEquipo();
    }//GEN-LAST:event_insertar_equipoBotonActionPerformed

    private void coger_nombreEquipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_nombreEquipoMouseClicked
        coger_nombreEquipo.setText("");
    }//GEN-LAST:event_coger_nombreEquipoMouseClicked

    private void coger_nombreCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_nombreCiudadMouseClicked
        coger_nombreCiudad.setText("");
    }//GEN-LAST:event_coger_nombreCiudadMouseClicked

    private void coger_nombreEstadioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_nombreEstadioMouseClicked
        coger_nombreEstadio.setText("");
    }//GEN-LAST:event_coger_nombreEstadioMouseClicked

    private void coger_nombrePresidenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_nombrePresidenteMouseClicked
        coger_nombrePresidente.setText("");
    }//GEN-LAST:event_coger_nombrePresidenteMouseClicked

    private void coger_annoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_annoMouseClicked
        coger_anno.setText("");
    }//GEN-LAST:event_coger_annoMouseClicked

    private void coger_aFavorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_aFavorMouseClicked
        coger_aFavor.setText("");
    }//GEN-LAST:event_coger_aFavorMouseClicked

    private void coger_enContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_enContraMouseClicked
        coger_enContra.setText("");
    }//GEN-LAST:event_coger_enContraMouseClicked

    private void coger_nombreJugadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_nombreJugadorMouseClicked
        coger_nombreJugador.setText("");
    }//GEN-LAST:event_coger_nombreJugadorMouseClicked

    private void coger_posicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_posicionMouseClicked
        coger_posicion.setText("");
    }//GEN-LAST:event_coger_posicionMouseClicked

    private void coger_nacionalidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_nacionalidadMouseClicked
        coger_nacionalidad.setText("");
    }//GEN-LAST:event_coger_nacionalidadMouseClicked

    private void insertar_jugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_jugadorActionPerformed
        gc.insertarJugador(coger_nombreJugador.getText(), coger_posicion.getText(), coger_nacionalidad.getText(), (String) cogerEquipo.getSelectedItem());
        jugadores_consultarActionPerformed(evt);
        error.setText(gc.cadena_resultado);
        JOptionPane.showMessageDialog(null, "Jugador insertado correctamente");
    }//GEN-LAST:event_insertar_jugadorActionPerformed

    private void coger_nombreLigaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_nombreLigaMouseClicked
        coger_nombreLiga.setText("");
    }//GEN-LAST:event_coger_nombreLigaMouseClicked

    private void coger_paisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_paisMouseClicked
        coger_pais.setText("");
    }//GEN-LAST:event_coger_paisMouseClicked

    private void coger_equiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_equiposMouseClicked
        coger_equipos.setText("");
    }//GEN-LAST:event_coger_equiposMouseClicked

    private void coger_partidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coger_partidosMouseClicked
        coger_partidos.setText("");
    }//GEN-LAST:event_coger_partidosMouseClicked

    private void insertar_ligaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertar_ligaActionPerformed
        gc.insertarliga(coger_nombreLiga.getText(), coger_pais.getText(), coger_equipos.getText(), coger_partidos.getText());
        ligas_consultarActionPerformed(evt);
        error.setText(gc.cadena_resultado);
        JOptionPane.showMessageDialog(null, "Liga insertada correctamente");
        llenarLiga();
    }//GEN-LAST:event_insertar_ligaActionPerformed

    private void datos_tabla_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datos_tabla_insertarActionPerformed

        modifica_nombreLiga.setText(datos.getValueAt(datos.getSelectedRow(), 0).toString());
        modifica_pais.setText(datos.getValueAt(datos.getSelectedRow(), 1).toString());
        modifica_equipos.setText(datos.getValueAt(datos.getSelectedRow(), 2).toString());
        modifica_partidos.setText(datos.getValueAt(datos.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_datos_tabla_insertarActionPerformed

    private void modificar_ligaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_ligaActionPerformed
        gc.modificarLiga(modifica_nombreLiga.getText(), modifica_pais.getText(), modifica_equipos.getText(), modifica_partidos.getText());
        ligas_consultarActionPerformed(evt);
        error.setText(gc.cadena_resultado);
        JOptionPane.showMessageDialog(null, "Liga modificada correctamente");
        llenarLiga();
    }//GEN-LAST:event_modificar_ligaActionPerformed

    GestorConexion gc = new GestorConexion();

    public void llenarLiga() {
        try {

            Statement sta = gc.conn1.createStatement();
            ResultSet rs = sta.executeQuery("SELECT nombre FROM liga ORDER BY nombre ASC ");
            cogerLiga.removeAllItems();
            while (rs.next()) {
                cogerLiga.addItem(rs.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void llenarEquipo() {
        try {

            Statement sta = gc.conn1.createStatement();
            ResultSet rs = sta.executeQuery("SELECT nombre FROM equipo ORDER BY nombre  ASC ");
            cogerEquipo.removeAllItems();
            while (rs.next()) {
                cogerEquipo.addItem(rs.getString(1));
            }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

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
    private javax.swing.JComboBox<String> cogerEquipo;
    private javax.swing.JComboBox<String> cogerLiga;
    private javax.swing.JTextField coger_aFavor;
    private javax.swing.JTextField coger_anno;
    private javax.swing.JTextField coger_enContra;
    private javax.swing.JTextField coger_equipos;
    private javax.swing.JTextField coger_id;
    private javax.swing.JTextField coger_nacionalidad;
    private javax.swing.JTextField coger_nombreCiudad;
    private javax.swing.JTextField coger_nombreEquipo;
    private javax.swing.JTextField coger_nombreEstadio;
    private javax.swing.JTextField coger_nombreJugador;
    private javax.swing.JTextField coger_nombreLiga;
    private javax.swing.JTextField coger_nombrePresidente;
    private javax.swing.JTextField coger_pais;
    private javax.swing.JTextField coger_partidos;
    private javax.swing.JTextField coger_posicion;
    private javax.swing.JTable datos;
    private javax.swing.JButton datos_tabla_insertar;
    private javax.swing.JLabel en_contra;
    private javax.swing.JButton equipos_consultar;
    private javax.swing.JLabel equipos_texto;
    private javax.swing.JLabel equipos_texto1;
    private javax.swing.JLabel error;
    private javax.swing.JLabel fundado;
    private javax.swing.JLabel id_texto;
    private javax.swing.JButton insertar_equipoBoton;
    private javax.swing.JButton insertar_jugador;
    private javax.swing.JButton insertar_liga;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jugadores_consultar;
    private javax.swing.JButton jugadores_eliminar;
    private javax.swing.JLabel ligas;
    private javax.swing.JButton ligas_consultar;
    private javax.swing.JTextField modifica_equipos;
    private javax.swing.JTextField modifica_nombreLiga;
    private javax.swing.JTextField modifica_pais;
    private javax.swing.JTextField modifica_partidos;
    private javax.swing.JButton modificar_liga;
    private javax.swing.JLabel nombreCiudad;
    private javax.swing.JLabel nombreEquipo;
    private javax.swing.JLabel nombreEstadio;
    private javax.swing.JLabel nombreJugador;
    private javax.swing.JLabel nombreLiga;
    private javax.swing.JLabel nombrePosicon;
    private javax.swing.JLabel nombrePresidente;
    private javax.swing.JLabel nombreTeam;
    private javax.swing.JLabel nombre_LIGA;
    private javax.swing.JLabel nombre_LIGA1;
    private javax.swing.JLabel nombrenacionalidad;
    private javax.swing.JLabel pais_texto;
    private javax.swing.JLabel pais_texto1;
    private javax.swing.JLabel partidos_texto;
    private javax.swing.JLabel partidos_texto1;
    private javax.swing.JLabel pelota;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
