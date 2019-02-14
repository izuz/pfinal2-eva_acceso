package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Gonzalo Izuzquiza
 */
public class GestorConexion {

    Connection conn1;
    String cadena_resultado = "";

    public GestorConexion() {

        conn1 = null;

        try {
            String url1 = "jdbc:mysql://localhost:3306/futbol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "root";
            conn1 = DriverManager.getConnection(url1, user, password);

            if (conn1 != null) {
                System.out.println("Conectado a futbol…");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: dirección o usuario/clave no válida");
            ex.printStackTrace();
        }
    }

    public void cerrar_conexion() {
        try {
            conn1.close();
            System.out.println("Conexion cerrada");

        } catch (SQLException ex) {
            System.err.println("Error al cerrar conexion");
            ex.printStackTrace();
        }
    }

    public String consultaStatement() {
        String fallo = "error";

        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();
            String query = "SELECT * FROM jugadores ";
            ResultSet rs = sta.executeQuery(query);
            ResultSetMetaData metaDatos = rs.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

            return cadena_resultado;

        } catch (Exception e) {
            System.out.println("Error");
            try {
                if (conn1 != null) {
                    conn1.rollback();
                }
            } catch (Exception se2) {
                se2.printStackTrace();
            }
            e.printStackTrace();
            return fallo;
        }
    }

    public void eliminarJugador(String coger_id) {
        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();

            sta.executeUpdate("DELETE FROM jugadores WHERE id_jugador like " + coger_id);

            sta.close();

            conn1.commit();
        } catch (Exception e) {
            System.out.println("Error");

            try {
                if (conn1 != null) {
                    conn1.rollback();
                }
            } catch (Exception se2) {
                se2.printStackTrace();
                cadena_resultado = se2.toString();
            }

            e.printStackTrace();
            cadena_resultado = e.toString();
        }
    }

    public void insertarEquipo(String nombre, String ciudad, String estadio, String presidente, String anno, String aFavor, String enContra, String liga) {

        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();

            sta.executeUpdate("INSERT INTO equipo VALUES('" + nombre + "', '" + ciudad + "', '" + estadio + "',"
                    + " '" + presidente + "', '" + anno + "', '" + aFavor + "', '" + enContra + "', '" + liga + "')");

            System.out.println("insertado equipo correctamente");

            sta.close();

            conn1.commit();
        } catch (Exception e) {
            System.out.println("Error");

            try {
                if (conn1 != null) {
                    conn1.rollback();
                }
            } catch (Exception se2) {
                se2.printStackTrace();
                cadena_resultado = se2.toString();
            }
            e.printStackTrace();
            cadena_resultado = e.toString();
        }
    }

    public void insertarJugador(String nombre, String posicion, String nacionalidad, String nombreEquipo) {
        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();

            sta.executeUpdate("INSERT INTO jugadores VALUES(NULL, '" + nombre + "', '" + posicion + "',"
                    + " '" + nacionalidad + "', '" + nombreEquipo + "')");

            System.out.println("insertado jugador correctamente");

            sta.close();

            conn1.commit();
        } catch (Exception e) {
            System.out.println("Error");

            try {
                if (conn1 != null) {
                    conn1.rollback();
                }
            } catch (Exception se2) {
                se2.printStackTrace();
                cadena_resultado = se2.toString();
            }
            e.printStackTrace();
            cadena_resultado = e.toString();
        }
    }

    public void insertarliga(String nombre, String pais, String numero_equipos, String numero_partidos) {
        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();

            sta.executeUpdate("INSERT INTO liga VALUES('" + nombre + "', '" + pais + "', '" + numero_equipos + "','" + numero_partidos + "')");

            System.out.println("insertada liga correctamente");

            sta.close();

            conn1.commit();
        } catch (Exception e) {
            System.out.println("Error");

            try {
                if (conn1 != null) {
                    conn1.rollback();
                }
            } catch (Exception se2) {
                se2.printStackTrace();
                cadena_resultado = se2.toString();
            }
            e.printStackTrace();
            cadena_resultado = e.toString();
        }
    }

    public void modificarLiga(String nombre, String pais, String numero_equipos, String numero_partidos) {
        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();

            sta.executeUpdate("UPDATE  liga SET nombre=('" + nombre + "'), pais=('" + pais + "'), numero_equipos=('" + numero_equipos + "'), numero_partidos=('" + numero_partidos + "') ");

            System.out.println("Liga modificada correctamente");

            sta.close();
        } catch (Exception e) {
            System.out.println("Error");

            try {
                if (conn1 != null) {
                    conn1.rollback();
                }
            } catch (Exception se2) {
                se2.printStackTrace();
                cadena_resultado = se2.toString();
            }
            e.printStackTrace();
            cadena_resultado = e.toString();
        }
    }

}
