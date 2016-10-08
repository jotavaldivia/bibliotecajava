package Modelo;

/**
 *
 * @author jota
 */
public class personas {
    //atributos
    private String per_usuraio;
    private String per_password;
    private String per_nombres;
    private String per_apellidos;
    //contructor

    public personas() {
    }
    //mutadores o accsesadores

    public String getPer_usuraio() {
        return per_usuraio;
    }

    public void setPer_usuraio(String per_usuraio) {
        this.per_usuraio = per_usuraio;
    }

    public String getPer_password() {
        return per_password;
    }

    public void setPer_password(String per_password) {
        this.per_password = per_password;
    }

    public String getPer_nombres() {
        return per_nombres;
    }

    public void setPer_nombres(String per_nombres) {
        this.per_nombres = per_nombres;
    }

    public String getPer_apellidos() {
        return per_apellidos;
    }

    public void setPer_apellidos(String per_apellidos) {
        this.per_apellidos = per_apellidos;
    }
    
}
