/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.RtcUsuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u09240620109
 */
public class Rtc_ControllerUsuarios extends AbstractTableModel{

    private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    public RtcUsuario getBean(int rowIndex) {
        return (RtcUsuario) lstUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RtcUsuario rtc_usuarios = (RtcUsuario) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return rtc_usuarios.getRtcIdusuarios();
        } else if (columnIndex ==1) {
            return rtc_usuarios.getRtcNome();        
        } else if (columnIndex ==2) {
            return rtc_usuarios.getRtcApelido();
        } else if (columnIndex ==3) {
            return rtc_usuarios.getRtcCpf();
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
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
