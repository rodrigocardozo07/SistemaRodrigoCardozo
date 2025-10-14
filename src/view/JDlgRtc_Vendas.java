/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Rtc_ClientesDAO;
import bean.RtcCliente;
import bean.RtcVendas;
import bean.RtcVendedor;
import dao.Rtc_VendedorDAO;
import dao.Rtc_VendasDAO;
import java.util.List;
import tools.Util;

/**
 *
 * @author u07855463160
 */
public class JDlgRtc_Vendas extends javax.swing.JDialog {

    boolean incluir = false;
    private boolean vendasPesquisado = false;

    /**
     * Creates new form JDlgVendas
     */
    public JDlgRtc_Vendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Lista de Vendas");
        setLocationRelativeTo(null);
        Util.habilitar(false, jTxtRtc_Codigo, jFmtRtc_Data, jCboRtc_Clientes, jCboRtc_Vendedor, jTxtRtc_Total, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda, jBtnRtc_Confirmar, jBtnRtc_Cancelar, jBtnRtc_IncluirProd, jBtnRtc_AlterarProd, jBtnRtc_ExcluirProd);
        Util.habilitar(true, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnIncluir, jBtnRtc_Pesquisar);

        Rtc_ClientesDAO rtc_clientesDAO = new Rtc_ClientesDAO();
        List lista = (List) rtc_clientesDAO.listAll();
        for (int i = 0; i < lista.size(); i++) {
            jCboRtc_Clientes.addItem((RtcCliente) lista.get(i));
        }

        Rtc_VendedorDAO rtc_vendedorDAO = new Rtc_VendedorDAO();
        List listaVendedor = (List) rtc_vendedorDAO.listAll();
        for (int i = 0; i < listaVendedor.size(); i++) {
            jCboRtc_Vendedor.addItem((RtcVendedor) listaVendedor.get(i));
        }
        
        addPlaceholder(jTxtRtc_Codigo, "Código...");
        addPlaceholder(jTxtRtc_Total, "0,00");
        addPlaceholder(jTxtRtc_FormaPagamento, "Ex: Cartão, Dinheiro");
        addPlaceholder(jTxtRtc_StatusVenda, "Ex: Pendente, Concluída");
        
        
        jTxtRtc_Codigo.setToolTipText("Número único da venda");
        jFmtRtc_Data.setToolTipText("Data da venda no formato DD/MM/AAAA");
        jCboRtc_Clientes.setToolTipText("Selecione o cliente da venda");
        jCboRtc_Vendedor.setToolTipText("Selecione o vendedor responsável");
        jTxtRtc_Total.setToolTipText("Valor total da venda (use ponto para decimais)");
        jTxtRtc_FormaPagamento.setToolTipText("Forma de pagamento utilizada na venda");
        jTxtRtc_StatusVenda.setToolTipText("Status atual da venda");
        jBtnRtc_IncluirProd.setToolTipText("Adicionar produtos à venda");
        jBtnRtc_AlterarProd.setToolTipText("Alterar produto selecionado");
        jBtnRtc_ExcluirProd.setToolTipText("Remover produto selecionado");
        jTblRtc_VendasProdutos.setToolTipText("Lista de produtos incluídos na venda");
    

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

    public RtcVendas viewBean() {
        RtcVendas vendas = new RtcVendas();
        vendas.setRtcIdvenda(Util.strToInt(jTxtRtc_Codigo.getText()));
        vendas.setRtcCliente((RtcCliente) jCboRtc_Clientes.getSelectedItem());
        vendas.setRtcVendedor((RtcVendedor) jCboRtc_Vendedor.getSelectedItem());
        vendas.setRtcDatavenda(Util.strToDate(jFmtRtc_Data.getText()));
        vendas.setRtcTotal(Util.strToDuble(jTxtRtc_Total.getText()));
        vendas.setRtcFormapagamento(jTxtRtc_FormaPagamento.getText());
        vendas.setRtcStatusvenda(jTxtRtc_StatusVenda.getText());
        return vendas;
    }

    public void viewBean(RtcVendas vendas) {
        jTxtRtc_Codigo.setText(String.valueOf(vendas.getRtcIdvenda()));
        jFmtRtc_Data.setText(Util.dateToStr(vendas.getRtcDatavenda()));
        jCboRtc_Clientes.setSelectedItem(vendas.getRtcCliente());
        jCboRtc_Vendedor.setSelectedItem(vendas.getRtcVendedor());
        jTxtRtc_Total.setText(String.valueOf(vendas.getRtcTotal()));
        jTxtRtc_FormaPagamento.setText(vendas.getRtcFormapagamento());
        jTxtRtc_StatusVenda.setText(vendas.getRtcStatusvenda());

        vendasPesquisado = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtRtc_Codigo = new javax.swing.JTextField();
        jFmtRtc_Data = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCboRtc_Vendedor = new javax.swing.JComboBox<RtcVendedor>();
        jTxtRtc_Total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblRtc_VendasProdutos = new javax.swing.JTable();
        jBtnIncluir = new javax.swing.JButton();
        jBtnRtc_Alterar = new javax.swing.JButton();
        jBtnRtc_Excluir = new javax.swing.JButton();
        jBtnRtc_Confirmar = new javax.swing.JButton();
        jBtnRtc_Cancelar = new javax.swing.JButton();
        jBtnRtc_Pesquisar = new javax.swing.JButton();
        jBtnRtc_IncluirProd = new javax.swing.JButton();
        jBtnRtc_AlterarProd = new javax.swing.JButton();
        jBtnRtc_ExcluirProd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtRtc_FormaPagamento = new javax.swing.JTextField();
        jTxtRtc_StatusVenda = new javax.swing.JTextField();
        jCboRtc_Clientes = new javax.swing.JComboBox<RtcCliente>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Num Venda");

        jLabel2.setText("Data");

        jLabel3.setText("Clientes");

        try {
            jFmtRtc_Data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFmtRtc_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtRtc_DataActionPerformed(evt);
            }
        });

        jLabel4.setText("Vendedor");

        jLabel5.setText("Total");

        jCboRtc_Vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboRtc_VendedorActionPerformed(evt);
            }
        });

        jTblRtc_VendasProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTblRtc_VendasProdutos);

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnRtc_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnRtc_Alterar.setText("Alterar");
        jBtnRtc_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_AlterarActionPerformed(evt);
            }
        });

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

        jBtnRtc_IncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnRtc_IncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_IncluirProdActionPerformed(evt);
            }
        });

        jBtnRtc_AlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnRtc_AlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_AlterarProdActionPerformed(evt);
            }
        });

        jBtnRtc_ExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnRtc_ExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRtc_ExcluirProdActionPerformed(evt);
            }
        });

        jLabel6.setText("Forma Pagamento");

        jLabel7.setText("Status Venda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTxtRtc_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFmtRtc_Data, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jTxtRtc_StatusVenda))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jCboRtc_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jCboRtc_Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtRtc_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTxtRtc_FormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBtnIncluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnRtc_Alterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnRtc_Excluir)
                                .addGap(14, 14, 14)
                                .addComponent(jBtnRtc_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnRtc_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnRtc_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnRtc_AlterarProd)
                            .addComponent(jBtnRtc_IncluirProd)
                            .addComponent(jBtnRtc_ExcluirProd))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmtRtc_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboRtc_Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtRtc_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtRtc_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboRtc_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtRtc_FormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtRtc_StatusVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnRtc_IncluirProd)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnRtc_AlterarProd)
                        .addGap(16, 16, 16)
                        .addComponent(jBtnRtc_ExcluirProd))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnIncluir)
                        .addComponent(jBtnRtc_Alterar)
                        .addComponent(jBtnRtc_Excluir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnRtc_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnRtc_Cancelar)
                        .addComponent(jBtnRtc_Pesquisar)))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxtRtc_Codigo, jFmtRtc_Data, jCboRtc_Clientes, jCboRtc_Vendedor, jTxtRtc_Total, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda, jBtnRtc_Confirmar, jBtnRtc_Cancelar, jBtnRtc_IncluirProd, jBtnRtc_AlterarProd, jBtnRtc_ExcluirProd);
        Util.habilitar(false, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnIncluir, jBtnRtc_Pesquisar);
        Util.limpar(jTxtRtc_Codigo, jFmtRtc_Data, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda, jTxtRtc_Total);
        jTxtRtc_Codigo.grabFocus();
        incluir = true;

    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnRtc_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_AlterarActionPerformed
        // TODO add your handling code here:
        if (!vendasPesquisado) {
            Util.aviso("Pesquise alguma venda antes de alterar!");
            return;
        }

        Util.habilitar(true, jFmtRtc_Data, jTxtRtc_Total, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda, jBtnRtc_Confirmar, jBtnRtc_Cancelar);
        Util.habilitar(false, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnIncluir, jBtnRtc_Pesquisar);
        jFmtRtc_Data.grabFocus();
        incluir = false;
    }//GEN-LAST:event_jBtnRtc_AlterarActionPerformed

    private void jBtnRtc_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_ExcluirActionPerformed
        // TODO add your handling code here:
        if (!vendasPesquisado) {
            Util.aviso("Pesquise alguma venda antes de excluir!");
            return;
        }

        if (Util.perguntar("Deseja Excluir?") == true) {
            Rtc_VendasDAO rtc_VendasDAO = new Rtc_VendasDAO();
            rtc_VendasDAO.delete(viewBean());
        }
        Util.limpar(jTxtRtc_Codigo, jFmtRtc_Data, jCboRtc_Clientes, jCboRtc_Vendedor, jTxtRtc_Total, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda);
        vendasPesquisado = false;
    }//GEN-LAST:event_jBtnRtc_ExcluirActionPerformed

    private void jBtnRtc_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_ConfirmarActionPerformed
        // TODO add your handling code here:
        RtcVendas vendas = viewBean();
        Rtc_VendasDAO rtc_VendasDAO = new Rtc_VendasDAO();

        if (incluir == true) {
            rtc_VendasDAO.insert(viewBean());
        } else {
            rtc_VendasDAO.update(viewBean());
        }

        Util.habilitar(false, jTxtRtc_Codigo, jFmtRtc_Data, jCboRtc_Clientes, jCboRtc_Vendedor, jTxtRtc_Total, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda, jBtnRtc_Confirmar, jBtnRtc_Cancelar, jBtnRtc_IncluirProd, jBtnRtc_AlterarProd, jBtnRtc_ExcluirProd);
        Util.habilitar(true, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnIncluir, jBtnRtc_Pesquisar);
        Util.limpar(jTxtRtc_Codigo, jFmtRtc_Data, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda, jTxtRtc_Total);


    }//GEN-LAST:event_jBtnRtc_ConfirmarActionPerformed

    private void jBtnRtc_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_CancelarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(false, jTxtRtc_Codigo, jFmtRtc_Data, jCboRtc_Clientes, jCboRtc_Vendedor, jTxtRtc_Total, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda, jBtnRtc_Confirmar, jBtnRtc_Cancelar, jBtnRtc_IncluirProd, jBtnRtc_AlterarProd, jBtnRtc_ExcluirProd);
        Util.habilitar(true, jBtnRtc_Alterar, jBtnRtc_Excluir, jBtnIncluir, jBtnRtc_Pesquisar);
        Util.limpar(jTxtRtc_Codigo, jFmtRtc_Data, jTxtRtc_FormaPagamento, jTxtRtc_StatusVenda, jTxtRtc_Total);

        vendasPesquisado = false;
    }//GEN-LAST:event_jBtnRtc_CancelarActionPerformed

    private void jBtnRtc_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_PesquisarActionPerformed
        // TODO add your handling code here:
        JDlgRtc_VendasPesquisar jDlgRtc_VendasPesquisar = new JDlgRtc_VendasPesquisar(null, true);
        jDlgRtc_VendasPesquisar.setTelaPai(this);
        jDlgRtc_VendasPesquisar.setVisible(true);
    }//GEN-LAST:event_jBtnRtc_PesquisarActionPerformed

    private void jFmtRtc_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtRtc_DataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtRtc_DataActionPerformed

    private void jBtnRtc_ExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_ExcluirProdActionPerformed
        // TODO add your handling code here:
        if (Util.perguntar("Deseja excluir o produto?") == true) {

        }
    }//GEN-LAST:event_jBtnRtc_ExcluirProdActionPerformed

    private void jBtnRtc_IncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_IncluirProdActionPerformed
        // TODO add your handling code here:
        JDlgRtc_VendasProdutos jDlgRtc_VendasProdutos = new JDlgRtc_VendasProdutos(null, true);
        jDlgRtc_VendasProdutos.setVisible(true);
    }//GEN-LAST:event_jBtnRtc_IncluirProdActionPerformed

    private void jBtnRtc_AlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRtc_AlterarProdActionPerformed
        // TODO add your handling code here:
        JDlgRtc_VendasProdutos jDlgRtc_VendasProdutos = new JDlgRtc_VendasProdutos(null, true);
        jDlgRtc_VendasProdutos.setVisible(true);
    }//GEN-LAST:event_jBtnRtc_AlterarProdActionPerformed

    private void jCboRtc_VendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboRtc_VendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboRtc_VendedorActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgRtc_Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgRtc_Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgRtc_Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgRtc_Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgRtc_Vendas dialog = new JDlgRtc_Vendas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnRtc_Alterar;
    private javax.swing.JButton jBtnRtc_AlterarProd;
    private javax.swing.JButton jBtnRtc_Cancelar;
    private javax.swing.JButton jBtnRtc_Confirmar;
    private javax.swing.JButton jBtnRtc_Excluir;
    private javax.swing.JButton jBtnRtc_ExcluirProd;
    private javax.swing.JButton jBtnRtc_IncluirProd;
    private javax.swing.JButton jBtnRtc_Pesquisar;
    private javax.swing.JComboBox<RtcCliente> jCboRtc_Clientes;
    private javax.swing.JComboBox<RtcVendedor> jCboRtc_Vendedor;
    private javax.swing.JFormattedTextField jFmtRtc_Data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblRtc_VendasProdutos;
    private javax.swing.JTextField jTxtRtc_Codigo;
    private javax.swing.JTextField jTxtRtc_FormaPagamento;
    private javax.swing.JTextField jTxtRtc_StatusVenda;
    private javax.swing.JTextField jTxtRtc_Total;
    // End of variables declaration//GEN-END:variables
}
