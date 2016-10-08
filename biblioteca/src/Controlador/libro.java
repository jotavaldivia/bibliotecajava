package Controlador;
import Controlador.control_conexion;
import java.sql.*;

public class libro {

    control_conexion con= new control_conexion();
    
    public libro (){
    this.con = new control_conexion();
  } 
 /*Añade un nuevo registro*/
    public void nuevolibro(String titulo, String editorial, String autor){
       try {      
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("insert into " + 
            "libros(titulo, cod_edit, cod_aut) " +
            " values(?,?,?)");
            pstm.setString(1, titulo);
            pstm.setString(2, editorial);
            pstm.setString(3, autor);
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
         PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM libros ");
         ResultSet res = pstm.executeQuery();
         res.next();
         x = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
         con.cerrar();
      }
      
    Object[][] s = new String[x][4];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
            " li.cod_lib, li.titulo, e.cod_edit, a.cod_aut " +
            " FROM libros li " +
            " LEFT JOIN editoriales e on  li.cod_edit = e.cod_edit "+
            " LEFT JOIN autores a on  li.cod_aut = a.cod_aut "+
            " ORDER BY li.cod_lib ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estCodigo = res.getString("li.cod_lib");
            String esttitulo = res.getString("li.titulo");
            String esteditorial = res.getString("e.cod_edit");
            String estautor = res.getString("a.cod_aut");
            s[i][0] = estCodigo;            
            s[i][1] = esttitulo;            
            s[i][2] = esteditorial;
            s[i][3] = estautor;
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
public void eliminarlibro(String cod){  
            try {  
                con.conectar();
                PreparedStatement aaa = con.estado().prepareStatement("delete from libros where cod_lib = ?");            
                aaa.setString(1, cod);
               aaa.execute();
                aaa.close();            
            }catch(SQLException e){
            System.out.println(e);
            }  
            con.cerrar();
   }

}
