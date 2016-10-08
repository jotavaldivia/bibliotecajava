package Controlador;
import java.sql.*;
import javax.swing.JOptionPane;

public class devolucion {

    control_conexion con=new control_conexion();
    
    public devolucion (){
    this.con = new control_conexion();
  } 
 /*Añade un nuevo registro*/
   public void Nuevadevolucion(String codigotrans, String fechaprestamo, String fechadevolucion  ){
       try {       
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("insert into " + 
                    "devolucion(cod_trans, fechaprestamo, fechadevolucion) " +
                    " values(?,?,?)");            
            pstm.setString(1, codigotrans);
            pstm.setString(2, fechaprestamo);
            pstm.setString(3, fechadevolucion);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }

 /*obtenemos todos los datos de la tabla*/
 public Object [][] getDatos(){
      int x = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{        
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM devolucion ");
         ResultSet res = pstm.executeQuery();
         res.next();
         x = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] s = new String[x][3];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
            " tra.cod_trans, dev.fechaprestamo, dev.fechadevolucion " +
            " FROM devolucion dev " +
            " LEFT JOIN transacciones tra on  dev.cod_trans = tra.cod_trans " +
            " ORDER BY dev.cod_trans  ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estcodigotra = res.getString("tra.cod_trans");
            String estfechaprestamo = res.getString("dev.fechaprestamo");
            String estfechadevolucion = res.getString("dev.fechadevolucion");
            s[i][0] = estcodigotra;            
            s[i][1] = estfechaprestamo;    
            s[i][2] = estfechadevolucion;

            
            i++;

         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return s;
 }
 
//Eliminar Ciudad
public void eliminardevolucion(String cod){  
            try {   
                con.conectar();
                PreparedStatement aaa = con.estado().prepareStatement("delete from devolucion where cod_trans = ?");            
                aaa.setString(1, cod);
               aaa.execute();
                aaa.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

}
