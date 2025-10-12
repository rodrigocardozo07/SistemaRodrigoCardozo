/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Jaque
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
        }
    }

    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }

            if (componentes[i] instanceof JComboBox) {
                ((JComboBox<?>) componentes[i]).setSelectedIndex(-1);
            }

            if (componentes[i] instanceof JCheckBox) {
                ((JCheckBox) componentes[i]).setSelected(false);
            }

            if (componentes[i] instanceof JFormattedTextField) {
                ((JFormattedTextField) componentes[i]).setText("");
            }

            if (componentes[i] instanceof JPasswordField) {
                ((JPasswordField) componentes[i]).setText("");
            }
        }
    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }

    public static boolean perguntar(String cad) {
        JOptionPane.showConfirmDialog(null, cad);
        return true;
    }

    public static int strToInt(String cad) {
        if (cad == null || cad.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(cad);
    }

    public static String intToStr(int num) {
        return String.valueOf(num);
    }

    public static double strToDuble(String cad) {
        if (cad == null || cad.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(cad);
    }

    public static String doubleToStr(double num) {
        return String.valueOf(num);
    }

    public static Date strToDate(String cad) {
        try {
            if (cad == null || cad.isEmpty()) {
                return null;
            }
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.parse(cad);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String dateToStr(Date data) {
        if (data == null) {
            return "";
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }

    public static void habilitar(boolean b, JTextField jTxtRtc_Codigo, JTextField jTxtRtc_Nome, JTextField jTxtRtc_Email, JTextField jTxtRtc_Endereco, JTextField jTxtRtc_Bairro, JTextField jTxtRtc_Cidade, JTextField jTxtRtc_Estado, JFormattedTextField jFmtRtc_Cep, JFormattedTextField jFmtRtc_Cpf, JFormattedTextField jFmtRtc_Celular, JFormattedTextField jFmtRtc_DataNascimento, JFormattedTextField jFmtRtc_DataCadastro, JComboBox<String> jCboRtc_TipoCliente, ButtonGroup btnGpSexo, JCheckBox jChbRtc_Ativo, JButton jBtnRtc_Confirmar, JButton jBtnRtc_Cancelar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
