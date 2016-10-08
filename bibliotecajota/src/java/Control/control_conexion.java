package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class control_conexion {
    private String usu;
    private String pass;
    private String url;
    //Atributo de tipo Conexion
    Connection con=null;

    //Constructor
    public control_conexion() {
        this.usu="root";
        this.pass="jota2015";
        this.url="jdbc:mysql://127.0.0.1/biblioteca";
    }
    //Conectar
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,
                    usu,pass);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al conectar");
        }
    }
    //Desconectar
    public void cerrar(){
        con=null;
    }
    //Estado de la conexión
    public Connection estado(){
        return con;
    }
}
