package repositorios;

import configuracion.MySQL;
import entidades.Componente;
import entidades.PrincipioActivo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public static List<Componente> buscarComponentesPorMedicamento(int id_medicamento){
        List<Componente> componentes = new ArrayList<>();
        String query = "call buscarDetallesComponentes(" + id_medicamento + ")";
        try {
            
            ResultSet rs = MySQL.executeQuery(query, null);
            while(rs.next()) {
                Componente componente = new Componente();
                PrincipioActivo  pa = new PrincipioActivo();
                pa.setCodigo(rs.getInt(1));
                pa.setNombre(rs.getString(2));
                componente.setPrincipio(pa);
                componente.setConcentracion(rs.getString(3));
                componente.setVigente(rs.getBoolean(4));
                
                componentes.add(componente);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return componentes;
    }
    
}
