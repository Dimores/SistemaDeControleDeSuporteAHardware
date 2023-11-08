/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.FeedBack;
import model.RelatorioRede;

/**
 *
 * @author diego
 */
public class TMCadFeedBack extends AbstractTableModel {
    
    private List<Object> lista;
    
    public TMCadFeedBack(List<Object> listaFeedBack) {
        this.lista = listaFeedBack;
    }
    
    private final int COL_DATA = 0;
    private final int COL_SERVICO = 1;
    private final int COL_NOTA = 2; 
    private final int COL_COMENTARIO = 3;   
    private final int COL_NOME_CLIENTE = 4;  
    private final int COL_NOME_TECNICO = 5;  

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
       FeedBack aux = new FeedBack();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (FeedBack) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_DATA:
                    return aux.getDataFeedBack();
                case COL_SERVICO:
                    return aux.getServico().getClass().toString().replace("class model.", "");
                case COL_COMENTARIO:
                    return aux.getComentário();
                case COL_NOTA:
                    return aux.getNotaServico();
                case COL_NOME_CLIENTE:
                    return aux.getServico().getClienteAtendido().getNome();
                case COL_NOME_TECNICO:
                    return aux.getServico().getTecnicoResponsavel().getNome();           
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
            case COL_DATA:
                return "Data";
            case COL_NOTA:
                return "Nota";
            case COL_SERVICO:
                return "Serviço";
            case COL_COMENTARIO:
                return "COMENTARIO";
            case COL_NOME_CLIENTE:
                return "Cliente";
            case COL_NOME_TECNICO:
                return "Tecnico";           
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
