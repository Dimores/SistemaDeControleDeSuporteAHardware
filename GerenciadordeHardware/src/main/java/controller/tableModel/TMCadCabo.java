/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.tableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cabo;

/**
 *
 * @author diego
 */
public class TMCadCabo extends AbstractTableModel {

    private List<Object> lista;

    private final int COL_NOME = 0;
    private final int COL_CODIGO = 1;
    private final int COL_DESCRICAO = 2;
    private final int COL_PRECO = 3;
    private final int COL_ESTOQUE = 4;
    private final int COL_CATEGORIA = 5;
    private final int COL_DATA_FABRICACAO = 6;
    private final int COL_COMPRIMENTO = 7;
    private final int COL_BITOLA = 8;

    public TMCadCabo(List<Object> lstCabos) {
        lista = lstCabos;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cabo aux = new Cabo();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = (Cabo) lista.get(rowIndex);

            // Verifica qual valor deve ser retornado
            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_CODIGO:
                    return aux.getCodigo();
                case COL_NOME:
                    return aux.getNome();
                case COL_DESCRICAO:
                    return aux.getDescricao();
                case COL_PRECO:
                    return aux.getPreco();
                case COL_ESTOQUE:
                    return aux.getEstoque();
                case COL_CATEGORIA:
                    return aux.getCategoria();
                case COL_DATA_FABRICACAO:
                    return aux.getDataFabricacao();
                case COL_COMPRIMENTO:
                    return aux.getComprimento();
                case COL_BITOLA:
                    return aux.getBitola();
                default:
                    break;
            }
        }
        return aux;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {

            case COL_CODIGO:
                return "Código";
            case COL_NOME:
                return "Nome";
            case COL_DESCRICAO:
                return "Descrição";
            case COL_PRECO:
                return "Preço";
            case COL_ESTOQUE:
                return "Estoque";
            case COL_CATEGORIA:
                return "Categoria";
            case COL_DATA_FABRICACAO:
                return "Data de Fabricação";
            case COL_COMPRIMENTO:
                return "Comprimento";
            case COL_BITOLA:
                return "Bitola";
            default:
                break;
        }

        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        // Aqui você pode definir o tipo de dados das colunas, por exemplo, Double.class para COL_PRECO
        return String.class; // Neste exemplo, todas as colunas são tratadas como Strings
    }

}
