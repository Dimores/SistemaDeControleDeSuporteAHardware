/*
 * To change this license header, choose License Headers in ProjetoBD Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tableModel;

import java.awt.Component;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import model.ConsertoComputador;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author diego
 */
public class TMConsertoComputador extends AbstractTableModel {

    private List<Object> lista;
    private Object consertoComputador;
    
    //private final int COL_ID = 0;       
    private final int COL_CONCLUIDO = 0;
    private final int COL_DATA_SERVICO = 1;
    private final int COL_DESCRICAO_SERVICO = 2;
    private final int COL_VALOR = 3;
    private final int COL_PECASSUBSTITUIDAS = 4;
    private final int COL_PAGO = 5;

    public TMConsertoComputador(List<Object> lstConsertoComputador) {        
        lista = lstConsertoComputador;        
    }
    
    public TMConsertoComputador(Object consertoComputador){
        this.consertoComputador = consertoComputador;
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
        ConsertoComputador aux = new ConsertoComputador();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (ConsertoComputador) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;

                case COL_CONCLUIDO:
                    return aux.isConcluido();
                case COL_DATA_SERVICO:
                    return aux.getDataServico();
                case COL_DESCRICAO_SERVICO:
                    return aux.getDescricaoServico();
                case COL_VALOR:
                    return aux.getValor();
                case COL_PECASSUBSTITUIDAS:
                    return aux.getPecasSubstituidas();
                case COL_PAGO:
                    return aux.isPago();
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
            case COL_CONCLUIDO:
                return "Concluido"; 
            case COL_DATA_SERVICO:
                return "Data";
            case COL_DESCRICAO_SERVICO:
                return "Descricao";
            case COL_VALOR:
                return "Valor";
            case COL_PECASSUBSTITUIDAS:
                return "Pecas";
            case COL_PAGO:
                return "Pago";
            default:
                break;
        }

        return "";
    }
    



}




