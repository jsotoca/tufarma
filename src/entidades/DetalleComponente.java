package entidades;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class DetalleComponente {
    private int codigo;
    private String principio;
    private String concentracion;
    private boolean vigente;

    public DetalleComponente(int codigo, String principio, String concentracion, boolean vigente) {
        this.codigo = codigo;
        this.principio = principio;
        this.concentracion = concentracion;
        this.vigente = vigente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPrincipio() {
        return principio;
    }

    public void setPrincipio(String principio) {
        this.principio = principio;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
    
    
    
}
