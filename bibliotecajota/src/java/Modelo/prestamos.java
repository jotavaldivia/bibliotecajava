
package Modelo;

/**
 *
 * @author jota
 */
public class prestamos {
   private String titulo;
    private String fechaprestamo;
     private String fechadevolucion;

  
    public prestamos() {
    }

   

    public prestamos(String titulo, String fechaprestamo, String fechadevolucion) {
        this.titulo = titulo;
        this.fechaprestamo = fechaprestamo;
        this.fechadevolucion = fechadevolucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolución) {
        this.fechadevolucion = fechadevolución;
    }
     
     
}
