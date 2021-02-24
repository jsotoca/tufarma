package repositorios;

import configuracion.MySQL;
import entidades.Componente;
import entidades.PrincipioActivo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class ComponenteRepositorio {
    
    public static void crearComponente(Componente com, int medicamento) throws Exception {
        try {
            List<Object> values = Arrays.asList(
                    com.getPrincipioActivo().getCodigo(),
                    medicamento,
                    com.getConcentracion(),
                    com.isVigente()
            );
            MySQL.executeUpdate("INSERT INTO componente(id_principio_activo, id_medicamento, concentracion, vigencia) VALUES(?, ?, ?, ?)", values);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static List<Componente> buscarComponentesPorMedicamento(int id_medicamento) throws Exception {
        List<Componente> componentes = new ArrayList<>();
        String query = "call buscarDetallesComponentes(" + id_medicamento + ")";
        try {
            
            ResultSet rs = MySQL.executeQuery(query, null);
            while(rs.next()) {
                Componente componente = new Componente();
                PrincipioActivo  pa = new PrincipioActivo();
                pa.setCodigo(rs.getInt(1));
                pa.setNombre(rs.getString(2));
                componente.setPrincipioActivo(pa);
                componente.setConcentracion(rs.getString(3));
                componente.setVigente(rs.getBoolean(4));
                
                componentes.add(componente);
            }
        } catch (Exception e) {
            throw e;
        }
        return componentes;
    }
    
}
