/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.prestamos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Control.control_conexion;
import Modelo.personas;
/**
 *
 * @author jota
 */
public class control_prestamos extends prestamos {
    personas per=new personas();
   
    control_conexion con=new control_conexion();
    public ArrayList listar_prestamos() {
    ArrayList<prestamos> lista = new ArrayList<>();
    try {
        con.conectar();
     PreparedStatement datos = con.estado().
           prepareStatement
         ("SELECT titulo,fechaprestamo,fechadevolucion FROM devolucion "+
           "INNER JOIN transacciones "+
           "ON (devolucion.cod_trans = transacciones.cod_trans)"+
                 "INNER JOIN usuarios "+
           "ON (usuarios.usu_rut = transacciones.usu_rut)"+
          "INNER JOIN libros "+
           "ON (transacciones.cod_lib = libros.cod_lib)"+
         "WHERE usu_nombre='maicol'");
                
     
      ResultSet res = datos.executeQuery();
              
       while(res.next()){
       lista.add(new prestamos(res.getString("titulo"),
                              res.getString("fechaprestamo"),
                              res.getString("fechadevolucion")));
       
       }
  
        
    }catch(SQLException e ){
        System.out.println("Error: "+ e);
    
    }

    return lista;
    }
}
