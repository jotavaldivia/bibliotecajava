/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Control.control_personas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jota
 */
public class Servlet_Personas extends HttpServlet {
     control_personas per = new control_personas();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           //Capturar p desde cliente
            int p=Integer.parseInt(request.getParameter("p"));
            //Objeto para direccionamiento
            RequestDispatcher rd;
            switch(p){
                case 1:
                    per.setNombres(request.getParameter("usu"));
                    per.setPassword(request.getParameter("pass"));
                    if(per.verificar()){
                    //   Crear variables de Session
                        request.getSession().setAttribute("nombre",
                              per.getNombres()+" "+
                              per.getApellidos());
                        response.sendRedirect("inicio.jsp");
                    }else
                       response.sendRedirect("index.jsp?error=Usuario o Password Incorrecto");
                break;
                case 2:
                    //Cerrar sesión
                    request.getSession().invalidate();
                    response.sendRedirect("index.jsp");
                break;
                case 3:
                    if(request.getParameter("v4").equals(
                            request.getParameter("v5"))){
                        per.setNombres(request.getParameter("v1"));
                        per.setApellidos(request.getParameter("v2"));
                        per.setUsuario(request.getParameter("v3"));
                        per.setPassword(request.getParameter("v4"));
                      //  per.setPre_codigo(request.getParameter("v6"));
                        per.setRespuesta(request.getParameter("v7"));
                        //Grabar datos
                       // per.crear_cuenta();
                         rd=request.getRequestDispatcher("index.jsp");
                        rd.forward(request, response);
                    }else{
                        //error, password no son iguales
                         rd=request.getRequestDispatcher(
                         "recuperar.jsp?error=Password y Confirmación no son iguales");
                        rd.forward(request, response);
                    }
                break;
                case 4:
                    if(per.mostrar_pregunta(request.getParameter("v1"))){
                        rd=
                                request.getRequestDispatcher(
                                "cambiar_password.jsp?pre="+per.pregunta);
                        rd.forward(request, response);
                        //response.sendRedirect("cambiar_password.jsp?pre="+per.pregunta);
                    }else{
                        rd=
                                request.getRequestDispatcher(
                                "recuperar.jsp?error=Usuario no encontrado");
                        rd.forward(request, response);
                    }
                        
                break;
                case 5:
                    if(request.getParameter("v3").equals(
                            request.getParameter("v4"))){
                        
                        if(request.getParameter("v2").equals(per.respuesta)){
                            per.cambiar_password(request.getParameter("v3"));
                            response.sendRedirect("index.jsp");
                        }else{
                            rd=
                            request.getRequestDispatcher(
                            "cambiar_password.jsp?error=Respuesta incorrecta&pre="+per.pregunta);
                        rd.forward(request, response);
                        }
                    }else{
                        rd=
                            request.getRequestDispatcher(
                            "cambiar_password.jsp?error=Password no son iguales&pre="+per.pregunta);
                        rd.forward(request, response);
                    }
                break;
                case 6:
                    //Direccionar recuperar password
                    rd=request.getRequestDispatcher("recuperar.jsp");
                    rd.forward(request, response);
                break;
                case 7:
                    //Crear un atributo de session con las preguntas
                    request.setAttribute("preguntas",per.lista_preguntas());
                    //Direccionar registrate
                    rd=request.getRequestDispatcher("registrate.jsp");
                    rd.forward(request, response);
                break;  
                case 8:
                    if(per.mostrar_pregunta(request.getParameter("v1"))){
                        rd=
                                request.getRequestDispatcher(
                                "cambiar_nick.jsp?pre="+per.pregunta);
                        rd.forward(request, response);
                        //response.sendRedirect("cambiar_password.jsp?pre="+per.pregunta);
                    }else{
                        rd=
                                request.getRequestDispatcher(
                                "actualizar_nick.jsp?error=Usuario no encontrado");
                        rd.forward(request, response);
                    }
                        
                break;
                case 9:
                    if(request.getParameter("v3").equals(
                            request.getParameter("v4"))){
                        
                        if(request.getParameter("v2").equals(per.respuesta)){
                            per.cambiar_nombre(request.getParameter("v3"));
                            response.sendRedirect("index.jsp");
                        
                        }else{
                            rd=
                            request.getRequestDispatcher(
                            "cambiar_nick.jsp?error=Respuesta incorrecta&pre="+per.pregunta);
                        rd.forward(request, response);
                        }
                    }else{
                        rd=
                            request.getRequestDispatcher(
                            "cambiar_nick.jsp?error=Password no son iguales&pre="+per.pregunta);
                        rd.forward(request, response);
                    }
                break;
                case 10:
                    //Direccionar recuperar password
                    rd=request.getRequestDispatcher("actualizar_nick.jsp");
                    rd.forward(request, response);
                break;  
                case 11:
                  //Crear un atributo de session con las preguntas
                //    request.setAttribute("lista",per.listar_personas());
                    //Direccionar registrate
                    rd=request.getRequestDispatcher("libros.jsp");
                    rd.forward(request, response);  
                    
                    
                break;
                    
                    case 12:
                    //eliminar datos de tabla usuario
                    request.setAttribute("preguntas",per.eliminar_usuario(null));
                    //Direccionar registrate
                    rd=request.getRequestDispatcher("registrate.jsp");
                    rd.forward(request, response);
                break;  
                 
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

