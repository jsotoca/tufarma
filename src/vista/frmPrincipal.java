package vista;

import entidades.Laboratorio;
import java.awt.Component;
import servicios.LaboratorioServicio;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JPanel;
/**
 *
 * @author Albert Wesker <wesker@umbrella.corps>
 */
public class frmPrincipal extends javax.swing.JFrame {
    
    boolean accion;
    DefaultTableModel modelLaboratorios = new DefaultTableModel(){
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
        }
    };

    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal() {
        initComponents();
        this.inicializarPaneles();
        this.setLocationRelativeTo(null);
        this.cargarTablaLaboratorios();
    }
    
    private void inicializarPaneles(){
        this.setPanelEnabled(panDataLab, false);
    }
    
    private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

            Component[] components = panel.getComponents();

        for(int i = 0; i < components.length; i++) {
            if(components[i].getClass().getName() == "javax.swing.JPanel") {
                setPanelEnabled((JPanel) components[i], isEnabled);
            }

            components[i].setEnabled(isEnabled);
        }
    }
    
    public void cargarTablaLaboratorios(){
        
        modelLaboratorios.addColumn("id");        
        modelLaboratorios.addColumn("nombre");
        modelLaboratorios.addColumn("vigencia");

        List <Laboratorio> laboratorios = LaboratorioServicio.getLaboratorios();
        
        for (Laboratorio laboratorio : laboratorios) {
            
            int codigo = laboratorio.getCodigo();
            String nombre = laboratorio.getNombre();
            boolean vigencia = laboratorio.isVigente();
            
            Object[] data = {codigo, nombre, vigencia};

            modelLaboratorios.addRow(data);
        }
        
        this.tbLaboratorios.setModel(modelLaboratorios);
        //this.tbLaboratorios.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelLaboratorios = new javax.swing.JPanel();
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
        btnModificar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panelMedicamentos = new javax.swing.JPanel();
        panelActivos = new javax.swing.JPanel();
        menuBarPrincipal = new javax.swing.JMenuBar();
        menuAdministracion = new javax.swing.JMenu();
        menuLaboratorio = new javax.swing.JMenuItem();
        menuMedicamento = new javax.swing.JMenuItem();
        menuPrincipioActivo = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tufama ");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(240, 63, 135));

        panelContenedor.setLayout(new java.awt.CardLayout());

        panelLaboratorios.setBackground(new java.awt.Color(236, 240, 241));

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

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarColumna(evt);
            }
        });

        tbLaboratorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbLaboratorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarColumna(evt);
            }
        });
        jScrollPane2.setViewportView(tbLaboratorios);

        btnNuevoLab.setText("Nuevo");
        btnNuevoLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoLabActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNuevoLab)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
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
                    .addComponent(btnModificar))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jButton3.setText("Salir");

        javax.swing.GroupLayout panelLaboratoriosLayout = new javax.swing.GroupLayout(panelLaboratorios);
        panelLaboratorios.setLayout(panelLaboratoriosLayout);
        panelLaboratoriosLayout.setHorizontalGroup(
            panelLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLaboratoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLaboratoriosLayout.createSequentialGroup()
                        .addComponent(panDataLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLaboratoriosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        panelLaboratoriosLayout.setVerticalGroup(
            panelLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLaboratoriosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLaboratoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panDataLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelContenedor.add(panelLaboratorios, "card2");

        panelMedicamentos.setBackground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout panelMedicamentosLayout = new javax.swing.GroupLayout(panelMedicamentos);
        panelMedicamentos.setLayout(panelMedicamentosLayout);
        panelMedicamentosLayout.setHorizontalGroup(
            panelMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 872, Short.MAX_VALUE)
        );
        panelMedicamentosLayout.setVerticalGroup(
            panelMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        panelContenedor.add(panelMedicamentos, "card3");

        panelActivos.setBackground(new java.awt.Color(52, 73, 94));

        javax.swing.GroupLayout panelActivosLayout = new javax.swing.GroupLayout(panelActivos);
        panelActivos.setLayout(panelActivosLayout);
        panelActivosLayout.setHorizontalGroup(
            panelActivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 872, Short.MAX_VALUE)
        );
        panelActivosLayout.setVerticalGroup(
            panelActivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        panelContenedor.add(panelActivos, "card4");

        menuAdministracion.setText("Administración");
        menuAdministracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarContenedor(evt);
            }
        });

        menuLaboratorio.setText("Labotatorios");
        menuLaboratorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarMedicamento(evt);
            }
        });
        menuLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarPanel(evt);
            }
        });
        menuAdministracion.add(menuLaboratorio);

        menuMedicamento.setText("Medicamentos");
        menuMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarContenedor(evt);
            }
        });
        menuMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarPanel(evt);
            }
        });
        menuAdministracion.add(menuMedicamento);

        menuPrincipioActivo.setText("Principios Activos");
        menuPrincipioActivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarContenedor(evt);
            }
        });
        menuPrincipioActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarPanel(evt);
            }
        });
        menuAdministracion.add(menuPrincipioActivo);

        menuBarPrincipal.add(menuAdministracion);

        menuSalir.setText("Salir");
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salir(evt);
            }
        });
        menuBarPrincipal.add(menuSalir);

        setJMenuBar(menuBarPrincipal);

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

    
    
    private void salir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salir
        this.dispose();
    }//GEN-LAST:event_salir

    private void cambiarContenedor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarContenedor
        if(evt.getSource() == panelLaboratorios){
            System.out.println("labo");
        }
        if(evt.getSource() == panelMedicamentos){
            System.out.println("medi");
        }
        if(evt.getSource() == panelActivos){
            System.out.println("act");
        }
    }//GEN-LAST:event_cambiarContenedor

    private void cambiarMedicamento(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarMedicamento
        // TODO add your handling code here:
    }//GEN-LAST:event_cambiarMedicamento

    private void cambiarPanel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarPanel
        if(evt.getSource() == menuLaboratorio){
            panelLaboratorios.setVisible(true);
            panelMedicamentos.setVisible(false);
            panelActivos.setVisible(false);

        }
        if(evt.getSource() == menuMedicamento){
            panelLaboratorios.setVisible(false);
            panelMedicamentos.setVisible(true);
            panelActivos.setVisible(false);
        }
        if(evt.getSource() == menuPrincipioActivo){
            panelLaboratorios.setVisible(false);
            panelMedicamentos.setVisible(false);
            panelActivos.setVisible(true);
        }
    }//GEN-LAST:event_cambiarPanel

    private void seleccionarColumna(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seleccionarColumna
        
        
        int codigo = (int) tbLaboratorios.getValueAt(tbLaboratorios.getSelectedRow(), 0);
        String nombre = tbLaboratorios.getValueAt(tbLaboratorios.getSelectedRow(), 1).toString();
        boolean vigencia = (boolean) tbLaboratorios.getValueAt(tbLaboratorios.getSelectedRow(), 2);
        
        Laboratorio lab = new Laboratorio(codigo, nombre, vigencia);
        System.out.println(lab.getCodigo());
        System.out.println(lab.getNombre());
        System.out.println(lab.isVigente());
    }//GEN-LAST:event_seleccionarColumna

    private void btnNuevoLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLabActionPerformed
        this.accion = true;
        this.setPanelEnabled(panDataLab,true);
    }//GEN-LAST:event_btnNuevoLabActionPerformed

    private void btnAceptarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarLabActionPerformed
        if(this.accion){
            String nombre = this.txtNombreLab.getText();
            boolean vigencia = (boolean) cbVigenciaLab.isSelected();
            Laboratorio lab = new Laboratorio(nombre,vigencia);
            LaboratorioServicio.crearLaboratorio(lab);
        }else{
            
        }

    }//GEN-LAST:event_btnAceptarLabActionPerformed

    
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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarLab;
    private javax.swing.JButton btnCancelarLab;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevoLab;
    private javax.swing.JCheckBox cbVigenciaLab;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenuBar menuBarPrincipal;
    private javax.swing.JMenuItem menuLaboratorio;
    private javax.swing.JMenuItem menuMedicamento;
    private javax.swing.JMenuItem menuPrincipioActivo;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JPanel panDataLab;
    private javax.swing.JPanel panelActivos;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelLaboratorios;
    private javax.swing.JPanel panelMedicamentos;
    private javax.swing.JTable tbLaboratorios;
    private javax.swing.JTextField txtNombreLab;
    // End of variables declaration//GEN-END:variables
}
