
package Modelo;

/**
 *
 * @author jota
 */
public class devoluciones {
    
    private String fechaprestamo;
    private String fechadevolucion;
    private String Codigo;
    public devoluciones() {
    }

    public String getFechaprestamo() {
        return fechaprestamo;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }
    
    
}
