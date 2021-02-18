package repositorios;

import configuracion.MySQL;
import java.util.List;
import entidades.Medicamento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                medicamento.setVigente(rs.getBoolean(4));
                medicamentos.add(medicamento);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return medicamentos;
    }
}
