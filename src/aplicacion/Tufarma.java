package aplicacion;

import entidades.Laboratorio;
import java.util.List;
import servicios.LaboratorioServicio;
import vista.frmPrincipal;

/*import configuracion.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;*/

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class Tufarma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*try {
            List<Laboratorio> laboratorios;
            
            laboratorios = LaboratorioServicio.getLaboratorios();
            
            for (Laboratorio l : laboratorios) {
                System.out.println(l.getNombre());
            }
        } catch (Exception e) {
            System.out.println(e);
        }*/
        
        frmPrincipal aplicacion = new frmPrincipal();
        aplicacion.setVisible(true);
        /*try {
            
            List<String> values = Arrays.asList("falcon","123.33");
            MySQL.executeUpdate("INSERT INTO products(name, price) VALUES(?, ?)", values);
            
            ResultSet rs = MySQL.executeQuery("SELECT * FROM products", null);
            while(rs.next()) {
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
            }
        } catch (SQLException e) {
            System.out.println(e);
        }*/
 
            
    }
    
}
