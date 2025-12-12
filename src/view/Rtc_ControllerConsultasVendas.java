/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import bean.RtcVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class Rtc_ControllerConsultasVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RtcVendas rtcVendas = (RtcVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return rtcVendas.getRtcIdvenda();
        } else if (columnIndex ==1) {
            return rtcVendas.getRtcStatusvenda();        
        } else if (columnIndex ==2) {
            return rtcVendas.getRtcTotal();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Status Venda";         
        } else if ( columnIndex == 2) {
            return "Total";
        }
        return "";
    }
}
