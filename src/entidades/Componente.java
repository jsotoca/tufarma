package entidades;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class Componente {
    
    private Medicamento medicamento;
    private PrincipioActivo principio;
    private String concentracion;
    private boolean vigente;

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    

    public PrincipioActivo getPrincipio() {
        return principio;
    }

    public void setPrincipio(PrincipioActivo principio) {
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
