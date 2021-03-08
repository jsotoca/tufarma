package servicios;

import entidades.Componente;
import repositorios.ComponenteRepositorio;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class ComponenteServicio {
    public static void eliminarComponente(Componente com) throws Exception {
       try {
           ComponenteRepositorio.eliminar(com);
       } catch (Exception e) {
           throw e;
       }
    }
    
    public static int importarComponentes(int exportado, int importado) throws Exception {
       int resultado = 0;
       try {
           resultado = ComponenteRepositorio.importarComponentes(exportado, importado);
       } catch (Exception e) {
           throw e;
       }
       return resultado;
    }
}
