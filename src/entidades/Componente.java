package entidades;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class Componente {
    
    private Medicamento medicamento;
    private PrincipioActivo principioActivo;
    private int codigo;
    private String principio;
    private String concentracion;
    private boolean vigente;

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getCodigo() {
        return principioActivo.getCodigo();
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPrincipio() {
        return principioActivo.getNombre();
    }

    public void setPrincipio(String principio) {
        this.principio = principio;
    }
   
    public PrincipioActivo getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(PrincipioActivo principio) {
        this.principioActivo = principio;
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
