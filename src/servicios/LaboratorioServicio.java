package servicios;

import java.util.List;
import entidades.Laboratorio;
import repositorios.LaboratorioRepositorio;
/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class LaboratorioServicio {
   
    public static List<Laboratorio> listarLaboratorios(){
       try {
           return LaboratorioRepositorio.listarLaboratorios();
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static void crearLaboratorio(Laboratorio lab){
       try {
           LaboratorioRepositorio.crearLaboratorio(lab);
       } catch (Exception e) {
           throw e;
       }
    }
   
}
