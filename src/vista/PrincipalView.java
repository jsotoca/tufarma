

package vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class PrincipalView extends javax.swing.JFrame {

    /** Creates new form PrincipalView */
    public PrincipalView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void limpiarPanelContenedor(){
        panelContenedor.removeAll();
        panelContenedor.revalidate();
        panelContenedor.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        meLaboratorios = new javax.swing.JMenuItem();
        meMedicamentos = new javax.swing.JMenuItem();
        mePrincipios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        meListadoMedicamento = new javax.swing.JMenuItem();
        meBusquedaMedicamentosIguales = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1059, Short.MAX_VALUE)
        );

        jMenu1.setText("Gestión");

        meLaboratorios.setText("Labotatorios");
        meLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meLaboratoriosActionPerformed(evt);
            }
        });
        jMenu1.add(meLaboratorios);

        meMedicamentos.setText("Medicamentos");
        meMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meMedicamentosActionPerformed(evt);
            }
        });
        jMenu1.add(meMedicamentos);

        mePrincipios.setText("Principios Activos");
        mePrincipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mePrincipiosActionPerformed(evt);
            }
        });
        jMenu1.add(mePrincipios);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");

        meListadoMedicamento.setText("Listado de medicamentos");
        meListadoMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meListadoMedicamentoActionPerformed(evt);
            }
        });
        jMenu2.add(meListadoMedicamento);

        meBusquedaMedicamentosIguales.setText("Búsqueda de medicamentos iguales");
        meBusquedaMedicamentosIguales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meBusquedaMedicamentosIgualesActionPerformed(evt);
            }
        });
        jMenu2.add(meBusquedaMedicamentosIguales);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarInternalFrame(javax.swing.JInternalFrame internalFrame, String title){
        internalFrame.setTitle(title);
        internalFrame.setMaximizable(true);
        internalFrame.setClosable(true);
        internalFrame.setLocation((panelContenedor.getWidth()-internalFrame.getWidth())/2, (panelContenedor.getHeight()-internalFrame.getHeight())/2);
        internalFrame.show();
    }
    
    private void meLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meLaboratoriosActionPerformed
        try {
            limpiarPanelContenedor();
            LaboratorioView lab = LaboratorioView.getInstance();
            panelContenedor.add(lab);
            cargarInternalFrame(lab, "Gestionar Laboratorios");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede abrir la ventana de labotatorios");
        }
    }//GEN-LAST:event_meLaboratoriosActionPerformed

    private void meMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meMedicamentosActionPerformed
        try {
            limpiarPanelContenedor();
            MedicamentoView med = MedicamentoView.getInstance();
            panelContenedor.add(med);
            cargarInternalFrame(med, "Gestionar Medicamentos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede abrir la ventana de medicamentos");
        }
    }//GEN-LAST:event_meMedicamentosActionPerformed

    private void mePrincipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mePrincipiosActionPerformed
        try {
            limpiarPanelContenedor();
            PrincipioActivoView prin = PrincipioActivoView.getInstance();
            panelContenedor.add(prin);
            cargarInternalFrame(prin, "Gestionar Principios Activos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede abrir la ventana de principios activos");
        }
    }//GEN-LAST:event_mePrincipiosActionPerformed

    private void meListadoMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meListadoMedicamentoActionPerformed
        try {
            limpiarPanelContenedor();
            ListadoMedicamentosView lis = ListadoMedicamentosView.getInstance();
            panelContenedor.add(lis);
            cargarInternalFrame(lis, "Listar Medicamentos");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede abrir la ventana de listado de medicaments");
        }
    }//GEN-LAST:event_meListadoMedicamentoActionPerformed

    private void meBusquedaMedicamentosIgualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meBusquedaMedicamentosIgualesActionPerformed
        try {
            limpiarPanelContenedor();
            BuscarMedicamentosIgualesView bus = BuscarMedicamentosIgualesView.getInstance();
            panelContenedor.add(bus);
            cargarInternalFrame(bus, "Buscar Medicamentos Similares");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede abrir la ventana de listado de medicaments");
        }
    }//GEN-LAST:event_meBusquedaMedicamentosIgualesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem meBusquedaMedicamentosIguales;
    private javax.swing.JMenuItem meLaboratorios;
    private javax.swing.JMenuItem meListadoMedicamento;
    private javax.swing.JMenuItem meMedicamentos;
    private javax.swing.JMenuItem mePrincipios;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables

}
