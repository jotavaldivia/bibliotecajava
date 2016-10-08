
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controlador.control_conexion;

/**
 *
 * @author jota
 */
import Modelo.personas;
public class control_personas extends personas{
    //control de acceso al sistema
    public boolean verificar(){
        try {
            control_conexion con=new control_conexion();
            con.conectar();
            PreparedStatement sql=
                    con.estado().prepareStatement(""
                            +"SELECT adm_nombre,adm_apellido FROM administradores Where adm_usuario='"+
                            this.getPer_usuraio()+"' AND adm_password='"
                            +this.getPer_password()+"'");
            //rescatar los datos de la consulta sql
            ResultSet res=sql.executeQuery();
            if (res.next()) {
                this.setPer_nombres(res.getString("adm_nombre"));
                this.setPer_apellidos(res.getString("adm_apellido"));
                return true;
            }
            con.cerrar();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
