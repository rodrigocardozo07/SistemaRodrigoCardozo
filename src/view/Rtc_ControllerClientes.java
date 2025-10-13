/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RtcCliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Jaque
 */
public class Rtc_ControllerClientes extends AbstractTableModel{
    
    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    public RtcCliente getBean(int rowIndex) {
        return (RtcCliente) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RtcCliente rtc_clientes = (RtcCliente) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return rtc_clientes.getRtcIdcliente();
        } else if (columnIndex ==1) {
            return rtc_clientes.getRtcNome();        
        } else if (columnIndex ==2) {
            return rtc_clientes.getRtcDataNascimento();
        } else if (columnIndex ==3) {
            return rtc_clientes.getRtcCpf();
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
            return "Data de Nascimento";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
