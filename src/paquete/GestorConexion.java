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
            String url1 = "jdbc:mysql://localhost:3306/disco?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "root";
            conn1 = DriverManager.getConnection(url1, user, password);

            if (conn1 != null) {
                System.out.println("Conectado a disco…");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: dirección o usuario/clave no válida");
            ex.printStackTrace();
        }
    }

    public void annadirColumna(String caratula) {
        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();

            sta.executeUpdate("ALTER TABLE album ADD " + caratula + " VARCHAR(30)");

            sta.close();

            conn1.commit();

            System.out.println("has añadido una columna");
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
            String query = "SELECT * FROM album ";
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

    public void insertarAlbumNuevo(String id_Album, String titulo_Album, String publicacion, String artistaa) {
        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();

            sta.executeUpdate("INSERT INTO album VALUES('" + id_Album + "', '" + titulo_Album + "', '" + publicacion + "', '" + artistaa + "')");

            System.out.println("insertado album correctamente");

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

    public void cancionNueva(String id, String nombre, String duracion, String letra, String id_album) {
        try {
            conn1.setAutoCommit(false);

            Statement sta = conn1.createStatement();

            sta.executeUpdate("INSERT INTO cancion VALUES('" + id + "', '" + nombre + "', '" + duracion + "', '" + letra + "', '" + id_album + "')");

            System.out.println("insertado cancion correctamente");

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
}
