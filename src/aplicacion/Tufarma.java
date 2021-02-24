package aplicacion;

import java.util.Locale;
import vista.PrincipalView;


/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class Tufarma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.Category.FORMAT, Locale.ENGLISH);
        PrincipalView principal = new PrincipalView();
        principal.setVisible(true);
    }
    
}
