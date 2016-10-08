package Modelo;
public class personas {
    private String usuario;
    private String password;
    public String nombres;
    private String apellidos;
    private String respuesta;
    private String libros;
    //Constructor
    public personas() {
    }

    public personas(String usuario, String libros, String nombres, String apellidos, String respuesta, String pre_pregunta) {
       // super(pre_pregunta);
        this.usuario = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.respuesta = respuesta;
        this.libros = libros;
    }

    public String getLibros() {
        return libros;
    }

    public void setLibros(String libros) {
        this.libros = libros;
    }

    //Mutadores
    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

  public void setUsuario(String usuario) {
        this.usuario = usuario;
   }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
            

}
