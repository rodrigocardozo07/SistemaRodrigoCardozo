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

    public RtcVendasProdutos getBean(int rowIndex) {
        return (RtcVendasProdutos) lstVendasProd.get(rowIndex);
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
         return lstVendasProd.size();

    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RtcVendasProdutos rtc_VendasProdutos = (RtcVendasProdutos) lstVendasProd.get(rowIndex);
        if (columnIndex == 0) {
            return rtc_VendasProdutos.getRtcProduto().getRtcIdproduto();
        } else if (columnIndex == 1) {
            return rtc_VendasProdutos.getRtcProduto().getRtcNome();
        } else if (columnIndex == 2) {
            return rtc_VendasProdutos.getRtcQuantidade();
        } else if (columnIndex == 3) {
            return rtc_VendasProdutos.getRtcValorunitario();
        } 
        else if (columnIndex == 4) {
            return rtc_VendasProdutos.getRtcDesconto();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Num Venda";
        } else if (columnIndex == 1) {
            return "Nome";
        } else if (columnIndex == 2) {
            return "Quantidade";
        } else if (columnIndex == 3) {
            return "Valor Unitário";
        } else if (columnIndex == 4) {
            return "Desconto";
        }
        return "";
    }
}
