
package Modelo;


public class libros {
    
  private String titulo;
  private String editorial;
  private String aut_nombre;
  

    public libros() {
    }

    public libros(String titulo, String editorial, String aut_nombre) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.aut_nombre = aut_nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAut_nombre() {
        return aut_nombre;
    }

    public void setAut_nombre(String aut_nombre) {
        this.aut_nombre = aut_nombre;
    }

   
    
  
}
