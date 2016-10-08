package Controlador;
import Controlador.control_conexion;
import java.sql.*;


public class transaccion {

    control_conexion con= new control_conexion();
    
    public transaccion (){
    this.con = new control_conexion();
  } 
 /*Añade un nuevo registro*/
   public void NuevaTransaccion(String fecha, String diasprestamo, String codigo_libro, String rut_usuario ){
       try {    
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("insert into " + 
                    "transacciones(fecha, diasprestamo, cod_lib, usu_rut) " +
                    " values(?,?,?,?)");            
            pstm.setString(1, fecha);
            pstm.setString(2, diasprestamo);
            pstm.setString(3, codigo_libro);
            pstm.setString(4, rut_usuario);
            
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
       con.cerrar();
   }

 /*obtenemos todos los datos de la tabla*/
 public Object [][] getDatos(){
      int x = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{     
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM transacciones ");
         ResultSet res = pstm.executeQuery();
         res.next();
         x = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
         con.cerrar();
      }
      
    Object[][] s = new String[x][5];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{   
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
            " tra.cod_trans, tra.fecha, tra.diasprestamo, li.cod_lib, usu.usu_rut  " +
            " FROM transacciones tra " +
            " LEFT JOIN libros li on  tra.cod_lib = li.cod_lib " +
            " LEFT JOIN usuarios usu on  tra.usu_rut = usu.usu_rut" +
            " ORDER BY tra.cod_trans  ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estcodigo = res.getString("tra.cod_trans");
            String estfecha = res.getString("tra.fecha");
            String estdiasp = res.getString("tra.diasprestamo");
            String estlibro = res.getString("li.cod_lib");
            String estusuario = res.getString("usu.usu_rut");
            
            s[i][0] = estcodigo;            
            s[i][1] = estfecha;    
            s[i][2] = estdiasp;
            s[i][3] = estlibro;
            s[i][4] = estusuario;
            
            i++;

         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
      con.cerrar();
    return s;
 }
 
//Eliminar Ciudad
public void eliminartransaccion(String cod){  
            try {         
                con.conectar();
                PreparedStatement aaa = con.estado().prepareStatement("delete from transacciones where cod_trans = ?");            
                aaa.setString(1, cod);
               aaa.execute();
                aaa.close();            
            }catch(SQLException e){
            System.out.println(e);
            }  
            con.cerrar();
   }


}
