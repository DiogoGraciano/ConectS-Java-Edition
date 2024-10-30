
package view;

import controller.DaoConexao;
import controller.DaoEmpresa;
import controller.DaoPrograma;
import controller.DaoSistemaOperacional;
import controller.DaoTerminal;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Conexao;
import model.Empresa;
import model.Programa;
import model.SistemaOperacional;
import model.Terminal;

public class dialogConexao extends javax.swing.JDialog {

    private DaoConexao dao = new DaoConexao();
    //limpar componentes
    //criar objeto
    private Conexao getConexao(){
        Conexao c = new Conexao();
        if (textCodigo.getText().isEmpty()){
            c.setId(0);
        }else{
            c.setId(Integer.parseInt(textCodigo.getText()));
        }       
        c.setNome(textNome.getText());
        c.setTerminal((Terminal)comboTerminal.getSelectedItem());
        c.setConexao(textConexao.getText());
        c.setEmpresa((Empresa)comboEmpresa.getSelectedItem());
        c.setObs(textObservacao.getText());
        c.setSenha(textSenha.getText());
        c.setPrograma((Programa)comboPrograma.getSelectedItem());
        c.setSistemaOperacional((SistemaOperacional)comboSistemaOperacional.getSelectedItem());
        
        return c;
    }
    
    private void atualizaComponentes(Conexao c){
        textCodigo.setText(c.getId()+"");
        textNome.setText(c.getNome());
        textConexao.setText(c.getConexao());
        textObservacao.setText(c.getObs());
        textSenha.setText(c.getSenha());
        comboTerminal.setSelectedItem(c.getTerminal());
        comboEmpresa.setSelectedItem(c.getEmpresa());
        comboPrograma.setSelectedItem(c.getPrograma());
        comboSistemaOperacional.setSelectedItem(c.getSistemaOperacional());
    }
    
    private void limpaComponentes(){
        textCodigo.setText("");
        textNome.setText("");
        textConexao.setText("");
        textObservacao.setText("");
        textSenha.setText("");
        textNome.requestFocus();
    }
    //popular os componentes
    //validar digitacao
    //atualizar listas
    private void atualizaLista(){
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(dao.read());
        lista.setModel(lm);
    }
    private void atualizaLista(String filtro){
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(dao.read(filtro));
        lista.setModel(lm);        
    }
    private void atualizaLista(Programa programa){
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(dao.read(programa));
        lista.setModel(lm);        
    }
    
    private void atualizaLista(Terminal terminal){
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(dao.read(terminal));
        lista.setModel(lm);        
    }
    
    private void atualizaLista(SistemaOperacional sistemaOperacional){
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(dao.read(sistemaOperacional));
        lista.setModel(lm);        
    }
    
    private void atualizaLista(Empresa empresa){
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(dao.read(empresa));
        lista.setModel(lm);        
    }
    //carregar os combos
    private void carregaCombos(){
        DefaultComboBoxModel t = 
        new DefaultComboBoxModel(new DaoTerminal().read().toArray());
        DefaultComboBoxModel tf = 
        new DefaultComboBoxModel(new DaoTerminal().read().toArray());
        comboTerminal.setModel(t);
        comboTerminalFiltro.setModel(tf);
        
        DefaultComboBoxModel c = 
        new DefaultComboBoxModel(new DaoPrograma().read().toArray());
        DefaultComboBoxModel cf = 
        new DefaultComboBoxModel(new DaoPrograma().read().toArray());
        comboPrograma.setModel(c);
        comboProgramaFiltro.setModel(cf);
        
        DefaultComboBoxModel e = 
        new DefaultComboBoxModel(new DaoEmpresa().read().toArray());
        DefaultComboBoxModel ef = 
        new DefaultComboBoxModel(new DaoEmpresa().read().toArray());
        comboEmpresa.setModel(e);
        comboEmpresaFiltro.setModel(ef);
        
        DefaultComboBoxModel so = 
        new DefaultComboBoxModel(new DaoSistemaOperacional().read().toArray());
        DefaultComboBoxModel sof = 
        new DefaultComboBoxModel(new DaoSistemaOperacional().read().toArray());
        comboSistemaOperacional.setModel(so);
        comboSistemaOperaciaonalFiltro.setModel(sof);
    }
    
    private boolean camposValidos(){
        if (textNome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Nome Obrigatório");
            return false;
        }
        if (textConexao.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Conexão Obrigatório");
            return false;
        }
        if (textSenha.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Senha Obrigatório");
            return false;
        }
        return true;
    }
    
    public dialogConexao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textNomeFiltro = new javax.swing.JTextField();
        buttonFiltroNome = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboTerminalFiltro = new javax.swing.JComboBox<>();
        buttonFiltroTerminal = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        comboProgramaFiltro = new javax.swing.JComboBox<>();
        buttonFiltroPrograma = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        comboEmpresaFiltro = new javax.swing.JComboBox<>();
        buttonFiltroEmpresa = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        comboSistemaOperaciaonalFiltro = new javax.swing.JComboBox<>();
        buttonFiltroSistemaOperacional = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        comboTerminal = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        comboSistemaOperacional = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        comboPrograma = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        comboEmpresa = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        textSenha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textConexao = new javax.swing.JTextField();
        textObservacao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conexão");
        setBackground(new java.awt.Color(204, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setText("Filtro Nome");

        textNomeFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeFiltroActionPerformed(evt);
            }
        });

        buttonFiltroNome.setText("Filtrar");
        buttonFiltroNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltroNomeActionPerformed(evt);
            }
        });

        jLabel5.setText("Filtro Terminal");

        buttonFiltroTerminal.setText("Filtrar");
        buttonFiltroTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltroTerminalActionPerformed(evt);
            }
        });

        jLabel12.setText("Filtro Empresa");

        buttonFiltroPrograma.setText("Filtrar");
        buttonFiltroPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltroProgramaActionPerformed(evt);
            }
        });

        jLabel13.setText("Filtro Programa");

        buttonFiltroEmpresa.setText("Filtrar");
        buttonFiltroEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltroEmpresaActionPerformed(evt);
            }
        });

        jLabel14.setText("Filtro Sistema Operacional");

        buttonFiltroSistemaOperacional.setText("Filtrar");
        buttonFiltroSistemaOperacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltroSistemaOperacionalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textNomeFiltro)
                            .addComponent(comboTerminalFiltro, 0, 220, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(buttonFiltroTerminal))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFiltroNome))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(comboEmpresaFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFiltroEmpresa))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(comboProgramaFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFiltroPrograma))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(comboSistemaOperaciaonalFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFiltroSistemaOperacional)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textNomeFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFiltroNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboTerminalFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFiltroTerminal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSistemaOperaciaonalFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFiltroSistemaOperacional)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProgramaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(buttonFiltroPrograma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEmpresaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFiltroEmpresa)
                    .addComponent(jLabel12))
                .addContainerGap())
        );

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel3.setText("Terminal");

        textCodigo.setEditable(false);

        jLabel6.setText("Sistema Operacional");

        jLabel7.setText("Programa");

        jLabel8.setText("Empresa");

        jLabel9.setText("Conexão");

        jLabel10.setText("Senha");

        jLabel11.setText("Observações");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textConexao)
                            .addComponent(comboEmpresa, 0, 295, Short.MAX_VALUE)
                            .addComponent(comboPrograma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboSistemaOperacional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboTerminal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNome, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboSistemaOperacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textConexao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.carregaCombos();
        this.atualizaLista();
    }//GEN-LAST:event_formWindowOpened

    private void buttonFiltroNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltroNomeActionPerformed
        // TODO add your handling code here:
        this.atualizaLista(textNomeFiltro.getText());        
    }//GEN-LAST:event_buttonFiltroNomeActionPerformed

    private void buttonFiltroTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltroTerminalActionPerformed
        this.atualizaLista((Terminal)comboTerminalFiltro.getSelectedItem());
    }//GEN-LAST:event_buttonFiltroTerminalActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.limpaComponentes();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!camposValidos()){
            JOptionPane.showMessageDialog(null,"Preencha os campos obrigatórios!");
            return;
        }
        try{
            Conexao c = this.getConexao();
            if (textCodigo.getText().isEmpty()){ //registro novo (create)
                dao.create(c);
            }else{ //atualização (update)
                dao.update(c);
            }
            //atualizar a lista
            this.atualizaLista();
            //limpar componentes
            this.limpaComponentes();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERRO:"+ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (!camposValidos()){
            JOptionPane.showMessageDialog(null,"Preencha os campos obrigatórios!");
            return;
        }
        try{
            dao.delete(this.getConexao());
            //atualizar a lista
            this.atualizaLista();
            //limpar componentes
            this.limpaComponentes();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "ERRO:"+ex.getMessage());
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        if (evt.getClickCount() == 2){
            Conexao c = (Conexao)lista.getSelectedValue();
            this.atualizaComponentes(c);
        }
    }//GEN-LAST:event_listaMouseClicked

    private void buttonFiltroProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltroProgramaActionPerformed
        this.atualizaLista((Programa)comboProgramaFiltro.getSelectedItem());
    }//GEN-LAST:event_buttonFiltroProgramaActionPerformed

    private void buttonFiltroEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltroEmpresaActionPerformed
        this.atualizaLista((Empresa)comboEmpresaFiltro.getSelectedItem());
    }//GEN-LAST:event_buttonFiltroEmpresaActionPerformed

    private void buttonFiltroSistemaOperacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltroSistemaOperacionalActionPerformed
        this.atualizaLista((SistemaOperacional)comboSistemaOperaciaonalFiltro.getSelectedItem());
    }//GEN-LAST:event_buttonFiltroSistemaOperacionalActionPerformed

    private void textNomeFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeFiltroActionPerformed
        this.atualizaLista(textNomeFiltro.getText());
    }//GEN-LAST:event_textNomeFiltroActionPerformed

    
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
            java.util.logging.Logger.getLogger(dialogConexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialogConexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialogConexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogConexao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogConexao dialog = new dialogConexao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton buttonFiltroEmpresa;
    private javax.swing.JButton buttonFiltroNome;
    private javax.swing.JButton buttonFiltroPrograma;
    private javax.swing.JButton buttonFiltroSistemaOperacional;
    private javax.swing.JButton buttonFiltroTerminal;
    private javax.swing.JComboBox<String> comboEmpresa;
    private javax.swing.JComboBox<String> comboEmpresaFiltro;
    private javax.swing.JComboBox<String> comboPrograma;
    private javax.swing.JComboBox<String> comboProgramaFiltro;
    private javax.swing.JComboBox<String> comboSistemaOperaciaonalFiltro;
    private javax.swing.JComboBox<String> comboSistemaOperacional;
    private javax.swing.JComboBox<String> comboTerminal;
    private javax.swing.JComboBox<String> comboTerminalFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textConexao;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textNomeFiltro;
    private javax.swing.JTextField textObservacao;
    private javax.swing.JTextField textSenha;
    // End of variables declaration//GEN-END:variables
}
