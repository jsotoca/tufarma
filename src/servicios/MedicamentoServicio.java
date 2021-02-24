package servicios;

import entidades.Componente;
import java.util.List;
import entidades.Medicamento;
import repositorios.ComponenteRepositorio;
import repositorios.MedicamentoRepositorio;
/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class MedicamentoServicio {
    
    public static List<Medicamento> listarMedicamentos() throws Exception {
       try {
           return MedicamentoRepositorio.listarMedicamentos();
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static List<Medicamento> listarMedicamentosActivos() throws Exception {
       try {
           return MedicamentoRepositorio.listarMedicamentosActivos();
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static List<Medicamento> listarMedicamentosSimilares(int id_medicamento) throws Exception {
       try {
           return MedicamentoRepositorio.buscarMedicamentosSimilares(id_medicamento);
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static void crearMedicamento(Medicamento medicamento) throws Exception {
       try {
           MedicamentoRepositorio.crearMedicamento(medicamento);
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static List<Componente> buscarComponentesPorMedicamento(int id_medicamento) throws Exception {
        try {
           return ComponenteRepositorio.buscarComponentesPorMedicamento(id_medicamento);
       } catch (Exception e) {
           throw e;
       }
    }
    
}
