package entidades;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class PrincipioActivo {
    private int codigo;
    private String nombre;
    private String descripcion;
    private boolean vigente;

    public PrincipioActivo() {
    }
    
    public PrincipioActivo(int codigo, String nombre, String descripcion, boolean vigente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vigente = vigente;
    }

    public PrincipioActivo(String nombre, String descripcion, boolean vigente) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
}
