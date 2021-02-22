package entidades;

import java.util.List;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class Medicamento {
    private int codigo;
    
    private String nombre;
    private float precio;
    private boolean vigente;
    
    private Laboratorio laboratorio;
    private List<Componente> componentes;

    public Medicamento(int codigo, String nombre, float precio, boolean vigente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.vigente = vigente;
    }

    
    
    public Medicamento(String nombre, float precio, boolean vigente, Laboratorio laboratorio ,List<Componente> componentes) {
        this.nombre = nombre;
        this.precio = precio;
        this.laboratorio = laboratorio;
        this.vigente = vigente;
        this.componentes = componentes;
    }

    public Medicamento() {
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
    
    
    
}
