package helpers;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class ColumnItem {
    
    public String nombre;
    public Class<? extends Object> clase;

    public ColumnItem() {
    }
    

    public ColumnItem(String nombre, Class<? extends Object> clase) {
        this.nombre = nombre;
        this.clase = clase;
    }
    
    
}
