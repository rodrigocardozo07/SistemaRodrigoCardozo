/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RtcVendedor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jaque
 */
public class Rtc_ControllerVendedor extends AbstractTableModel{
    
     private List lstVendedores;

    public void setList(List lstVendedores) {
        this.lstVendedores = lstVendedores;
    }
    
    public RtcVendedor getBean(int rowIndex) {
        return (RtcVendedor) lstVendedores.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendedores.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RtcVendedor rtc_vendedores = (RtcVendedor) lstVendedores.get( rowIndex);
        if ( columnIndex == 0 ){
            return rtc_vendedores.getRtcIdvendedor();
        } else if (columnIndex ==1) {
            return rtc_vendedores.getRtcNome();        
        } else if (columnIndex ==2) {
            return rtc_vendedores.getRtcCnpj();
        } else if (columnIndex ==3) {
            return rtc_vendedores.getRtcTelefone();
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
            return "Cnpj";
        } else if ( columnIndex == 3) {
            return "Telefone";
        } 
        return "";
    }
}
