/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RtcProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jaque
 */
public class Rtc_ControllerProdutos extends AbstractTableModel{
    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
    }
    
    public RtcProduto getBean(int rowIndex) {
        return (RtcProduto) lstProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RtcProduto rtc_produtos = (RtcProduto) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return rtc_produtos.getRtcIdproduto();
        } else if (columnIndex ==1) {
            return rtc_produtos.getRtcNome();        
        } else if (columnIndex ==2) {
            return rtc_produtos.getRtcDescricao();
        } else if (columnIndex ==3) {
            return rtc_produtos.getRtcPreco();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Descrição";
        } else if ( columnIndex == 3) {
            return "Preço";
        } 
        return "";
    }
}
