/*
 * To change this license header, choose License Headers in ProjetoBD Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.ConsertoComputador;
import model.ManutencaoPreventiva;

/**
 *
 * @author diego
 */
public class TMManutencaoPreventiva extends AbstractTableModel {

    private List<Object> lista;
    private Object manutencaoPreventiva;
    
    //private final int COL_ID = 0;       
    private final int COL_CONCLUIDO = 0;
    private final int COL_DATA_SERVICO = 1;
    private final int COL_DESCRICAO_SERVICO = 2;
    private final int COL_VALOR = 3;
    private final int COL_EQUIPAMENTOS = 4;

    public TMManutencaoPreventiva(List<Object> lstManutencaoPreventiva) {        
        lista = lstManutencaoPreventiva;        
    }
    
    public TMManutencaoPreventiva(Object manutencaoPreventiva){
        this.manutencaoPreventiva = manutencaoPreventiva;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        ManutencaoPreventiva aux = new ManutencaoPreventiva();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (ManutencaoPreventiva) lista.get(rowIndex);

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
                case COL_EQUIPAMENTOS:
                    return aux.getEquipamentos();              
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
            case COL_EQUIPAMENTOS:
                return "Equipamentos";
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
