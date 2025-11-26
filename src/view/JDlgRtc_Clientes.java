/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RtcCliente;
import com.sun.webkit.CursorManager;
import dao.Rtc_ClientesDAO;
import java.util.List;
import tools.Util;
import view.JDlgRtc_ClientesPesquisar;

/**
 *
 * @author Jaque
 */
public class JDlgRtc_Clientes extends javax.swing.JDialog {

    boolean incluir = false;
    private boolean clientePesquisado = false;

    /**
     * Creates new form JDlgRtc_Clientes
     */
    public JDlgRtc_Clientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Cadastro de Clientes");
        setLocationRelativeTo(null);

        Util.habilitar(false, jTxtRtc_Codigo, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M, jBtnRtc_Confirmar, jBtnRtc_Cancelar);

        addPlaceholder(jTxtRtc_Codigo, "Código...");
        addPlaceholder(jTxtRtc_Nome, "Ex: João da Silva");
        addPlaceholder(jTxtRtc_Email, "Ex: joaosilva@email.com");
        addPlaceholder(jTxtRtc_Estado, "Ex: MS");
        addPlaceholder(jTxtRtc_Bairro, "Ex: Copão Redondo");
        addPlaceholder(jTxtRtc_Endereco, "Ex: Rua das Flores, 123");
        addPlaceholder(jTxtRtc_Cidade, "Ex: São Paulo");
        addPlaceholder(jFmtRtc_Celular, "(00) 00000-0000");

        jTxtRtc_Codigo.setToolTipText("Digite o código do cliente (gerado automaticamente ou manualmente)");
        jTxtRtc_Nome.setToolTipText("Informe o nome completo do cliente");
        jFmtRtc_Cpf.setToolTipText("Informe o CPF no formato 000.000.000-00");
        jFmtRtc_Cep.setToolTipText("Informe o CPF no formato 00000-000");
        jFmtRtc_Celular.setToolTipText("Informe o celular no formato (00)0000-00000");
        jTxtRtc_Email.setToolTipText("Digite o e-mail principal do cliente");
        jFmtRtc_Celular.setToolTipText("Informe o telefone no formato (00) 00000-0000");
        jTxtRtc_Endereco.setToolTipText("Informe o endereço completo do cliente");
        jTxtRtc_Cidade.setToolTipText("Digite a cidade de residência do cliente");
        jCboRtc_TipoCliente.setToolTipText("Selecione o tipo de cliente (Gamer, Designer, Colaborador...)");
        jChbRtc_Ativo.setToolTipText("Marque se o cliente está ativo no sistema");
        jRdBtnRtc_M.setToolTipText("Sexo Masculino");
        jRdBtnRtc_F.setToolTipText("Sexo Feminino");
        jTxtRtc_Bairro.setToolTipText("Informe o Bairro do cliente");
        jTxtRtc_Estado.setToolTipText("O Estado deve conter apenas as siglas!");
        jFmtRtc_DataCadastro.setToolTipText("Preencha a data de cadastro do cliente no formato DD/MM/AAAA");
        jFmtRtc_DataNascimento.setToolTipText("Preencha a data de nascimento do cliente no formato DD/MM/AAAA");
    }

    private void addPlaceholder(javax.swing.text.JTextComponent textComponent, String placeholder) {
        textComponent.setText(placeholder);
        textComponent.setForeground(java.awt.Color.BLACK);

        textComponent.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (textComponent.getText().equals(placeholder)) {
                    textComponent.setText("");
                    textComponent.setForeground(java.awt.Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (textComponent.getText().isEmpty()) {
                    textComponent.setForeground(java.awt.Color.GRAY);
                    textComponent.setText(placeholder);
                }
            }
        });
    }

    public RtcCliente viewBean() {
        RtcCliente cliente = new RtcCliente();
        cliente.setRtcIdcliente(Util.strToInt(jTxtRtc_Codigo.getText()));
        cliente.setRtcNome(jTxtRtc_Nome.getText());
        cliente.setRtcEmail(jTxtRtc_Email.getText());
        cliente.setRtcEndereco(jTxtRtc_Endereco.getText());
        cliente.setRtcCidade(jTxtRtc_Cidade.getText());
        cliente.setRtcBairro(jTxtRtc_Bairro.getText());
        cliente.setRtcEstado(jTxtRtc_Estado.getText());
        cliente.setRtcCep(jFmtRtc_Cep.getText());
        cliente.setRtcCpf(jFmtRtc_Cpf.getText());
        cliente.setRtcCelular(jFmtRtc_Celular.getText());
        cliente.setRtcDataCadastro(Util.strToDate(jFmtRtc_DataCadastro.getText()));
        cliente.setRtcDataNascimento(Util.strToDate(jFmtRtc_DataNascimento.getText()));
        cliente.setRtcTipoCliente(jCboRtc_TipoCliente.getSelectedIndex());
        cliente.setRtcAtivo(jChbRtc_Ativo.isSelected() ? "S" : "N");

        if (jRdBtnRtc_M.isSelected()) {
            cliente.setRtcSexo("M");
        } else if (jRdBtnRtc_F.isSelected()) {
            cliente.setRtcSexo("F");
        } else {
            cliente.setRtcSexo(null); // ou "" dependendo do seu bean
        }

        return cliente;
    }

    public void beanView(RtcCliente clientes) {
        jTxtRtc_Codigo.setText(String.valueOf(clientes.getRtcIdcliente()));
        jTxtRtc_Nome.setText(String.valueOf(clientes.getRtcNome()));
        jTxtRtc_Estado.setText(String.valueOf(clientes.getRtcEstado()));
        jTxtRtc_Endereco.setText(String.valueOf(clientes.getRtcEndereco()));
        jTxtRtc_Email.setText(String.valueOf(clientes.getRtcEmail()));
        jTxtRtc_Cidade.setText(String.valueOf(clientes.getRtcCidade()));
        jTxtRtc_Bairro.setText(String.valueOf(clientes.getRtcBairro()));

        jFmtRtc_Celular.setText(Util.formatarCelular(clientes.getRtcCelular()));
        jFmtRtc_Cep.setText(Util.formatarCep(clientes.getRtcCep()));
        jFmtRtc_Cpf.setText(Util.formatarCpf(clientes.getRtcCpf()));

        jFmtRtc_DataCadastro.setText(Util.dateToStr(clientes.getRtcDataCadastro()));
        jFmtRtc_DataNascimento.setText(Util.dateToStr(clientes.getRtcDataNascimento()));
        jCboRtc_TipoCliente.setSelectedIndex(clientes.getRtcTipoCliente());
        if (clientes.getRtcAtivo().equals("S")) {
            jChbRtc_Ativo.setSelected(true);
        } else {
            jChbRtc_Ativo.setSelected(false);
        }

        String sexo = clientes.getRtcSexo();
        if (sexo != null) {
            if (sexo.equalsIgnoreCase("M")) {
                jRdBtnRtc_M.setSelected(true);
            } else if (sexo.equalsIgnoreCase("F")) {
                jRdBtnRtc_F.setSelected(true);
            }
        }

        clientePesquisado = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRtc_GrupoSexo = new javax.swing.ButtonGroup();
        jLabel12 = new javax.swing.JLabel();
        jFmtRtc_DataCadastro = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTxtRtc_Nome = new javax.swing.JTextField();
        jCboRtc_TipoCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jChbRtc_Ativo = new javax.swing.JCheckBox();
        jTxtRtc_Email = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRdBtnRtc_M = new javax.swing.JRadioButton();
        jTxtRtc_Endereco = new javax.swing.JTextField();
        jRdBtnRtc_F = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jBtnRtc_Incluir = new javax.swing.JButton();
        jTxtRtc_Bairro = new javax.swing.JTextField();
        jBtnRtc_Alterar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTxtRtc_Cidade = new javax.swing.JTextField();
        jBtnRtc_Excluir = new javax.swing.JButton();
        jBtnRtc_Confirmar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jBtnRtc_Cancelar = new javax.swing.JButton();
        jTxtRtc_Estado = new javax.swing.JTextField();
        jBtnRtc_Pesquisar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jFmtRtc_Cep = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFmtRtc_Cpf = new javax.swing.JFormattedTextField();
        jFmtRtc_Celular = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jFmtRtc_DataNascimento = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtRtc_Codigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel12.setText("Data de Cadastro");

        try {
            jFmtRtc_DataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("Nome");

        jLabel13.setText("Tipo de Cliente");

        jCboRtc_TipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gamer", "Designer", "Normal", "Colaborador ", "Expert " }));

        jLabel3.setText("E-mail");

        jChbRtc_Ativo.setText("Ativo");

        jLabel14.setText("Sexo");

        jLabel4.setText("Endereço");

        btnRtc_GrupoSexo.add(jRdBtnRtc_M);
        jRdBtnRtc_M.setText("M");

        btnRtc_GrupoSexo.add(jRdBtnRtc_F);
        jRdBtnRtc_F.setText("F");

        jLabel5.setText("Bairro");

        jBtnRtc_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnRtc_Incluir.setText("Incluir");
        jBtnRtc_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_IncluirActionPerformed(evt);
            }
        });

        jBtnRtc_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnRtc_Alterar.setText("Alterar");
        jBtnRtc_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_AlterarActionPerformed(evt);
            }
        });

        jLabel6.setText("Cidade");

        jBtnRtc_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnRtc_Excluir.setText("Excluir");
        jBtnRtc_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_ExcluirActionPerformed(evt);
            }
        });

        jBtnRtc_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        jBtnRtc_Confirmar.setText("Confirmar");
        jBtnRtc_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_ConfirmarActionPerformed(evt);
            }
        });

        jLabel7.setText("Estado");

        jBtnRtc_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnRtc_Cancelar.setText("Cancelar");
        jBtnRtc_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_CancelarActionPerformed(evt);
            }
        });

        jBtnRtc_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnRtc_Pesquisar.setText("Pesquisar");
        jBtnRtc_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_PesquisarActionPerformed(evt);
            }
        });

        jLabel8.setText("CEP");

        try {
            jFmtRtc_Cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("CPF");

        jLabel10.setText("Celular");

        try {
            jFmtRtc_Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFmtRtc_Celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Data de Nascimento");

        try {
            jFmtRtc_DataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Código");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtRtc_Nome)
                            .addComponent(jTxtRtc_Email)
                            .addComponent(jTxtRtc_Endereco)
                            .addComponent(jTxtRtc_Bairro)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtRtc_Cidade)
                                    .addComponent(jFmtRtc_Cep)
                                    .addComponent(jFmtRtc_Cpf)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jFmtRtc_Celular))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jChbRtc_Ativo)
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTxtRtc_Estado, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jCboRtc_TipoCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, 138, Short.MAX_VALUE)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jFmtRtc_DataNascimento, javax.swing.GroupLayout.Alignment.LEADING))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(54, 54, 54))
                                            .addComponent(jFmtRtc_DataCadastro)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRdBtnRtc_M)
                                                .addGap(18, 18, 18)
                                                .addComponent(jRdBtnRtc_F)))))
                                .addGap(55, 55, 55))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jTxtRtc_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnRtc_Incluir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnRtc_Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnRtc_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnRtc_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jBtnRtc_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnRtc_Pesquisar)))
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtRtc_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtRtc_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtRtc_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtRtc_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtRtc_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtRtc_Cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtRtc_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmtRtc_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCboRtc_TipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jRdBtnRtc_M)
                            .addComponent(jRdBtnRtc_F))
                        .addGap(9, 9, 9)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmtRtc_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jChbRtc_Ativo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTxtRtc_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmtRtc_DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtRtc_DataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRtc_Incluir)
                    .addComponent(jBtnRtc_Alterar)
                    .addComponent(jBtnRtc_Excluir)
                    .addComponent(jBtnRtc_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtnRtc_Cancelar)
                    .addComponent(jBtnRtc_Pesquisar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRtc_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_IncluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtRtc_Codigo, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M, jBtnRtc_Confirmar, jBtnRtc_Cancelar);
        Util.habilitar(false, jBtnRtc_Incluir, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnRtc_Pesquisar);
        Util.limpar(jTxtRtc_Codigo, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M);
        jTxtRtc_Codigo.grabFocus();
        incluir = true;

        
    }//GEN-LAST:event_jBtnRtc_IncluirActionPerformed

    private void jBtnRtc_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_AlterarActionPerformed
        // TODO add your handling code here:
        if (!clientePesquisado) {
            Util.aviso("Pesquise algum cliente antes de alterar!");
            return;
        }

        Util.habilitar(true, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M, jBtnRtc_Confirmar, jBtnRtc_Cancelar);
        Util.habilitar(false, jBtnRtc_Incluir, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnRtc_Pesquisar);
        jTxtRtc_Nome.grabFocus();
        incluir = false;
    }//GEN-LAST:event_jBtnRtc_AlterarActionPerformed

    private void jBtnRtc_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_ConfirmarActionPerformed
        // TODO add your handling code here:
        RtcCliente clientes = viewBean();
        Rtc_ClientesDAO rtc_ClientesDAO = new Rtc_ClientesDAO();

        if (incluir == true) {
            rtc_ClientesDAO.insert(viewBean());
        } else {
            rtc_ClientesDAO.update(viewBean());
        }

        Util.habilitar(false, jTxtRtc_Codigo, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M, jBtnRtc_Confirmar, jBtnRtc_Cancelar);
        Util.habilitar(true, jBtnRtc_Incluir, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnRtc_Pesquisar);
        Util.limpar(jTxtRtc_Codigo, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M);

    }//GEN-LAST:event_jBtnRtc_ConfirmarActionPerformed

    private void jBtnRtc_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_CancelarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtRtc_Codigo, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M, jBtnRtc_Confirmar, jBtnRtc_Cancelar);
        Util.habilitar(true, jBtnRtc_Incluir, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnRtc_Pesquisar);
        Util.limpar(jTxtRtc_Codigo, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M);

        clientePesquisado = false;
    }//GEN-LAST:event_jBtnRtc_CancelarActionPerformed

    private void jBtnRtc_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_PesquisarActionPerformed
        // TODO add your handling code here:
        JDlgRtc_ClientesPesquisar jDlgClientesPesquisar = new JDlgRtc_ClientesPesquisar(null, true);
        jDlgClientesPesquisar.setTelaPai(this);
        jDlgClientesPesquisar.setVisible(true);
    }//GEN-LAST:event_jBtnRtc_PesquisarActionPerformed

    private void jBtnRtc_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_ExcluirActionPerformed
        // TODO add your handling code here:
        if (!clientePesquisado) {
            Util.aviso("Pesquise algum cliente antes de excluir!");
            return;
        }

        if (Util.perguntar("Deseja Excluir?") == true) {
            Rtc_ClientesDAO rtc_ClientesDAO = new Rtc_ClientesDAO();
            rtc_ClientesDAO.delete(viewBean());
        }

        Util.limpar(jTxtRtc_Codigo, jTxtRtc_Nome, jTxtRtc_Email, jTxtRtc_Endereco, jTxtRtc_Cidade, jTxtRtc_Bairro, jTxtRtc_Estado, jFmtRtc_Cep, jFmtRtc_Cpf, jFmtRtc_Celular, jFmtRtc_DataCadastro, jFmtRtc_DataNascimento, jCboRtc_TipoCliente, jChbRtc_Ativo, jRdBtnRtc_F, jRdBtnRtc_M);
        clientePesquisado = false;
    }//GEN-LAST:event_jBtnRtc_ExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgRtc_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgRtc_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgRtc_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgRtc_Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgRtc_Clientes dialog = new JDlgRtc_Clientes(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup btnRtc_GrupoSexo;
    private javax.swing.JButton jBtnRtc_Alterar;
    private javax.swing.JButton jBtnRtc_Cancelar;
    private javax.swing.JButton jBtnRtc_Confirmar;
    private javax.swing.JButton jBtnRtc_Excluir;
    private javax.swing.JButton jBtnRtc_Incluir;
    private javax.swing.JButton jBtnRtc_Pesquisar;
    private javax.swing.JComboBox<String> jCboRtc_TipoCliente;
    private javax.swing.JCheckBox jChbRtc_Ativo;
    private javax.swing.JFormattedTextField jFmtRtc_Celular;
    private javax.swing.JFormattedTextField jFmtRtc_Cep;
    private javax.swing.JFormattedTextField jFmtRtc_Cpf;
    private javax.swing.JFormattedTextField jFmtRtc_DataCadastro;
    private javax.swing.JFormattedTextField jFmtRtc_DataNascimento;
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
    private javax.swing.JRadioButton jRdBtnRtc_F;
    private javax.swing.JRadioButton jRdBtnRtc_M;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTxtRtc_Bairro;
    private javax.swing.JTextField jTxtRtc_Cidade;
    private javax.swing.JTextField jTxtRtc_Codigo;
    private javax.swing.JTextField jTxtRtc_Email;
    private javax.swing.JTextField jTxtRtc_Endereco;
    private javax.swing.JTextField jTxtRtc_Estado;
    private javax.swing.JTextField jTxtRtc_Nome;
    // End of variables declaration//GEN-END:variables
}
