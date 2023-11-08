/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.util.HashSet;
import model.Cliente;
import model.RelatorioRede;
import model.Tecnico;
import model.exceptions.RelatorioRedeException;

/**
 *
 * @author diego
 */
public class RelatorioRedeValidate extends RelatorioValidate {
    
    public RelatorioRede validaCamposEntrada(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado, Tecnico tecnicoResponsavel, String tipoRede){
        RelatorioRede relatorioRede = new RelatorioRede();
        relatorioRede = (RelatorioRede) super.validaCamposEntrada(relatorioRede, idRelatorio, dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel);
        
        if(tipoRede.isBlank()){
            throw new RelatorioRedeException("Error - Campo vazio - 'tipoRede'");
        }
        relatorioRede.setTipoRede(tipoRede);
        
        
        return relatorioRede;
    }
    
}
