/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Servico;

/**
 *
 * @author diegomorelo
 */
public class TMCadServico extends AbstractTableModel{
    
    private List<Object> lista;
    
//idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido, tipoSevico
    private final int COL_ID = 0;   
    private final int COL_TECNICO = 1;    
    private final int COL_CLIENTE = 2;
    private final int COL_VALOR = 3;
    private final int COL_DESCRICAO = 4;
    private final int COL_DATA = 5;
    private final int COL_CONCLUIDO = 6;
    private final int COL_TIPO = 7;
    
    public TMCadServico(List<Object> lstServicos){
        lista = lstServicos;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8; // Número de colunas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servico aux = new Servico();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Servico) lista.get(rowIndex);
            // Verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_ID:
                    return aux.getIdServico();
                case COL_TECNICO:
                    return aux.getTecnico();
                case COL_CLIENTE:
                    return aux.getCliente();
                case COL_VALOR:
                    return aux.getValor();
                case COL_DESCRICAO:
                    return aux.getDescricaoServico();
                case COL_DATA:
                    return aux.getDataServico();
                case COL_CONCLUIDO:
                    return aux.isConcluido();
                case COL_TIPO:
                    return aux.getTipoServico();
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
            case COL_TECNICO:
                return "Técnico";
            case COL_CLIENTE:
                return "Cliente";
            case COL_VALOR:
                return "Valor";
            case COL_DESCRICAO:
                return "Descricao";
            case COL_DATA:
                return "Data";
            case COL_CONCLUIDO:
                return "Concluido?";
            case COL_TIPO:
                return "Tipo";
            default:
                break;
        }

        return "";
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        // Aqui você pode definir o tipo de dados das colunas, por exemplo, Double.class para COL_PRECO
        return String.class; // Neste exemplo, todas as colunas são tratadas como Strings
    }
    
}
