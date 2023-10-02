/*
 * To change this license header, choose License Headers in ProjetoBD Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 *
 * @author diego
 */
public class TMCadCliente extends AbstractTableModel {

    private List<Object> lista;
    private Object cliente;
    
    private final int COL_ID = 0;       
    private final int COL_NOME = 1;
    private final int COL_CPF = 2;
    private final int COL_DATA_NASC = 3;
    private final int COL_SENHA = 4;
    private final int COL_EMAIL = 5;
    private final int COL_TELEFONE = 6;
    

    public TMCadCliente(List<Object> lstClientes) {        
        lista = lstClientes;        
    }
    
    public TMCadCliente(Object cliente){
        this.cliente = cliente;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Cliente aux = new Cliente();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Cliente) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_ID:
                    return aux.getId();
                case COL_NOME:
                    return aux.getNome();
                case COL_CPF:
                    return aux.getCPF();
                case COL_DATA_NASC:
                    return aux.getDataNasc();
                case COL_SENHA:
                    return aux.getSenha();
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
            case COL_ID:
                return "ID";
            case COL_NOME:
                return "Nome"; 
            case COL_CPF:
                return "CPF";
            case COL_DATA_NASC:
                return "Data de Nascimento";
            case COL_SENHA:
                return "Senha";
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
