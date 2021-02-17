package repositorios;

import configuracion.MySQL;
import entidades.Laboratorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class LaboratorioRepositorio {
    
    public static List<Laboratorio> listarLaboratorios(){
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
    
    public static void crearLaboratorio(Laboratorio lab){
        try {
            List<Object> values = Arrays.asList(lab.getNombre(),lab.isVigente());
            MySQL.executeUpdate("INSERT INTO laboratorio(nombre, vigencia) VALUES(?, ?)", values);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void actualizarLaboratorio(Laboratorio lab){
        
        try {
            List<Object> values = Arrays.asList(lab.getNombre(),lab.isVigente(),lab.getCodigo());
            MySQL.executeUpdate("UPDATE laboratorio set nombre = ?, vigencia = ? WHERE id_laboratorio = ?", values);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}