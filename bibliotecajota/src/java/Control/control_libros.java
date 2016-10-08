/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.libros;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jota
 */
public class control_libros extends libros{
    control_conexion con=new control_conexion();
      
    //listar libros
   
    public ArrayList listar_libros(){
    ArrayList<libros> lista = new ArrayList<>();
    try {
        con.conectar();
     PreparedStatement datos = con.estado().
           prepareStatement
         ("SELECT titulo,editorial,aut_nombre FROM libros "+
           "INNER JOIN autores "+
           "ON (libros.cod_aut = autores.cod_aut)"+
                 "INNER JOIN editoriales "+
           "ON (libros.cod_edit = editoriales.cod_edit)");
     
      ResultSet res = datos.executeQuery();
              
       while(res.next()){
       lista.add(new libros(res.getString("titulo"),
                              res.getString("editorial"),
                              res.getString("aut_nombre")));
       
       }
     con.cerrar();
        
    }catch(SQLException e ){
        System.out.println("Error: "+ e);
    
    }
    
    return lista;
    }
    
    public ArrayList listar_prestamos(){
    ArrayList<libros> lista = new ArrayList<>();
    try {
        con.conectar();
     PreparedStatement datos = con.estado().
           prepareStatement
         ("SELECT titulo,editorial,aut_nombre FROM libros "+
           "INNER JOIN autores "+
           "ON (libros.cod_aut = autores.cod_aut)"+
                 "INNER JOIN editoriales "+
           "ON (libros.cod_edit = editoriales.cod_edit)");
     
      ResultSet res = datos.executeQuery();
              
       while(res.next()){
       lista.add(new libros(res.getString("titulo"),
                              res.getString("editorial"),
                              res.getString("aut_nombre")));
       
       }
     con.cerrar();
        
    }catch(SQLException e ){
        System.out.println("Error: "+ e);
    
    }
    
    return lista;
    }
}
