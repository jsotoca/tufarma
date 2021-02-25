package vista;

import helpers.ColumnItem;
import helpers.ObjectFields;
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
        return ObjectFields.getValue(this.datos.get(rowIndex), columnItems.get(columnIndex).nombre);        
    }

    
    
}