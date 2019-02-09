package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Gonzalo Izuzquiza
 */
public class GestorConexion {

    Connection conn1;
    String cadena_resultado = "";
    static Statement sentencia;
    static ResultSet resultado;

    public GestorConexion() {

        conn1 = null;

        try {
            String url1 = "jdbc:mysql://localhost:3306/futbol?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "";
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

    public static ArrayList<String> llenarLigas() {

        ArrayList<String> lista = new ArrayList<String>();

        String consulta = "SELECT nombre_liga FROM equipo";

        try {
            resultado = sentencia.executeQuery(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            while (resultado.next()) {
                lista.add(resultado.getString("nombre_liga"));
            }
        } catch (Exception e) {
        }

        return lista;
    }
}
