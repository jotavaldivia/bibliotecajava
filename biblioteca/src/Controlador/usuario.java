package Controlador;
import java.sql.*;

public class usuario {
 control_conexion con;
 
 public usuario(){
        this.con = new control_conexion();
    
  } 
 /*Añade un nuevo registro*/
   public void nuevousuario(String rut, String nombre, String apellido, String direccion, String telefono,String pass, String correo){
       try {     
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("insert into " + 
            "usuarios(usu_rut, usu_nombre, usu_apellido, usu_direccion, usu_telefono,usu_pass,usu_correo) " +
            " values(?,?,?,?,?,?,?)");
            pstm.setString(1, rut);
            pstm.setString(2, nombre);
            pstm.setString(3, apellido);
            pstm.setString(4, direccion);
            pstm.setString(5, telefono);
             pstm.setString(6, pass);
             pstm.setString(7, correo);
            
            
            
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
         PreparedStatement pstm = con.estado().prepareStatement("SELECT count(1) as total FROM usuarios ");
         ResultSet res = pstm.executeQuery();
         res.next();
         x = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
         con.cerrar();
      }
      
    Object[][] s = new String[x][7];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
          con.conectar();
         PreparedStatement pstm = con.estado().prepareStatement("SELECT " +
            " usu_rut, usu_nombre, usu_apellido, usu_direccion, usu_telefono,usu_pass, usu_correo" +
            " FROM usuarios" +
            " ORDER BY usu_rut ");
         
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String estCodigo = res.getString("usu_rut");
            String estNombre = res.getString("usu_nombre");
            String estapellido = res.getString("usu_apellido");
            String estDireccion = res.getString("usu_direccion");
            String estTelefono = res.getString("usu_telefono");
            String estpass = res.getString("usu_pass");
               String estcorreo = res.getString("usu_correo");
            
            s[i][0] = estCodigo;            
            s[i][1] = estNombre;            
            s[i][2] = estapellido;
            s[i][3] = estDireccion;
            s[i][4] = estTelefono;
             s[i][5] = estpass;
              s[i][6] = estcorreo;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
      con.cerrar();
    return s;
    
 }

 
 public void ActualizarPersona(String codigo, String nombre, String direccion, String telefono, String ciudad,String pass, String correo){
       try {    
           con.conectar();
            PreparedStatement pstm = con.estado().prepareStatement("update usuarios " +
            " set usu_rut= ? "+
            " usu_nombre = ? " +
            " usu_apellido = ? " +
            " usu_direccion = ?"+
            " usu_telefono= ?"+
            " usu_pass= ?"+
            " usu_correo= ?"+
            " where usu_rut = ? ");           
            pstm.setString(0, codigo);                   
            pstm.setString(1, nombre);
            pstm.setString(2, direccion);
            pstm.setString(3, telefono);
            pstm.setString(4, ciudad);
               pstm.setString(5, pass);
                pstm.setString(6, correo);
            //pstm.setString(1, String.valueOf(codigo));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
       con.cerrar();
   }
//Eliminar Ciudad
public void eliminarPersona(String cod){  
            try {       
                con.conectar();
                PreparedStatement aaa = con.estado().prepareStatement("delete from usuarios where usu_rut = ?");            
                aaa.setString(1, cod);
                aaa.execute();
                aaa.close();            
            }catch(SQLException e){
            System.out.println(e);
            }    
            con.cerrar();
   }

}

