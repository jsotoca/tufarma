package repositorios;

import configuracion.MySQL;
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
public class PrincipioActivoRepositorio {
    
    public static List<PrincipioActivo> listarPrincipiosActivos(){
        List<PrincipioActivo> principios_activos = new ArrayList<>();
        try {
            
            ResultSet rs = MySQL.executeQuery("SELECT * FROM principio_activo", null);
            while(rs.next()) {
                PrincipioActivo principioActivo = new PrincipioActivo();
                principioActivo.setCodigo(rs.getInt(1));
                principioActivo.setNombre(rs.getString(2));
                principioActivo.setDescripcion(rs.getString(3));
                principioActivo.setVigente(rs.getBoolean(4));
                principios_activos.add(principioActivo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return principios_activos;
    }
    
    public static void crearPrincipioActivo(PrincipioActivo pa){
        try {
            List<Object> values = Arrays.asList(pa.getNombre(),pa.getDescripcion(),pa.isVigente());
            MySQL.executeUpdate("INSERT INTO principio_activo(nombre, descripcion, vigencia) VALUES(?, ?, ?)", values);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void actualizarPrincipioActivo(PrincipioActivo pa){
        
        try {
            List<Object> values = Arrays.asList(pa.getNombre(),pa.getDescripcion(),pa.isVigente(),pa.getCodigo());
            MySQL.executeUpdate("UPDATE principio_activo set nombre = ?, descripcion = ?, vigencia = ? WHERE id_principio_activo = ?", values);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
