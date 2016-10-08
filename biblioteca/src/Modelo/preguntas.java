package Modelo;
public class preguntas {
    private String pre_codigo;
    private String pre_pregunta;

    //Constructor
    public preguntas() {
    }

    public preguntas(String pre_codigo, String pre_pregunta) {
        this.pre_codigo = pre_codigo;
        this.pre_pregunta = pre_pregunta;
    }

    //Mutadores
    public String getPre_codigo() {
        return pre_codigo;
    }

    public void setPre_codigo(String pre_codigo) {
        this.pre_codigo = pre_codigo;
    }

    public String getPre_pregunta() {
        return pre_pregunta;
    }

    public void setPre_pregunta(String pre_pregunta) {
        this.pre_pregunta = pre_pregunta;
    }
    
    //Sobreescribir la clase String
    @Override
    public String toString(){
        return pre_pregunta;
    }
            
}
