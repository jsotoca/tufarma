package helpers;

import java.lang.reflect.Field;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class ObjectFields {
    
    public static Object getValue(Object value, String name){
        Object temp_value;
        try {
            Field field = value.getClass().getDeclaredField(name);    
            field.setAccessible(true);
            temp_value = field.get(value);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            temp_value = null;
        }
        return temp_value;
    } 
    
}
