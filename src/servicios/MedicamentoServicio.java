package servicios;

import java.util.List;
import entidades.Medicamento;
import repositorios.MedicamentoRepositorio;
/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class MedicamentoServicio {
    
    public static List<Medicamento> listarMedicamentos(){
       try {
           return MedicamentoRepositorio.listarMedicamentos();
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static void crearMedicamento(Medicamento medicamento){
       try {
           MedicamentoRepositorio.crearMedicamento(medicamento);
       } catch (Exception e) {
           throw e;
       }
    }
    
}
