/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerbrandUniverse;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Roman Pomares
 */
public class PanelEvento extends javax.swing.JPanel {

    /**
     * Creates new form PanelEvento
     */
    public PanelEvento() {
        initComponents();
       botonAbrir.setVisible(false);
       botonLimpiar.setVisible(false);
       botonGuardar.setVisible(false);
       labelDirecctorio.setVisible(false);
       menuIErrores.setVisible(false);
       this.botonCompilar.setVisible(true);
      
       //areaResultado.setVisible(false);
       //jScrollPane1.setVisible(false);
    }
    
     public void contarFilas(){
        int totalrows=getAreaCodigo().getLineCount();
            lineCounter.setText("1\n");
            for(int i=2; i<=totalrows;i++){
                lineCounter.setText(lineCounter.getText()+i+"\n");
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

        barraMenu1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuIAbrir = new javax.swing.JMenuItem();
        menuIGuardar = new javax.swing.JMenuItem();
        menuISalir = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuILimpiar = new javax.swing.JMenuItem();
        menuCorrer = new javax.swing.JMenu();
        menuIEjecutar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuIErrores = new javax.swing.JMenuItem();
        menuIVersion = new javax.swing.JMenuItem();
        buscadorAbrir = new javax.swing.JFileChooser();
        mensajeLexico = new javax.swing.JOptionPane();
        mensajeSintatico = new javax.swing.JOptionPane();
        mesajeExito = new javax.swing.JOptionPane();
        mensajeVersion = new javax.swing.JOptionPane();
        panelNorte = new javax.swing.JPanel();
        labelDirecctorio = new javax.swing.JLabel();
        panelCentro = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        lineCounter = new javax.swing.JTextArea();
        areaCodigo = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUniverso = new javax.swing.JTable();
        panelSur = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spinnerNivel = new javax.swing.JSpinner();
        botonCompilar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonAbrir = new javax.swing.JButton();

        menuArchivo.setText("Archivo");

        menuIAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuIAbrir.setText("Abrir Archivo");
        menuArchivo.add(menuIAbrir);

        menuIGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuIGuardar.setText("Guardar Archivo");
        menuArchivo.add(menuIGuardar);

        menuISalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuISalir.setText("Salir");
        menuArchivo.add(menuISalir);

        barraMenu1.add(menuArchivo);

        menuEditar.setText("Editar");

        menuILimpiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuILimpiar.setText("Limpiar Todo");
        menuEditar.add(menuILimpiar);

        barraMenu1.add(menuEditar);

        menuCorrer.setText("Ejecutar");

        menuIEjecutar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuIEjecutar.setText("Ejecutar");
        menuCorrer.add(menuIEjecutar);

        barraMenu1.add(menuCorrer);

        jMenu1.setText("Ayuda");

        menuIErrores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        menuIErrores.setText("Errores");
        jMenu1.add(menuIErrores);

        menuIVersion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        menuIVersion.setText("Información");
        jMenu1.add(menuIVersion);

        barraMenu1.add(jMenu1);

        buscadorAbrir.setFileFilter(new FileNameExtensionFilter("Archivos .txt", "txt"));

        mensajeLexico.setMessage("Hubo un Error Lexico");
        mensajeLexico.setMessageType(JOptionPane.ERROR_MESSAGE);

        mensajeSintatico.setMessage("Hubo un error Sintactico");
        mensajeSintatico.setMessageType(JOptionPane.ERROR_MESSAGE);

        mesajeExito.setMessage("Hecho");
        mesajeExito.setMessageType(JOptionPane.INFORMATION_MESSAGE);

        mensajeVersion.setMessage("Universo de Herbrand");
        mensajeVersion.setMessageType(JOptionPane.INFORMATION_MESSAGE);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setLayout(new java.awt.BorderLayout());

        panelNorte.setLayout(new java.awt.BorderLayout());

        labelDirecctorio.setText("Directorio del Archivo: ");
        labelDirecctorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelNorte.add(labelDirecctorio, java.awt.BorderLayout.CENTER);

        add(panelNorte, java.awt.BorderLayout.NORTH);

        panelCentro.setLayout(new java.awt.BorderLayout());

        jScrollPane5.setViewportBorder(new javax.swing.border.MatteBorder(null));
        jScrollPane5.setAutoscrolls(true);
        jScrollPane5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lineCounter.setEditable(false);
        lineCounter.setColumns(2);
        lineCounter.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        lineCounter.setLineWrap(true);
        lineCounter.setRows(2);
        lineCounter.setTabSize(2);
        lineCounter.setText("1");
        lineCounter.setAutoscrolls(false);
        lineCounter.setCaretColor(new java.awt.Color(51, 51, 255));
        lineCounter.setFocusable(false);

        areaCodigo.setColumns(20);
        areaCodigo.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        areaCodigo.setRows(5);
        areaCodigo.setTabSize(4);
        areaCodigo.setToolTipText("Inserte Clausula aquí");
        areaCodigo.setWrapStyleWord(true);
        areaCodigo.setMaximumSize(new java.awt.Dimension(214, 214));
        areaCodigo.setPreferredSize(new java.awt.Dimension(260, 74));
        areaCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                areaCodigoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lineCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addComponent(lineCounter)
        );

        jScrollPane5.setViewportView(jPanel2);

        panelCentro.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        areaResultado.setEditable(false);
        areaResultado.setColumns(20);
        areaResultado.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        areaResultado.setRows(8);
        jScrollPane1.setViewportView(areaResultado);

        panelCentro.add(jScrollPane1, java.awt.BorderLayout.LINE_END);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 187));

        tableUniverso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nivel:", "Universo:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableUniverso);
        if (tableUniverso.getColumnModel().getColumnCount() > 0) {
            tableUniverso.getColumnModel().getColumn(0).setMinWidth(40);
            tableUniverso.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableUniverso.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        panelCentro.add(jScrollPane2, java.awt.BorderLayout.SOUTH);

        add(panelCentro, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Nivel:");
        panelSur.add(jLabel1);

        spinnerNivel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spinnerNivel.setPreferredSize(new java.awt.Dimension(45, 20));
        panelSur.add(spinnerNivel);

        botonCompilar.setText("Ejecutar");
        botonCompilar.setToolTipText("Inicia el Analisis Lexico");
        panelSur.add(botonCompilar);

        botonLimpiar.setText("Limpiar Todo");
        panelSur.add(botonLimpiar);

        botonGuardar.setText("Guardar Archivo");
        panelSur.add(botonGuardar);

        botonAbrir.setText("Abrir Archivo");
        panelSur.add(botonAbrir);

        add(panelSur, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void areaCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaCodigoKeyReleased
        if(evt.isControlDown() || evt.getKeyCode()==10 || evt.getKeyCode()==8 || evt.getKeyCode()==127){
            contarFilas();
        }
    }//GEN-LAST:event_areaCodigoKeyReleased

    public final void addEventos(Oyente oyente) {
        botonCompilar.addActionListener(oyente);
        botonAbrir.addActionListener(oyente);
        botonLimpiar.addActionListener(oyente);
        botonGuardar.addActionListener(oyente);
        menuIEjecutar.addActionListener(oyente);
        menuIAbrir.addActionListener(oyente);
        menuIGuardar.addActionListener(oyente);
        menuILimpiar.addActionListener(oyente);
        menuISalir.addActionListener(oyente);
        this.menuIVersion.addActionListener(oyente);
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaCodigo;
    private javax.swing.JTextArea areaResultado;
    private javax.swing.JMenuBar barraMenu1;
    private javax.swing.JButton botonAbrir;
    private javax.swing.JButton botonCompilar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JFileChooser buscadorAbrir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelDirecctorio;
    private javax.swing.JTextArea lineCounter;
    private javax.swing.JOptionPane mensajeLexico;
    private javax.swing.JOptionPane mensajeSintatico;
    private javax.swing.JOptionPane mensajeVersion;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuCorrer;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuIAbrir;
    private javax.swing.JMenuItem menuIEjecutar;
    private javax.swing.JMenuItem menuIErrores;
    private javax.swing.JMenuItem menuIGuardar;
    private javax.swing.JMenuItem menuILimpiar;
    private javax.swing.JMenuItem menuISalir;
    private javax.swing.JMenuItem menuIVersion;
    private javax.swing.JOptionPane mesajeExito;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelNorte;
    private javax.swing.JPanel panelSur;
    private javax.swing.JSpinner spinnerNivel;
    private javax.swing.JTable tableUniverso;
    // End of variables declaration//GEN-END:variables

    

    /**
     * @return the areaResultado
     */
    public javax.swing.JTextArea getAreaResultado() {
        return areaResultado;
    }

    /**
     * @param areaResultado the areaResultado to set
     */
    public void setAreaResultado(javax.swing.JTextArea areaResultado) {
        this.areaResultado = areaResultado;
    }

    /**
     * @return the botonAbrir
     */
    public javax.swing.JButton getBotonAbrir() {
        return botonAbrir;
    }

    /**
     * @param botonAbrir the botonAbrir to set
     */
    public void setBotonAbrir(javax.swing.JButton botonAbrir) {
        this.botonAbrir = botonAbrir;
    }

    /**
     * @return the botonCompilar
     */
    public javax.swing.JButton getBotonCompilar() {
        return botonCompilar;
    }

    /**
     * @param botonCompilar the botonCompilar to set
     */
    public void setBotonCompilar(javax.swing.JButton botonCompilar) {
        this.botonCompilar = botonCompilar;
    }

    /**
     * @return the buscadorAbrir
     */
    public javax.swing.JFileChooser getBuscadorAbrir() {
        return buscadorAbrir;
    }

    /**
     * @param buscadorAbrir the buscadorAbrir to set
     */
    public void setBuscadorAbrir(javax.swing.JFileChooser buscadorAbrir) {
        this.buscadorAbrir = buscadorAbrir;
    }

    /**
     * @return the mensajeLexico
     */
    public javax.swing.JOptionPane getMensajeLexico() {
        return mensajeLexico;
    }

    /**
     * @param mensajeLexico the mensajeLexico to set
     */
    public void setMensajeLexico(javax.swing.JOptionPane mensajeLexico) {
        this.mensajeLexico = mensajeLexico;
    }

    /**
     * @return the mensajeSintatico
     */
    public javax.swing.JOptionPane getMensajeSintatico() {
        return mensajeSintatico;
    }

    /**
     * @param mensajeSintatico the mensajeSintatico to set
     */
    public void setMensajeSintatico(javax.swing.JOptionPane mensajeSintatico) {
        this.mensajeSintatico = mensajeSintatico;
    }

    /**
     * @return the labelDirecctorio
     */
    public javax.swing.JLabel getLabelDirecctorio() {
        return labelDirecctorio;
    }

    /**
     * @param labelDirecctorio the labelDirecctorio to set
     */
    public void setLabelDirecctorio(javax.swing.JLabel labelDirecctorio) {
        this.labelDirecctorio = labelDirecctorio;
    }

    /**
     * @return the barraMenu1
     */
    public javax.swing.JMenuBar getBarraMenu1() {
        return barraMenu1;
    }

    /**
     * @param barraMenu1 the barraMenu1 to set
     */
    public void setBarraMenu1(javax.swing.JMenuBar barraMenu1) {
        this.barraMenu1 = barraMenu1;
    }

    
   
    /**
     * @return the mesajeExito
     */
    public javax.swing.JOptionPane getMesajeExito() {
        return mesajeExito;
    }

    /**
     * @param mesajeExito the mesajeExito to set
     */
    public void setMesajeExito(javax.swing.JOptionPane mesajeExito) {
        this.mesajeExito = mesajeExito;
    }

    /**
     * @return the areaCodigo
     */
    public javax.swing.JTextArea getAreaCodigo() {
        return areaCodigo;
    }

    /**
     * @param areaCodigo the areaCodigo to set
     */
    public void setAreaCodigo(javax.swing.JTextArea areaCodigo) {
        this.areaCodigo = areaCodigo;
    }

    /**
     * @return the menuIAbrir
     */
    public javax.swing.JMenuItem getMenuIAbrir() {
        return menuIAbrir;
    }

    /**
     * @param menuIAbrir the menuIAbrir to set
     */
    public void setMenuIAbrir(javax.swing.JMenuItem menuIAbrir) {
        this.menuIAbrir = menuIAbrir;
    }

    /**
     * @return the menuIEjecutar
     */
    public javax.swing.JMenuItem getMenuIEjecutar() {
        return menuIEjecutar;
    }

    /**
     * @param menuIEjecutar the menuIEjecutar to set
     */
    public void setMenuIEjecutar(javax.swing.JMenuItem menuIEjecutar) {
        this.menuIEjecutar = menuIEjecutar;
    }

    /**
     * @return the menuIGuardar
     */
    public javax.swing.JMenuItem getMenuIGuardar() {
        return menuIGuardar;
    }

    /**
     * @param menuIGuardar the menuIGuardar to set
     */
    public void setMenuIGuardar(javax.swing.JMenuItem menuIGuardar) {
        this.menuIGuardar = menuIGuardar;
    }

    /**
     * @return the menuILimpiar
     */
    public javax.swing.JMenuItem getMenuILimpiar() {
        return menuILimpiar;
    }

    /**
     * @param menuILimpiar the menuILimpiar to set
     */
    public void setMenuILimpiar(javax.swing.JMenuItem menuILimpiar) {
        this.menuILimpiar = menuILimpiar;
    }

    /**
     * @return the menuISalir
     */
    public javax.swing.JMenuItem getMenuISalir() {
        return menuISalir;
    }

    /**
     * @param menuISalir the menuISalir to set
     */
    public void setMenuISalir(javax.swing.JMenuItem menuISalir) {
        this.menuISalir = menuISalir;
    }

    /**
     * @return the menuIVersion
     */
    public javax.swing.JMenuItem getMenuIVersion() {
        return menuIVersion;
    }

    /**
     * @param menuIVersion the menuIVersion to set
     */
    public void setMenuIVersion(javax.swing.JMenuItem menuIVersion) {
        this.menuIVersion = menuIVersion;
    }

    /**
     * @return the mensajeVersion
     */
    public javax.swing.JOptionPane getMensajeVersion() {
        return mensajeVersion;
    }

    /**
     * @param mensajeVersion the mensajeVersion to set
     */
    public void setMensajeVersion(javax.swing.JOptionPane mensajeVersion) {
        this.mensajeVersion = mensajeVersion;
    }

    public JSpinner getSpinnerNivel() {
        return spinnerNivel;
    }

    public void setSpinnerNivel(JSpinner spinnerNivel) {
        this.spinnerNivel = spinnerNivel;
    }

    public JTable getTableUniverso() {
        return tableUniverso;
    }

    public void setTableUniverso(JTable tableUniverso) {
        this.tableUniverso = tableUniverso;
    }
   
}
