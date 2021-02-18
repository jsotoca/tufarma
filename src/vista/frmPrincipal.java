package vista;

import entidades.Laboratorio;
import entidades.Medicamento;
import entidades.PrincipioActivo;
import entidades.Componente;
import helpers.ComboItem;
import java.awt.Component;
import java.util.ArrayList;
import servicios.LaboratorioServicio;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;
import servicios.MedicamentoServicio;
import servicios.PrincipioActivoServicio;
/**
 *
 * @author Juan Antonio Soto Cabrera <https://github.com/jsotoca/>
 */
public class frmPrincipal extends javax.swing.JFrame {
    
    boolean accionLab;
    boolean accionPrin;
    boolean accionMed;
    Laboratorio lab = null;
    PrincipioActivo prin = null;
    Medicamento med = null;
    
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
    DefaultTableModel modelPrincipios = new DefaultTableModel(){
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
        }
    };
    DefaultTableModel modelMedicamentos = new DefaultTableModel(){
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    default:
                        return Boolean.class;
                }
        }
    };
    DefaultTableModel modelComponentes = new DefaultTableModel(){
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                    case 0:
                        return String.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
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
        this.cargarTablas();
        this.cargarCombos();
    }
    
    private void inicializarPaneles(){
        this.setPanelEnabled(panDataLab, false);
        this.setPanelEnabled(panDataPrin,false);
        this.setPanelEnabled(panDataMed,false);
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
    
    private void cargarDataTablaLaboratorios(){
        List <Laboratorio> laboratorios = LaboratorioServicio.listarLaboratorios();
        
        modelLaboratorios.setRowCount(0);
        
        for (Laboratorio laboratorio : laboratorios) {
            
            int codigo = laboratorio.getCodigo();
            String nombre = laboratorio.getNombre();
            boolean vigencia = laboratorio.isVigente();
            
            Object[] data = {codigo, nombre, vigencia};

            modelLaboratorios.addRow(data);
        }
    }
    
    private void cargarDataTablaPrincipios(){
        List <PrincipioActivo> principios = PrincipioActivoServicio.listarPrincipioActivos();
        
        modelPrincipios.setRowCount(0);
        
        for (PrincipioActivo prin : principios) {
            
            int codigo = prin.getCodigo();
            String nombre = prin.getNombre();
            String descripcion = prin.getDescripcion();
            boolean vigencia = prin.isVigente();
            
            Object[] data = {codigo, nombre, descripcion ,vigencia};

            modelPrincipios.addRow(data);
        }
    }
    
    private void cargarDataTablaMedicamentos(){
        List <Medicamento> medicamentos = MedicamentoServicio.listarMedicamentos();
        
        modelMedicamentos.setRowCount(0);
        
        for (Medicamento medi : medicamentos) {
            int codigo = medi.getCodigo();
            String nombre = medi.getNombre();
            Float precio = medi.getPrecio();
            boolean vigencia = medi.isVigente();
            
            Object[] data = {codigo, nombre, precio ,vigencia};

            modelMedicamentos.addRow(data);
        }
    }
    
    private void cargarTablas(){
        this.cargarTablaLaboratorios();
        this.cargarTablaPrincipios();
        this.cargarTablaMedicamentos();
        this.cargarTablaComponentes();
    }
    
    public void cargarTablaLaboratorios(){
        
        modelLaboratorios.addColumn("id");        
        modelLaboratorios.addColumn("nombre");
        modelLaboratorios.addColumn("vigencia");

        this.cargarDataTablaLaboratorios();
        
        this.tbLaboratorios.setModel(modelLaboratorios);
        
    }
    
    public void cargarTablaPrincipios(){
        
        modelPrincipios.addColumn("id");        
        modelPrincipios.addColumn("nombre");
        modelPrincipios.addColumn("descripcion");
        modelPrincipios.addColumn("vigencia");

        this.cargarDataTablaPrincipios();
        
        this.tbPrincipios.setModel(modelPrincipios);
        
    }
    
    public void cargarTablaMedicamentos(){
        
        modelMedicamentos.addColumn("id");        
        modelMedicamentos.addColumn("nombre");
        modelMedicamentos.addColumn("precio");
        modelMedicamentos.addColumn("vigencia");

        this.cargarDataTablaMedicamentos();
        
        this.tbMedicamentos.setModel(modelMedicamentos);
        
    }
    
    public void cargarTablaComponentes(){
        
        modelComponentes.addColumn("id_principio");        
        modelComponentes.addColumn("principio");        
        modelComponentes.addColumn("concentracion");
        modelComponentes.addColumn("vigencia");

        this.tbComponentes.setModel(modelComponentes);
        
        TableColumnModel tcm = this.tbComponentes.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
    }

    private void cargarCombos(){
        this.cargarComboLaboratorios();
        this.cargarComboPrincipiosActivos();
    }
    
    private void cargarComboLaboratorios(){
        List <Laboratorio> laboratorios = LaboratorioServicio.listarLaboratorios();
        for (Laboratorio laboratorio : laboratorios) {
            int key = laboratorio.getCodigo();
            String value = laboratorio.getNombre();
            this.comboLaboratorios.addItem(new ComboItem(key,value));
        }
    }
    
    
    private void cargarComboPrincipiosActivos(){
        List <PrincipioActivo> principios = PrincipioActivoServicio.listarPrincipioActivos();
        for (PrincipioActivo prin : principios) {
            int key = prin.getCodigo();
            String value = prin.getNombre();
            this.comboPrincipio.addItem(new ComboItem(key,value));
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
        panDataMed = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreMed = new javax.swing.JTextField();
        cbVigenciaMed = new javax.swing.JCheckBox();
        btnAceptarMed = new javax.swing.JButton();
        btnCancelarMed = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioMed = new javax.swing.JTextField();
        comboLaboratorios = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        comboPrincipio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtConcentracion = new javax.swing.JTextField();
        cbVigenciaCom = new javax.swing.JCheckBox();
        btnAgregarCom = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbComponentes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMedicamentos = new javax.swing.JTable();
        btnNuevoMed = new javax.swing.JButton();
        btnModificarMed = new javax.swing.JButton();
        panelActivos = new javax.swing.JPanel();
        panDataPrin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombrePrin = new javax.swing.JTextField();
        cbVigenciaPrin = new javax.swing.JCheckBox();
        btnAceptarPrin = new javax.swing.JButton();
        btnCancelarPrin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcionPrin = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPrincipios = new javax.swing.JTable();
        btnNuevoPrin = new javax.swing.JButton();
        btnModificarPrin = new javax.swing.JButton();
        btnSalirPrin = new javax.swing.JButton();
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
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

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
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        panelMedicamentos.setBackground(new java.awt.Color(236, 240, 241));

        panDataMed.setBackground(new java.awt.Color(236, 240, 241));
        panDataMed.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Medicamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        jLabel4.setText("Nombre:");

        cbVigenciaMed.setText("Vigente");

        btnAceptarMed.setText("Aceptar");
        btnAceptarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarMedActionPerformed(evt);
            }
        });

        btnCancelarMed.setText("Cancelar");
        btnCancelarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMedActionPerformed(evt);
            }
        });

        jLabel5.setText("Precio:");

        jLabel6.setText("Lab:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Composición", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        jLabel7.setText("Principio Activo:");

        jLabel8.setText("Concentracion:");

        cbVigenciaCom.setText("Vigente");

        btnAgregarCom.setText("Agregar Componente");
        btnAgregarCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarComActionPerformed(evt);
            }
        });

        tbComponentes.setModel(new javax.swing.table.DefaultTableModel(
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
        tbComponentes.setEnabled(false);
        jScrollPane1.setViewportView(tbComponentes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConcentracion)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarCom)
                                    .addComponent(cbVigenciaCom)
                                    .addComponent(comboPrincipio, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPrincipio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panDataMedLayout = new javax.swing.GroupLayout(panDataMed);
        panDataMed.setLayout(panDataMedLayout);
        panDataMedLayout.setHorizontalGroup(
            panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataMedLayout.createSequentialGroup()
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panDataMedLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panDataMedLayout.createSequentialGroup()
                        .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panDataMedLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbVigenciaMed)
                                        .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panDataMedLayout.createSequentialGroup()
                                    .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panDataMedLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel6)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboLaboratorios, 0, 255, Short.MAX_VALUE)
                                        .addComponent(txtPrecioMed))))
                            .addGroup(panDataMedLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAceptarMed)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarMed)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panDataMedLayout.setVerticalGroup(
            panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataMedLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreMed, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioMed, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboLaboratorios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(cbVigenciaMed)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panDataMedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarMed)
                    .addComponent(btnCancelarMed))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Medicamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        jScrollPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane4seleccionarColumna(evt);
            }
        });

        tbMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMedicamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMedicamentosseleccionarColumna(evt);
            }
        });
        jScrollPane4.setViewportView(tbMedicamentos);

        btnNuevoMed.setText("Nuevo");
        btnNuevoMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMedActionPerformed(evt);
            }
        });

        btnModificarMed.setText("Modificar");
        btnModificarMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarMedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnNuevoMed)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarMed)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoMed)
                    .addComponent(btnModificarMed))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelMedicamentosLayout = new javax.swing.GroupLayout(panelMedicamentos);
        panelMedicamentos.setLayout(panelMedicamentosLayout);
        panelMedicamentosLayout.setHorizontalGroup(
            panelMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedicamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panDataMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelMedicamentosLayout.setVerticalGroup(
            panelMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMedicamentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMedicamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panDataMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMedicamentosLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelContenedor.add(panelMedicamentos, "card3");

        panelActivos.setBackground(new java.awt.Color(236, 240, 241));

        panDataPrin.setBackground(new java.awt.Color(236, 240, 241));
        panDataPrin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Principio Activo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        jLabel2.setText("Nombre:");

        cbVigenciaPrin.setText("Vigente");

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

        jLabel3.setText("Descrip:");

        javax.swing.GroupLayout panDataPrinLayout = new javax.swing.GroupLayout(panDataPrin);
        panDataPrin.setLayout(panDataPrinLayout);
        panDataPrinLayout.setHorizontalGroup(
            panDataPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataPrinLayout.createSequentialGroup()
                .addGroup(panDataPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panDataPrinLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescripcionPrin, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panDataPrinLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panDataPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panDataPrinLayout.createSequentialGroup()
                                .addComponent(btnAceptarPrin)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarPrin))
                            .addComponent(cbVigenciaPrin)
                            .addComponent(txtNombrePrin, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        panDataPrinLayout.setVerticalGroup(
            panDataPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panDataPrinLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panDataPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombrePrin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panDataPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcionPrin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(cbVigenciaPrin)
                .addGap(18, 18, 18)
                .addGroup(panDataPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptarPrin)
                    .addComponent(btnCancelarPrin))
                .addGap(43, 43, 43))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Laboratorios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(44, 62, 80))); // NOI18N

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3seleccionarColumna(evt);
            }
        });

        tbPrincipios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPrincipios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPrincipiosseleccionarColumna(evt);
            }
        });
        jScrollPane3.setViewportView(tbPrincipios);

        btnNuevoPrin.setText("Nuevo");
        btnNuevoPrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPrinActionPerformed(evt);
            }
        });

        btnModificarPrin.setText("Modificar");
        btnModificarPrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarPrinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNuevoPrin)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarPrin)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoPrin)
                    .addComponent(btnModificarPrin))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        btnSalirPrin.setText("Salir");
        btnSalirPrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPrinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelActivosLayout = new javax.swing.GroupLayout(panelActivos);
        panelActivos.setLayout(panelActivosLayout);
        panelActivosLayout.setHorizontalGroup(
            panelActivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActivosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelActivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelActivosLayout.createSequentialGroup()
                        .addComponent(panDataPrin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActivosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalirPrin)))
                .addContainerGap())
        );
        panelActivosLayout.setVerticalGroup(
            panelActivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActivosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelActivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panDataPrin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalirPrin)
                .addContainerGap(20, Short.MAX_VALUE))
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
        
        this.lab = new Laboratorio(codigo, nombre, vigencia);
        
    }//GEN-LAST:event_seleccionarColumna

    private void btnNuevoLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLabActionPerformed
        this.accionLab = true;
        this.limpiarPanLab();
        this.setPanelEnabled(panDataLab,true);
    }//GEN-LAST:event_btnNuevoLabActionPerformed

    private void btnAceptarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarLabActionPerformed
        
        String nombre = this.txtNombreLab.getText();
        boolean vigencia = (boolean) cbVigenciaLab.isSelected();
        Laboratorio labo = new Laboratorio(nombre,vigencia);
        
        if(this.accionLab){
            LaboratorioServicio.crearLaboratorio(labo);
        }    
        else{
            labo.setCodigo(this.lab.getCodigo());
            LaboratorioServicio.actualizarLaboratorio(labo);
        }
            
        this.cargarDataTablaLaboratorios();
        this.limpiarPanLab();
        this.setPanelEnabled(panDataLab,false);
        
    }//GEN-LAST:event_btnAceptarLabActionPerformed

    private void btnCancelarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarLabActionPerformed
        this.limpiarPanLab();
        this.setPanelEnabled(panDataLab,false);
    }//GEN-LAST:event_btnCancelarLabActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        this.accionLab = false;
        this.limpiarPanLab();
        txtNombreLab.setText(this.lab.getNombre());
        cbVigenciaLab.setSelected(this.lab.isVigente());
        this.setPanelEnabled(panDataLab,true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnAceptarPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarPrinActionPerformed
        String nombre = this.txtNombrePrin.getText();
        String descripcion = this.txtDescripcionPrin.getText();
        boolean vigencia = (boolean) cbVigenciaPrin.isSelected();
        PrincipioActivo pa = new PrincipioActivo(nombre, descripcion, vigencia);
        
        if(this.accionPrin){
            PrincipioActivoServicio.crearPrincipioActivo(pa);
        }    
        else{
            pa.setCodigo(this.prin.getCodigo());
            PrincipioActivoServicio.actualizarPrincipioActivo(pa);
        }
            
        this.cargarDataTablaPrincipios();
        this.limpiarPanPrin();
        this.setPanelEnabled(panDataPrin,false);
    }//GEN-LAST:event_btnAceptarPrinActionPerformed

    private void btnCancelarPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPrinActionPerformed
        this.limpiarPanPrin();
        this.setPanelEnabled(panDataPrin,false);
    }//GEN-LAST:event_btnCancelarPrinActionPerformed

    private void tbPrincipiosseleccionarColumna(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPrincipiosseleccionarColumna
        int codigo = (int) tbPrincipios.getValueAt(tbPrincipios.getSelectedRow(), 0);
        String nombre = tbPrincipios.getValueAt(tbPrincipios.getSelectedRow(), 1).toString();
        String descripcion = tbPrincipios.getValueAt(tbPrincipios.getSelectedRow(), 2).toString();
        boolean vigencia = (boolean) tbPrincipios.getValueAt(tbPrincipios.getSelectedRow(), 3);
        
        this.prin = new PrincipioActivo(codigo, nombre, descripcion, vigencia);
    }//GEN-LAST:event_tbPrincipiosseleccionarColumna

    private void jScrollPane3seleccionarColumna(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3seleccionarColumna
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3seleccionarColumna

    private void btnNuevoPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPrinActionPerformed
        this.accionPrin = true;
        this.limpiarPanPrin();
        this.setPanelEnabled(panDataPrin,true);
    }//GEN-LAST:event_btnNuevoPrinActionPerformed

    private void btnModificarPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarPrinActionPerformed
        this.accionPrin = false;
        this.limpiarPanPrin();
        txtNombrePrin.setText(this.prin.getNombre());
        txtDescripcionPrin.setText(this.prin.getDescripcion());
        cbVigenciaPrin.setSelected(this.prin.isVigente());
        this.setPanelEnabled(panDataPrin,true);
    }//GEN-LAST:event_btnModificarPrinActionPerformed

    private void btnSalirPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPrinActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirPrinActionPerformed

    private void btnAceptarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarMedActionPerformed
        int cantidad = this.modelComponentes.getRowCount();
        if(cantidad != 0){
            
            List <Componente> componentes = new ArrayList<>();
            
            for (int i = 0; i < cantidad; i++) {
                
                int id_principio = (int) modelComponentes.getValueAt(i, 0);
                
                PrincipioActivo princi = new PrincipioActivo();
                princi.setCodigo(id_principio);
                
                String concentracion = modelComponentes.getValueAt(i, 2).toString();
                boolean vigencia = (boolean) modelComponentes.getValueAt(i, 3);
                
                Componente compo = new Componente();
                
                compo.setPrincipio(princi);
                compo.setVigente(vigencia);
                compo.setConcentracion(concentracion);
                
                componentes.add(compo);
            }
            
            String nombre = this.txtNombreMed.getText();
            float precio = Float.valueOf(this.txtPrecioMed.getText());
            
            Object item = comboLaboratorios.getSelectedItem();
            int id_laboratorio = ((ComboItem)item).getKey();
            
            Laboratorio labo = new Laboratorio();
            labo.setCodigo(id_laboratorio);
            
            boolean vigencia = (boolean) cbVigenciaMed.isSelected();
            
            
            Medicamento medi = new Medicamento(nombre, precio, vigencia, labo ,componentes);

            if(this.accionMed){
                MedicamentoServicio.crearMedicamento(medi);
            }    
            else{
                //pa.setCodigo(this.prin.getCodigo());
                //PrincipioActivoServicio.actualizarPrincipioActivo(pa);
            }

            this.cargarDataTablaMedicamentos();
            this.limpiarPanMed();
            this.setPanelEnabled(panDataMed,false);
        }
    }//GEN-LAST:event_btnAceptarMedActionPerformed

    private void btnCancelarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarMedActionPerformed

    private void tbMedicamentosseleccionarColumna(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMedicamentosseleccionarColumna
        // TODO add your handling code here:
    }//GEN-LAST:event_tbMedicamentosseleccionarColumna

    private void jScrollPane4seleccionarColumna(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane4seleccionarColumna
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane4seleccionarColumna

    private void btnNuevoMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMedActionPerformed
        this.accionMed = true;
        this.limpiarPanMed();
        this.setPanelEnabled(panDataMed,true);
    }//GEN-LAST:event_btnNuevoMedActionPerformed

    private void btnModificarMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarMedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarMedActionPerformed

    private void btnAgregarComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarComActionPerformed
            Object item = comboPrincipio.getSelectedItem();
        
            int codigo = ((ComboItem)item).getKey();
            String activo = ((ComboItem)item).getValue();
            String concentracion = txtConcentracion.getText();
            boolean vigencia = cbVigenciaCom.isSelected();
            
            Object[] data = {codigo, activo, concentracion ,vigencia};

            modelComponentes.addRow(data);
    }//GEN-LAST:event_btnAgregarComActionPerformed


    private void limpiarPanLab(){
        txtNombreLab.setText("");
        cbVigenciaLab.setSelected(false);
    }
    
    private void limpiarPanPrin(){
        txtNombrePrin.setText("");
        txtDescripcionPrin.setText("");
        cbVigenciaPrin.setSelected(false);
    }
    
    private void limpiarPanMed(){
        txtNombreMed.setText("");
        txtPrecioMed.setText("");
        cbVigenciaMed.setSelected(false);
        comboLaboratorios.setSelectedIndex(0);
        comboPrincipio.setSelectedIndex(0);
        txtConcentracion.setText("");
        cbVigenciaCom.setSelected(false);
        modelComponentes.setRowCount(0);
    }
    
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
    private javax.swing.JButton btnAceptarMed;
    private javax.swing.JButton btnAceptarPrin;
    private javax.swing.JButton btnAgregarCom;
    private javax.swing.JButton btnCancelarLab;
    private javax.swing.JButton btnCancelarMed;
    private javax.swing.JButton btnCancelarPrin;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificarMed;
    private javax.swing.JButton btnModificarPrin;
    private javax.swing.JButton btnNuevoLab;
    private javax.swing.JButton btnNuevoMed;
    private javax.swing.JButton btnNuevoPrin;
    private javax.swing.JButton btnSalirPrin;
    private javax.swing.JCheckBox cbVigenciaCom;
    private javax.swing.JCheckBox cbVigenciaLab;
    private javax.swing.JCheckBox cbVigenciaMed;
    private javax.swing.JCheckBox cbVigenciaPrin;
    private javax.swing.JComboBox<ComboItem> comboLaboratorios;
    private javax.swing.JComboBox<ComboItem> comboPrincipio;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenu menuAdministracion;
    private javax.swing.JMenuBar menuBarPrincipal;
    private javax.swing.JMenuItem menuLaboratorio;
    private javax.swing.JMenuItem menuMedicamento;
    private javax.swing.JMenuItem menuPrincipioActivo;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JPanel panDataLab;
    private javax.swing.JPanel panDataMed;
    private javax.swing.JPanel panDataPrin;
    private javax.swing.JPanel panelActivos;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelLaboratorios;
    private javax.swing.JPanel panelMedicamentos;
    private javax.swing.JTable tbComponentes;
    private javax.swing.JTable tbLaboratorios;
    private javax.swing.JTable tbMedicamentos;
    private javax.swing.JTable tbPrincipios;
    private javax.swing.JTextField txtConcentracion;
    private javax.swing.JTextField txtDescripcionPrin;
    private javax.swing.JTextField txtNombreLab;
    private javax.swing.JTextField txtNombreMed;
    private javax.swing.JTextField txtNombrePrin;
    private javax.swing.JTextField txtPrecioMed;
    // End of variables declaration//GEN-END:variables
}
