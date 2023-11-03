/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.util.HashSet;
import model.Cliente;
import model.RelatorioManutencao;
import model.Tecnico;
import model.exceptions.RelatorioManutencaoException;

/**
 *
 * @author diego
 */
public class RelatorioManutencaoValidate extends RelatorioValidate {
    
    public RelatorioManutencao validaCamposEntrada(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado, Tecnico tecnicoResponsavel, String equipamentos){
        RelatorioManutencao relatorioManutencao = new RelatorioManutencao();
        relatorioManutencao = (RelatorioManutencao) super.validaCamposEntrada(relatorioManutencao, idRelatorio, dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel);
        
        if(equipamentos.isBlank()){
            throw new RelatorioManutencaoException("Error - Campo vazio - 'equipamentos'");
        }
        relatorioManutencao.setEquipamentos(equipamentos);
        
        
        return relatorioManutencao;
    }
    
}
