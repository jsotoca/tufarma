package servicios;

import entidades.PrincipioActivo;
import java.util.List;
import repositorios.PrincipioActivoRepositorio;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class PrincipioActivoServicio {
    
    public static List<PrincipioActivo> listarPrincipioActivos(){
       try {
           return PrincipioActivoRepositorio.listarPrincipiosActivos();
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static void crearPrincipioActivo(PrincipioActivo pa){
       try {
           PrincipioActivoRepositorio.crearPrincipioActivo(pa);
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static void actualizarPrincipioActivo(PrincipioActivo pa){
       try {
           PrincipioActivoRepositorio.actualizarPrincipioActivo(pa);
       } catch (Exception e) {
           throw e;
       }
    }
}
