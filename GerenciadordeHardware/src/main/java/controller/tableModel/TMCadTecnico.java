/*
 * To change this license header, choose License Headers in ProjetoBD Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tableModel;

import java.awt.Color;
import model.Tecnico;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author diego
 */
public class TMCadTecnico extends AbstractTableModel {

    private List<Object> lista;
    private Object tecnico;
    
    
    //private final int COL_ID = 0;   
    private final int COL_NOME = 0;
    private final int COL_SALARIO = 1;    
    private final int COL_CPF = 2;
    private final int COL_DATA_NASC = 3;
    //private final int COL_SENHA = 5;
    private final int COL_EMAIL = 4;
    private final int COL_TELEFONE = 5;
    

    public TMCadTecnico(List<Object> lstTecnicos) {        
        lista = lstTecnicos;        
    }
    
    public TMCadTecnico(Object tecnico){
        this.tecnico = tecnico;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Tecnico aux = new Tecnico();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Tecnico) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;

                case COL_SALARIO:
                    return aux.getSalario();
                case COL_NOME:
                    return aux.getNome();
                case COL_CPF:
                    return aux.getCPF();
                case COL_DATA_NASC:
                    return aux.getDataNasc();
                case COL_EMAIL:
                    return aux.getEmail();
                case COL_TELEFONE:
                    return aux.getTelefone();
               
                default: 
                    break;
            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        
        switch (column) {
            case COL_SALARIO:
                return "Salário";
            case COL_NOME:
                return "Nome"; 
            case COL_CPF:
                return "CPF";
            case COL_DATA_NASC:
                return "Data de Nascimento";
            case COL_EMAIL:
                return "Email";
            case COL_TELEFONE:
                return "Telefone";
            
            default:
                break;
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
//        if(columnIndex == COL_MATRICULA)
//            return Boolean.class;
        
        return String.class;
    }

}
