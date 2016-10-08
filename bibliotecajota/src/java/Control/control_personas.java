package Control;
import Modelo.personas;
import Modelo.preguntas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class control_personas extends personas{
    //Instancia a control_conexion
            control_conexion con=new control_conexion();
    public String pregunta,respuesta,usuario;

   
    //Lista de Preguntas
    public ArrayList lista_preguntas(){
    //Crear ArrayList de Preguntas
        ArrayList<preguntas> lista=new ArrayList<>();
        try{
            con.conectar();
            PreparedStatement datos=
                    con.estado().prepareStatement(
                            "SELECT * FROM preguntas");
            ResultSet res=datos.executeQuery();
            while(res.next()){
                
                lista.add(new preguntas(
                        res.getString("pre_codigo"),
                        res.getString("pre_pregunta")));
            }
            con.cerrar();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
        
    public boolean cambiar_password(String password){
        System.out.println("UPDATE personas SET "
                         + "per_password='"+password+"' WHERE "
                         + "per_usuario='"+usuario+"'");
        try{
            con.conectar();
            PreparedStatement datos=
                 con.estado().prepareStatement("UPDATE personas SET "
                         + "per_password='"+password+"' WHERE "
                         + "per_usuario='"+usuario+"'");
            //Ejecutas SQL (commit -- Insert Update Delete)
            datos.execute();
            con.cerrar();
               return true;
           
        }catch(SQLException error){
            System.out.println("Error: "+error);
        }
        return false;
    }
        public boolean actualizar_usuario(String usuario){
        System.out.println("UPDATE personas SET "
                         + "per_usuario='"+usuario+"'WHERE per_usuario='"+this.usuario+"'");
     //  UPDATE  `aiep1`.`personas` SET  `per_usuario` =  'scontreras' WHERE CONVERT
       //   `personas`.`per_usuario` USING utf8 ) =  'scontrera' LIMIT 1 ;                 
        try{
            con.conectar();
            PreparedStatement datos=
                 con.estado().prepareStatement("UPDATE personas SET "
                         + "per_usuario='"+usuario+"'WHERE per_usuario='"+this.usuario+"'");
                         
            //Ejecutas SQL (commit -- Insert Update Delete)
            datos.execute();
            con.cerrar();
               return true;
            
        }catch(SQLException error){
            System.out.println("Error: "+error);
        }
        return false;
    }
        
        
      /////////////////////////  
       
      public boolean cambiar_nombre(String nombre){
        System.out.println("UPDATE personas SET "
                         + "per_nombre='"+ nombre+"' WHERE "
                         + "per_usuario='"+usuario+"'");
        try{
            con.conectar();
            PreparedStatement datos=
                 con.estado().prepareStatement("UPDATE personas SET "
                         + "per_nombre='"+ nombre+"' WHERE "
                         + "per_usuario='"+usuario+"'");
            //Ejecutas SQL (commit -- Insert Update Delete)
            datos.execute();
            con.cerrar();
               return true;
           
        }catch(SQLException error){
            System.out.println("Error: "+error);
        }
        return false;
    }
        
        ///////////////////////////////////
        public boolean eliminar_usuario(String usuario){
        System.out.println("DELETE personas SET "
                         + "per_usuario='"+usuario+"'WHERE per_usuario='"+this.usuario+"'");
        //UPDATE  `aiep1`.`personas` SET  `per_usuario` =  'scontreras' WHERE CONVERT
        //(  `personas`.`per_usuario` USING utf8 ) =  'scontrera' LIMIT 1 ;                 
        try{
            con.conectar();
            PreparedStatement datos=
                 con.estado().prepareStatement("UPDATE personas SET "
                         + "per_usuario='"+usuario+"'WHERE per_usuario='"+this.usuario+"'");
                         
            //Ejecutas SQL (commit -- Insert Update Delete)
            datos.execute();
            con.cerrar();
               return true;
            
        }catch(SQLException error){
            System.out.println("Error: "+error);
        }
        return false;
    }
    
    public boolean mostrar_pregunta(String usuario){
        try{
            
            con.conectar();
            PreparedStatement datos=
                 con.estado().prepareStatement("SELECT pre_pregunta, "
                         + "per_respuesta FROM personas "
                         + "INNER JOIN preguntas "
                         + "ON (personas.pre_codigo=preguntas.pre_codigo) "
                         + "WHERE per_usuario='"+usuario+"'");
            //Ejecutas SQL ResiltSet
            ResultSet res=datos.executeQuery();
            con.cerrar();
            if(res.next()){
                pregunta=res.getString("pre_pregunta");
                respuesta=res.getString("per_respuesta");
                System.out.println("Respuesta: "+respuesta);
                this.usuario=usuario;
                return true;
            }
        }catch(SQLException error){
            System.out.println("Error: "+error);
        }
        return false;
    }
    
    //control de acceso al sistema
    public boolean verificar(){
        try {
           
            con.conectar();
            PreparedStatement sql=
                    con.estado().prepareStatement(""
                            +"SELECT usu_nombre,usu_apellido FROM usuarios Where usu_nombre='"+
                            this.getNombres()+"' AND usu_pass='"
                            +this.getPassword()+"'");
            //rescatar los datos de la consulta sql
            ResultSet res=sql.executeQuery();
            if (res.next()) {
                this.setNombres(res.getString("usu_nombre"));
                this.setApellidos(res.getString("usu_apellido"));
                return true;
            }
            con.cerrar();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
}
