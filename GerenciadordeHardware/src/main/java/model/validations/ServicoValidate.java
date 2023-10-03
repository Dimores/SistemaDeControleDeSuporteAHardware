/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Cliente;
import model.Servico;
import model.Tecnico;

/**
 *
 * @author diegomorelo
 */
public class ServicoValidate {
    
    public Servico validaCamposEntrada(String idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico, String dataServico, boolean concluido, String tipoServico){
        Servico servico = new Servico( idServico,  tecnicoResponsavel,  clienteAtendido,  valor,  descricaoServico,  dataServico,  concluido,  tipoServico);
            
        return servico;
    }
    
}
