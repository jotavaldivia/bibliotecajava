package Controlador;
import java.sql.*;

public class Editorial {
 control_conexion con=new control_conexion(); 
  
  public Editorial (){
    this.con = new control_conexion();
  } 
 /*Añade un nuevo registro*/
   public void Nuevaeditorial(String editorial){
       try {  
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("insert into " + 
                    "editoriales(editorial) " +
                    " values(?)");            
            pstm.setString(1, editorial);
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
         con.cerrar();
      }
   }

 /*obtenemos todos los datos de la tabla*/
 public Object [][] getDatos(){
      int x = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{   
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM editoriales ");
         ResultSet res = pstm.executeQuery();
         res.next();
         x = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
         con.cerrar();
      }
      
    Object[][] s = new String[x][2];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
            " cod_edit, editorial " +
            " FROM editoriales" +
            " ORDER BY cod_edit ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estCodigo = res.getString("cod_edit");
            String estEditorial = res.getString("editorial");
            s[i][0] = estCodigo;            
            s[i][1] = estEditorial;            
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
      con.cerrar();
    return s;
 }

 
 public void Actualizareditorial(String codigo, String editorial){
       try {    
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("update editoriales " +
            "set editorial = ? " +
            "where cod_edit = ? ");           
            pstm.setString(0, codigo);                   
            pstm.setString(1, editorial);
            //pstm.setString(1, String.valueOf(codigo));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
         con.cerrar();
      }
   }
//Eliminar Ciudad
public void eliminareditorial(String cod){  
            try { 
                con.conectar();
                PreparedStatement aaa = con.estado().prepareStatement("delete from autores where cod_edit = ?");            
                aaa.setString(1, cod);
                aaa.execute();
                aaa.close();            
            }catch(SQLException e){
            System.out.println(e);
            }  
            con.cerrar();
   }

    
}
