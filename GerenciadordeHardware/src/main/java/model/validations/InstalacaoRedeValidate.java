/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Cliente;
import model.InstalacaoRede;
import model.Tecnico;

/**
 *
 * @author diego
 */
public class InstalacaoRedeValidate {
    
    
    public InstalacaoRede validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                          String dataServico, boolean concluido, String tipoRede, String enderecoRede){
        
        InstalacaoRede instalacaoRede = new InstalacaoRede();
        
        // Validação aqui
        instalacaoRede.setTecnicoResponsavel(tecnicoResponsavel);
        instalacaoRede.setClienteAtendido(clienteAtendido);
        instalacaoRede.setValor(valor);
        instalacaoRede.setDescricaoServico(descricaoServico);
        instalacaoRede.setDataServico(dataServico);
        instalacaoRede.setConcluido(concluido);
        instalacaoRede.setTipoRede(tipoRede);
        instalacaoRede.setEnderecoRede(enderecoRede);
        
        return instalacaoRede;
    }
    
}
