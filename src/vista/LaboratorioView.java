package vista;

import entidades.Laboratorio;
import helpers.ColumnItem;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import servicios.LaboratorioServicio;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class LaboratorioView extends javax.swing.JInternalFrame {

    private List<Laboratorio> laboratorios;
    private List<ColumnItem> columnItems;
    private DataTableModel laboratorioModel;
    private Laboratorio laboratorio;
    private boolean bandera;
    
    private static LaboratorioView instance;
    
    /**
     * Creates new form LabotatorioView
     */
    private LaboratorioView() {
        initModel();
        
        Dimension screenSize = new Dimension(850, 560);
        setPreferredSize(screenSize);
        
        initComponents();
        
        setPanelEnabled(panDataLab,false);
        
        listarLaboratorios();
    }
    
    public static LaboratorioView getInstance() {
        if(instance == null) instance = new LaboratorioView();
        return instance;
    }
    
    private void initModel(){
        columnItems = Arrays.asList(
            new ColumnItem("codigo",String.class),
            new ColumnItem("nombre",String.class),
            new ColumnItem("vigente",Boolean.class)
        );
        
        laboratorioModel = new DataTableModel(columnItems);
    }
    
    private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

            Component[] components = panel.getComponents();

        for (Component component : components) {
            if ("javax.swing.JPanel".equals(component.getClass().getName())) {
                setPanelEnabled((JPanel) component, isEnabled);
            }
            component.setEnabled(isEnabled);
        }
    }
    
    private void listarLaboratorios() {
        try{
            this.laboratorios = LaboratorioServicio.listarLaboratorios();
            this.laboratorioModel.setValues(this.laboratorios);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo listar los laboratorios");
        }
    }
    
    private void limpiarDatos(){
        txtNombreLab.setText("");
        txtNombreLab.requestFocus();
        cbVigenciaLab.setSelected(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panDataLab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreLab = new javax.swing.JTextField();
        cbVigenciaLab = new javax.swing.JCheckBox();
        btnAceptarLab = new javax.swing.JButton();
        btnCancelarLab = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLaboratorios = new javax.swing.JTable();
        btnNuevoLab = new javax.swing.JButton();
        btnModificarLab = new javax.swing.JButton();
        btnSalirLab = new javax.swing.JButton();

        panDataLab.setBackground(new java.awt.Color(236, 240, 241));
        panDataLab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laboratorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        jLabel1.setText("Nombre:");

        cbVigenciaLab.setText("Vigente");

        btnAceptarLab.setText("Aceptar");
        btnAceptarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarLabActionPerformed(evt);
            }
        });

        btnCancelarLab.setText("Cancelar");
        btnCancelarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarLabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panDataLabLayout = new javax.swing.GroupLayout(panDataLab);
        panDataLab.setLayout(panDataLabLayout);
        panDataLabLayout.setHorizontalGroup(
            panDataLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLabLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDataLabLayout.createSequentialGroup()
                        .addComponent(btnAceptarLab)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarLab))
                    .addComponent(cbVigenciaLab)
                    .addComponent(txtNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panDataLabLayout.setVerticalGroup(
            panDataLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataLabLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panDataLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreLab, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cbVigenciaLab)
                .addGap(18, 18, 18)
                .addGroup(panDataLabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarLab)
                    .addComponent(btnCancelarLab))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Laboratorios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        tbLaboratorios.setModel(this.laboratorioModel);
        tbLaboratorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLaboratoriosseleccionarColumna(evt);
            }
        });
        jScrollPane2.setViewportView(tbLaboratorios);

        btnNuevoLab.setText("Nuevo");
        btnNuevoLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoLabActionPerformed(evt);
            }
        });

        btnModificarLab.setText("Modificar");
        btnModificarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNuevoLab)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarLab)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoLab)
                    .addComponent(btnModificarLab))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        btnSalirLab.setText("Salir");
        btnSalirLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirLabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panDataLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalirLab)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panDataLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalirLab)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarLabActionPerformed
        String nombre = txtNombreLab.getText();
        boolean vigencia = (boolean) cbVigenciaLab.isSelected();
        Laboratorio lab = new Laboratorio(nombre,vigencia);
        
        if (bandera) {
            try {
                LaboratorioServicio.crearLaboratorio(lab); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se pudo guardar laboratorio");
            }
        } else {
           lab.setCodigo(laboratorio.getCodigo());
            try {
                LaboratorioServicio.actualizarLaboratorio(lab);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se pudo guardar laboratorio");
            }
        }
        listarLaboratorios();
        limpiarDatos();
        setPanelEnabled(panDataLab,false);
    }//GEN-LAST:event_btnAceptarLabActionPerformed

    private void btnCancelarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLabActionPerformed
        setPanelEnabled(panDataLab,false);
        limpiarDatos();
    }//GEN-LAST:event_btnCancelarLabActionPerformed

    private void tbLaboratoriosseleccionarColumna(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLaboratoriosseleccionarColumna
        int codigo = (int) tbLaboratorios.getValueAt(tbLaboratorios.getSelectedRow(), 0);
        String nombre = tbLaboratorios.getValueAt(tbLaboratorios.getSelectedRow(), 1).toString();
        boolean vigencia = (boolean) tbLaboratorios.getValueAt(tbLaboratorios.getSelectedRow(), 2);
        
        laboratorio = new Laboratorio(codigo, nombre, vigencia);
    }//GEN-LAST:event_tbLaboratoriosseleccionarColumna

    private void btnNuevoLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLabActionPerformed
        bandera = true;
        setPanelEnabled(panDataLab,true);
        limpiarDatos();
        
    }//GEN-LAST:event_btnNuevoLabActionPerformed

    private void btnModificarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLabActionPerformed
        if(laboratorio != null){
            bandera = false;
            txtNombreLab.setText(laboratorio.getNombre());
            cbVigenciaLab.setSelected(laboratorio.isVigente());
            setPanelEnabled(panDataLab,true);
        }
        else JOptionPane.showMessageDialog(this, "Selecciona un labotatorio de la tabla de arriba, por favor.");
    }//GEN-LAST:event_btnModificarLabActionPerformed

    private void btnSalirLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirLabActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirLabActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarLab;
    private javax.swing.JButton btnCancelarLab;
    private javax.swing.JButton btnModificarLab;
    private javax.swing.JButton btnNuevoLab;
    private javax.swing.JButton btnSalirLab;
    private javax.swing.JCheckBox cbVigenciaLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panDataLab;
    private javax.swing.JTable tbLaboratorios;
    private javax.swing.JTextField txtNombreLab;
    // End of variables declaration//GEN-END:variables
}
