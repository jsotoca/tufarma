package vista;

import java.util.List;
import entidades.Medicamento;
import helpers.ColumnItem;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import repositorios.ComponenteRepositorio;
import servicios.ComponenteServicio;
import servicios.MedicamentoServicio;
/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class ImportarComponentesView extends javax.swing.JFrame {

    private DataTableModel medicamentoExportadomodel;
    private DataTableModel medicamentoImportadomodel;
    private List<ColumnItem> medicamentocolumnItems;
    private List<Medicamento> medicamentos;
    private int exportado, importado;
    
    /**
     * Creates new form ImportarComponentes
     */
    public ImportarComponentesView() {
        initMedicamentosModel();
        initComponents();
        this.setLocationRelativeTo(null);
        listarMedicamentosExportados();
        this.btnImportar.setEnabled(false);
    }

    private void initMedicamentosModel(){
        medicamentocolumnItems = Arrays.asList(
            new ColumnItem("codigo",String.class),
            new ColumnItem("nombre",String.class),
            new ColumnItem("precio",String.class),
            new ColumnItem("vigente",Boolean.class)
        );
        
        medicamentoExportadomodel = new DataTableModel(medicamentocolumnItems);
        medicamentoImportadomodel = new DataTableModel(medicamentocolumnItems);
    }
    
    
    private void listarMedicamentosExportados() {
        try{
            medicamentos = MedicamentoServicio.listarMedicamentos();
            medicamentoExportadomodel.setValues(this.medicamentos);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo listar los laboratorios");
        }
    }
        
    private void listarMedicamentosImportados(int exportado) {
        try{
            List<Medicamento> importados = medicamentos.stream()
            .filter(med -> med.getCodigo() != exportado)
            .collect(Collectors.toList());
            this.medicamentoImportadomodel.setValues(importados);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo listar los componentes");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListado1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbListado2 = new javax.swing.JTable();
        btnImportar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("1. Seleccionar medicamento a exportar componentes"));

        tbListado1.setModel(medicamentoExportadomodel);
        tbListado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListado1seleccionarMedicamento(evt);
            }
        });
        jScrollPane1.setViewportView(tbListado1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("2. Seleccionar medicamento a importar componentes"));

        tbListado2.setModel(medicamentoImportadomodel);
        tbListado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListado2importar(evt);
            }
        });
        jScrollPane2.setViewportView(tbListado2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        btnImportar.setText("IMPORTAR COMPONENTES");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(btnImportar)
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnImportar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbListado1seleccionarMedicamento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListado1seleccionarMedicamento
        int fila = this.tbListado1.getSelectedRow();
        if (fila > -1) {
            this.exportado = (int) this.tbListado1.getModel().getValueAt(fila, 0);
            this.listarMedicamentosImportados(this.exportado);
        }
    }//GEN-LAST:event_tbListado1seleccionarMedicamento

    private void tbListado2importar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListado2importar
        int fila = this.tbListado2.getSelectedRow();
        if (fila > -1) {
            this.importado = (int) this.tbListado2.getModel().getValueAt(fila, 0);
            this.btnImportar.setEnabled(true);
        }
    }//GEN-LAST:event_tbListado2importar

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        // TODO add your handling code here:
        try{
            int resultado = ComponenteServicio.importarComponentes(exportado, importado);
            if(resultado == 1){
                JOptionPane.showMessageDialog(this, "componentes importados con exito");
            }else {
                if(resultado == -1){
                    JOptionPane.showMessageDialog(this, "El primer medicamento no tiene componentes");
                }else{
                    JOptionPane.showMessageDialog(this, "No se pudo importar los componentes");
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "No se pudo importar los componentes");
        }
        this.btnImportar.setEnabled(false);
        this.medicamentoImportadomodel.setValues(null);
    }//GEN-LAST:event_btnImportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImportar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbListado1;
    private javax.swing.JTable tbListado2;
    // End of variables declaration//GEN-END:variables
}
