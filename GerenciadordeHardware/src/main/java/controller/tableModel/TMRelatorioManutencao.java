/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.RelatorioManutencao;
import model.RelatorioRede;

/**
 *
 * @author diego
 */
public class TMRelatorioManutencao extends AbstractTableModel {
    
    private List<Object> lista;
    
    public TMRelatorioManutencao(List<Object> listaRelatoriosManutencao) {
        this.lista = listaRelatoriosManutencao;
    }

    private final int COL_CONCLUIDO = 0;
    private final int COL_DATA = 1;
    private final int COL_DESCRICAO = 2;    
    private final int COL_EQUIPAMENTOS = 3;
    private final int COL_NOME_CLIENTE = 4;  
    private final int COL_NOME_TECNICO = 5;  
    private final int COL_PAGO = 6;
    
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
        RelatorioManutencao aux = new RelatorioManutencao();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (RelatorioManutencao) lista.get(rowIndex);

            //verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_DATA:
                    return aux.getDataRelatorio();
                case COL_DESCRICAO:
                    return aux.getDescricao();
                case COL_EQUIPAMENTOS:
                    return aux.getEquipamentos();
                case COL_NOME_CLIENTE:
                    return aux.getCliente().getNome();
                case COL_NOME_TECNICO:
                    return aux.getTecnico().getNome();
                case COL_PAGO:
                    
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
            case COL_DESCRICAO:
                return "Descricao"; 
            case COL_EQUIPAMENTOS:
                return "Equipamentos";
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
