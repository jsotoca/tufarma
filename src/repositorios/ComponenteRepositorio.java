package repositorios;

import configuracion.MySQL;
import entidades.Componente;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class ComponenteRepositorio {
    
    public static void crearComponente(Componente com, int medicamento){
        try {
            List<Object> values = Arrays.asList(
                    com.getPrincipio().getCodigo(),
                    medicamento,
                    com.getConcentracion(),
                    com.isVigente()
            );
            MySQL.executeUpdate("INSERT INTO componente(id_principio_activo, id_medicamento, concentracion, vigencia) VALUES(?, ?, ?, ?)", values);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
