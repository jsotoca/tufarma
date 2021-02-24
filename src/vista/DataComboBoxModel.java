package vista;

import helpers.ComboItem;
import helpers.ObjectFields;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class DataComboBoxModel extends AbstractListModel implements ComboBoxModel {
    
    private String selectedItem;
    private List<ComboItem> items = new ArrayList<>();

    public DataComboBoxModel(List<?> items) {
        items.forEach(item -> {
            int key = (int) ObjectFields.getValue(item, "codigo");
            String value = (String) ObjectFields.getValue(item, "nombre");
            this.items.add( new ComboItem(key, value) );
        });
    }
    
    public int getkey(String value){
        int key = -1;
        for (ComboItem item : items) {
            if (value.equals(item.getValue())) {
                key = item.getKey();
                break;
            }
        }
        return key;
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public Object getElementAt(int index) {
        return items.get(index).getValue();
        
    }

    @Override
    public void setSelectedItem(Object object) {
        String value = (String) object;
        for (ComboItem item : items) {
            if (value.equals(item.getValue())) {
                selectedItem = item.getValue();
                break;
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
