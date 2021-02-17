package entidades;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class Laboratorio {
    
    private int codigo;
    private String nombre;
    private boolean vigente;
    
    public Laboratorio() {
    }
    
    public Laboratorio(String nombre, boolean vigente) {
        this.nombre = nombre;
        this.vigente = vigente;
    }

    public Laboratorio(int codigo, String nombre, boolean vigente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.vigente = vigente;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
}
