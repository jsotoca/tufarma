package repositorios;

import configuracion.MySQL;
import entidades.Laboratorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class LaboratorioRepositorio {
    public static List<Laboratorio> getLaboratorios(){
        List<Laboratorio> laboratorios = new ArrayList<>();
        try {
            
            ResultSet rs = MySQL.executeQuery("SELECT * FROM laboratorio", null);
            while(rs.next()) {
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setCodigo(rs.getInt(1));
                laboratorio.setNombre(rs.getString(2));
                laboratorio.setVigente(rs.getBoolean(3));
                laboratorios.add(laboratorio);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return laboratorios;
    }
}
