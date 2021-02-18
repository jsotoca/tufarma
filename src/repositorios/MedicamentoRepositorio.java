package repositorios;

import configuracion.MySQL;
import java.util.List;
import entidades.Medicamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class MedicamentoRepositorio {
    
    public static List<Medicamento> listarMedicamentos(){
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
        } catch (SQLException e) {
            System.out.println(e);
        }
        return medicamentos;
    }
    
    public static void crearMedicamento(Medicamento medicamento){
        try {
            List<Object> values = Arrays.asList(
                    medicamento.getNombre(),
                    medicamento.getPrecio(), 
                    medicamento.getLaboratorio().getCodigo(),
                    medicamento.isVigente()
            );
            MySQL.executeUpdate("INSERT INTO medicamento(nombre, precio, laboratorio, vigencia) VALUES(?, ?, ?, ?)", values);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
