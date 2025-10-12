/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RtcVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jaque
 */
public class Rtc_ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstUsuarios) {
        this.lstVendas = lstUsuarios;
    }

    public RtcVendas getBean(int rowIndex) {
        return (RtcVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        if (lstVendas == null) {
            return 0;  // Retorna 0 se a lista for null
        }
        return lstVendas.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RtcVendas rtc_Vendas = (RtcVendas) lstVendas.get(rowIndex);
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
            return "Cliente";
        } else if (columnIndex == 2) {
            return "Vendedor";
        } else if (columnIndex == 3) {
            return "Data";
        }
        return "";
    }
}
