/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RtcVendas;
import bean.RtcVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jaque
 */
public class Rtc_ControllerVendasProdutos extends AbstractTableModel {

    private List lstVendasProd;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProd = lstVendasProdutos;
        this.fireTableDataChanged();
    }

    public RtcVendas getBean(int rowIndex) {
        return (RtcVendas) lstVendasProd.get(rowIndex);
    }
    
    public void addBean(RtcVendasProdutos rtcVendasProdutos){
        this.lstVendasProd.add(rtcVendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        this.lstVendasProd.remove(rowIndex); 
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        if (lstVendasProd == null) {
            return 0;  // Retorna 0 se a lista for null
        }
        return lstVendasProd.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RtcVendas rtc_Vendas = (RtcVendas) lstVendasProd.get(rowIndex);
        if (columnIndex == 0) {
            return rtc_Vendas.getRtcIdvenda();
        } else if (columnIndex == 1) {
            return rtc_Vendas.getRtcCliente();
        } else if (columnIndex == 2) {
            return rtc_Vendas.getRtcVendedor();
        } else if (columnIndex == 3) {
            return rtc_Vendas.getRtcDatavenda();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Num Venda";
        } else if (columnIndex == 1) {
            return "Quantidade";
        } else if (columnIndex == 2) {
            return "Valor Unitário";
        } else if (columnIndex == 3) {
            return "Desconto";
        }
        return "";
    }
}
