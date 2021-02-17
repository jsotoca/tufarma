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
}