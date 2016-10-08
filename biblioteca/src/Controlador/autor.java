package Controlador;
import java.sql.*;

public class autor {
 control_conexion con=new control_conexion();
  
  public autor (){
    this.con = new control_conexion();
  } 
 /*Añade un nuevo registro*/
   public void Nuevoautor(String nombre, String pais){
       try {       
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("insert into " + 
                    "autores(aut_nombre, aut_pais) " +
                    " values(?,?)");            
            pstm.setString(1, nombre);
            pstm.setString(2, pais);
         
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
         PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM autores ");
         ResultSet res = pstm.executeQuery();
         res.next();
         x = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
         con.cerrar();
      }
      
    Object[][] s = new String[x][3];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{ 
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
            " cod_aut, aut_nombre, aut_pais " +
            " FROM autores" +
            " ORDER BY cod_aut ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estCodigo = res.getString("cod_aut");
            String estNombre = res.getString("aut_nombre");
            String estPais = res.getString("aut_pais");
            s[i][0] = estCodigo;            
            s[i][1] = estNombre;            
            s[i][2] = estPais;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
      con.cerrar();
    return s;
 }

 
 public void Actualizarautor(String codigo, String nombre, String pais){
       try {      
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("update autores " +
            "set aut_nombre = ? " +
            "aut_pais = ? " +
            "where cod_aut = ? ");           
            pstm.setString(0, codigo);                   
            pstm.setString(1, nombre);
            pstm.setString(2, pais);
            //pstm.setString(1, String.valueOf(codigo));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
       con.cerrar();
   }
//Eliminar Ciudad
public void eliminarautor(String cod){  
            try {  
                con.conectar();
                PreparedStatement aaa = con.estado().prepareStatement("delete from autores where cod_aut = ?");            
                aaa.setString(1, cod);
                aaa.execute();
                aaa.close();            
            }catch(SQLException e){
            System.out.println(e);
            } 
            con.cerrar();
   }

    
}
