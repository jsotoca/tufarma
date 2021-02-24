package vista;

import helpers.ColumnItem;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class DataTableModel extends AbstractTableModel {
    
    private List<?> datos;
    List<ColumnItem> columnItems;

    public DataTableModel(List<ColumnItem> columnItems) {
        this.columnItems = columnItems;
    }
    
    public List<?> getValues() {
        return datos;
    }

    public void setValues(List<?> datos) {
        this.datos = datos;
        this.fireTableDataChanged();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnItems.get(columnIndex).nombre;
    }
      
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnItems.get(columnIndex).clase;
    }


    @Override
    public int getRowCount() {
        int cantidad = 0;
        
        if( this.datos != null){
            cantidad = this.datos.size();
        }
        
        return cantidad;
    }

    @Override
    public int getColumnCount() {
        return this.columnItems.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Object object;
        object = this.datos.get(rowIndex);
        
        Object temp_value;
        
        try {
            Field field = object.getClass().getDeclaredField(columnItems.get(columnIndex).nombre);    
            field.setAccessible(true);
            temp_value = field.get(object);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            temp_value = e;
        }
        
        return temp_value;
    }

    
    
}