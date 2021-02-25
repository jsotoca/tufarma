package vista;

import entidades.Componente;
import entidades.Laboratorio;
import entidades.Medicamento;
import entidades.PrincipioActivo;
import helpers.ColumnItem;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import servicios.LaboratorioServicio;
import servicios.MedicamentoServicio;
import servicios.PrincipioActivoServicio;

/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class MedicamentoView extends javax.swing.JInternalFrame {

    private List<Medicamento> medicamentos;
    private List<Laboratorio> laboratorios;
    private List<PrincipioActivo> principiosActivos;
    private final List<Componente> componentes = new ArrayList<>();
    private List<ColumnItem> medicamentocolumnItems, componentescolumnItems;
    private DataComboBoxModel laboratorioModel, principioActivoModel;
    private DataTableModel medicamentoModel, componenteModel;
    private SpinnerNumberModel preciomodel;
    
    private static MedicamentoView instance;
    
    /**
     * Creates new form MedicamentoView
     */
    private MedicamentoView() {
        Dimension screenSize = new Dimension(990, 760);
        setPreferredSize(screenSize);
        
        initModels();
        initComponents();
        
        cbLaboratorio.setSelectedIndex(0);
        cbPrincipioActivo.setSelectedIndex(0);

        
        setPanelEnabled(panDataMed,false);
        
        listarMedicamentos();
    }
    
    public static MedicamentoView getInstance() {
        if(instance == null) instance = new MedicamentoView();
        return instance;
    }
    
    private void initModels(){
        initMedicamentoModel();
        initComponenteModel();
        initLaboratorioModel();
        initPrincipioActivoModel();
        initPrecioModel();
    }
    
    private void initMedicamentoModel(){
        medicamentocolumnItems = Arrays.asList(
            new ColumnItem("codigo",String.class),
            new ColumnItem("nombre",String.class),
            new ColumnItem("precio",String.class),
            new ColumnItem("vigente",Boolean.class)
        );
        
        medicamentoModel = new DataTableModel(medicamentocolumnItems);
    }
    
    private void initComponenteModel(){
        componentescolumnItems = Arrays.asList(
            new ColumnItem("codigo",String.class),
            new ColumnItem("principio",String.class),
            new ColumnItem("concentracion",String.class),
            new ColumnItem("vigente",Boolean.class)
        );
        
        componenteModel = new DataTableModel(componentescolumnItems);
    }
    
    private void initLaboratorioModel(){
        try{
            laboratorios = LaboratorioServicio.listarLaboratorios();
            laboratorioModel = new DataComboBoxModel(laboratorios);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo listar los laboratorios");
        }
    }
    
    private void initPrincipioActivoModel(){
        try{
            principiosActivos = PrincipioActivoServicio.listarPrincipioActivos();
            principioActivoModel = new DataComboBoxModel(principiosActivos);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo listar los principios activos");
        }
    }
    
    private void initPrecioModel(){
        Float value = new Float(0.0);
        Float minimun = new Float(0.0);
        Float step = new Float(0.1);
        preciomodel = new SpinnerNumberModel(value, minimun, null, step);
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
    
    private void listarMedicamentos() {
        try{
            medicamentos = MedicamentoServicio.listarMedicamentos();
            medicamentoModel.setValues(this.medicamentos);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo listar los laboratorios");
        }
    }
    
    private void limpiarDatos(){
        txtNombreMed.setText("");
        txtNombreMed.requestFocus();
        spPrecio.setValue(0);
        cbLaboratorio.setSelectedIndex(0);
        cbPrincipioActivo.setSelectedIndex(0);
        txtConcentracion.setText("");
        cbVigenciaCom.setSelected(false);
        cbVigenciaMed.setSelected(false);
        componentes.clear();
        componenteModel.setValues(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panDataMed = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreMed = new javax.swing.JTextField();
        cbVigenciaMed = new javax.swing.JCheckBox();
        btnAceptarPrin = new javax.swing.JButton();
        btnCancelarPrin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        spPrecio = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        cbLaboratorio = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        cbPrincipioActivo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtConcentracion = new javax.swing.JTextField();
        cbVigenciaCom = new javax.swing.JCheckBox();
        btnAgregarCom = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbComponentes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMedicamentos = new javax.swing.JTable();
        btnNuevoMed = new javax.swing.JButton();
        btnSalirMed = new javax.swing.JButton();

        panDataMed.setBackground(new java.awt.Color(236, 240, 241));
        panDataMed.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Medicamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        jLabel1.setText("Nombre:");

        cbVigenciaMed.setText("Vigente");

        btnAceptarPrin.setText("Aceptar");
        btnAceptarPrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarPrinActionPerformed(evt);
            }
        });

        btnCancelarPrin.setText("Cancelar");
        btnCancelarPrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPrinActionPerformed(evt);
            }
        });

        jLabel2.setText("Precio:");

        spPrecio.setModel(this.preciomodel);

        jLabel3.setText("Laboratorio:");

        cbLaboratorio.setModel(this.laboratorioModel);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Composición", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        cbPrincipioActivo.setModel(this.principioActivoModel);

        jLabel7.setText("Principio Activo:");

        jLabel8.setText("Concentracion:");

        cbVigenciaCom.setText("Vigente");

        btnAgregarCom.setText("Agregar Componente");
        btnAgregarCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComActionPerformed(evt);
            }
        });

        tbComponentes.setModel(this.componenteModel);
        tbComponentes.setEnabled(false);
        jScrollPane1.setViewportView(tbComponentes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarCom)
                            .addComponent(cbVigenciaCom)
                            .addComponent(cbPrincipioActivo, 0, 245, Short.MAX_VALUE)
                            .addComponent(txtConcentracion))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrincipioActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConcentracion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbVigenciaCom)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarCom)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panDataMedLayout = new javax.swing.GroupLayout(panDataMed);
        panDataMed.setLayout(panDataMedLayout);
        panDataMedLayout.setHorizontalGroup(
            panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panDataMedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDataMedLayout.createSequentialGroup()
                        .addComponent(btnAceptarPrin)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelarPrin))
                    .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panDataMedLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panDataMedLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(spPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panDataMedLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbVigenciaMed)
                                .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panDataMedLayout.setVerticalGroup(
            panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataMedLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(spPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(cbVigenciaMed)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarPrin)
                    .addComponent(btnCancelarPrin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Medicamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        tbMedicamentos.setModel(this.medicamentoModel);
        tbMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMedicamentosseleccionarColumna(evt);
            }
        });
        jScrollPane2.setViewportView(tbMedicamentos);

        btnNuevoMed.setText("Nuevo");
        btnNuevoMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNuevoMed)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnNuevoMed)
                .addContainerGap())
        );

        btnSalirMed.setText("Salir");
        btnSalirMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDataMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalirMed)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panDataMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalirMed)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarPrinActionPerformed
        
        Laboratorio lab = new Laboratorio();
        lab.setCodigo(laboratorioModel.getkey(cbLaboratorio.getSelectedItem().toString()));
        
        Medicamento med = new Medicamento();
        
        med.setNombre(txtNombreMed.getText());
        med.setPrecio(Float.parseFloat(spPrecio.getValue().toString()));
        med.setVigente((boolean) cbVigenciaMed.isSelected());
        med.setLaboratorio(lab);

        if (componentes.size() > 0) {
            med.setComponentes(componentes);
            try {
                MedicamentoServicio.crearMedicamento(med);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrio un error al momento de guardar el medicamento.");
            }
        } else JOptionPane.showMessageDialog(this, "Un medicamento no puede guardarse sin sus componentes.");
        listarMedicamentos();
        limpiarDatos();
        setPanelEnabled(panDataMed,false);
    }//GEN-LAST:event_btnAceptarPrinActionPerformed

    private void btnCancelarPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPrinActionPerformed
        setPanelEnabled(panDataMed,false);
        limpiarDatos();
    }//GEN-LAST:event_btnCancelarPrinActionPerformed

    private void tbMedicamentosseleccionarColumna(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMedicamentosseleccionarColumna
        /*int codigo = (int) tbPrincipios.getValueAt(tbPrincipios.getSelectedRow(), 0);
        String nombre = tbPrincipios.getValueAt(tbPrincipios.getSelectedRow(), 1).toString();
        String descripcion = tbPrincipios.getValueAt(tbPrincipios.getSelectedRow(), 2).toString();
        boolean vigencia = (boolean) tbPrincipios.getValueAt(tbPrincipios.getSelectedRow(), 3);

        principioActivo = new PrincipioActivo(codigo, nombre, descripcion, vigencia);*/
    }//GEN-LAST:event_tbMedicamentosseleccionarColumna

    private void btnSalirMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMedActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirMedActionPerformed

    private void btnNuevoMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMedActionPerformed
        setPanelEnabled(panDataMed,true);
        limpiarDatos();
    }//GEN-LAST:event_btnNuevoMedActionPerformed

    private void btnAgregarComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComActionPerformed
        int codigo = principioActivoModel.getkey(cbPrincipioActivo.getSelectedItem().toString());
        boolean repetido = false;
        
        for (Componente componente : componentes) {
            if(componente.getPrincipioActivo().getCodigo() == codigo){
                repetido = true;
                break;
            }
        }
        
        if(!repetido){
            String activo = cbPrincipioActivo.getSelectedItem().toString();
            String concentracion = txtConcentracion.getText();
            boolean vigencia = cbVigenciaCom.isSelected();
            
            PrincipioActivo prin = new PrincipioActivo();
            prin.setCodigo(codigo);
            
            Componente con = new Componente();
            con.setCodigo(codigo);
            con.setPrincipio(activo);
            con.setPrincipioActivo(prin);
            con.setConcentracion(concentracion);
            con.setVigente(vigencia);
            
            componentes.add(con);
            componenteModel.setValues(componentes);
            
        }else{
            JOptionPane.showMessageDialog(this, "Principio activo ya registrado.");
        }

    }//GEN-LAST:event_btnAgregarComActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarPrin;
    private javax.swing.JButton btnAgregarCom;
    private javax.swing.JButton btnCancelarPrin;
    private javax.swing.JButton btnNuevoMed;
    private javax.swing.JButton btnSalirMed;
    private javax.swing.JComboBox<String> cbLaboratorio;
    private javax.swing.JComboBox<String> cbPrincipioActivo;
    private javax.swing.JCheckBox cbVigenciaCom;
    private javax.swing.JCheckBox cbVigenciaMed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panDataMed;
    private javax.swing.JSpinner spPrecio;
    private javax.swing.JTable tbComponentes;
    private javax.swing.JTable tbMedicamentos;
    private javax.swing.JTextField txtConcentracion;
    private javax.swing.JTextField txtNombreMed;
    // End of variables declaration//GEN-END:variables
}
