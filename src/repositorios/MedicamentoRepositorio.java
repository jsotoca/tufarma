package repositorios;

import configuracion.MySQL;
import entidades.Componente;
import java.util.List;
import entidades.Medicamento;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class MedicamentoRepositorio {
    
    public static List<Medicamento> listarMedicamentos() throws Exception {
        List<Medicamento> medicamentos = new ArrayList<>();
        try {
            
            ResultSet rs = MySQL.executeQuery("SELECT * FROM medicamento", null);
            while(rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setCodigo(rs.getInt(1));
                medicamento.setNombre(rs.getString(2));
                medicamento.setPrecio(rs.getFloat(3));
                medicamento.setVigente(rs.getBoolean(5));
                medicamentos.add(medicamento);
            }
        } catch (Exception e) {
            throw e;
        }
        return medicamentos;
    }
    
    
    public static List<Medicamento> listarMedicamentosActivos() throws Exception {
        List<Medicamento> medicamentos = new ArrayList<>();
        try {
            
            ResultSet rs = MySQL.executeQuery("SELECT * FROM medicamento WHERE vigencia = true", null);
            while(rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setCodigo(rs.getInt(1));
                medicamento.setNombre(rs.getString(2));
                medicamento.setPrecio(rs.getFloat(3));
                medicamento.setVigente(rs.getBoolean(5));
                medicamentos.add(medicamento);
            }
        } catch (Exception e) {
            throw e;
        }
        return medicamentos;
    }
    
    public static List<Medicamento> buscarMedicamentosSimilares(int id_medicamento) throws Exception {
        List<Medicamento> medicamentos = new ArrayList<>();
        String query = "call buscar_medicamentos_iguales(" + id_medicamento + ")";
        try {
            
            ResultSet rs = MySQL.executeQuery(query, null);
            while(rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setCodigo(rs.getInt(1));
                medicamento.setNombre(rs.getString(2));
                medicamento.setPrecio(rs.getFloat(3));
                medicamento.setVigente(rs.getBoolean(4));
                medicamentos.add(medicamento);
            }
        } catch (Exception e) {
            throw e;
        }
        return medicamentos;
    }
    
    public static void crearMedicamento(Medicamento medicamento) throws Exception {
        try {
            List<Object> values = Arrays.asList(
                    medicamento.getNombre(),
                    medicamento.getPrecio(), 
                    medicamento.getLaboratorio().getCodigo(),
                    medicamento.isVigente()
            );
            MySQL.executeUpdate("INSERT INTO medicamento(nombre, precio, laboratorio, vigencia) VALUES(?, ?, ?, ?)", values);
            
            ResultSet rs = MySQL.executeQuery("SELECT LAST_INSERT_ID();", null);
            
            if (rs.next()) {
                int id_medicamento = rs.getInt(1);
                
                for (Componente componente : medicamento.getComponentes()) {
                    ComponenteRepositorio.crearComponente(componente, id_medicamento);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
