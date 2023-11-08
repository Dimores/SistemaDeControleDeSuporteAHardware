/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.ConsertoComputador;
import model.Tecnico;
import model.exceptions.ConsertoComputadorException;

/**
 *
 * @author diego
 */
public class ConsertoComputadorValidate {
    public ConsertoComputador validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                    String dataServico, boolean concluido, List pecasSubstituidas) {
        // Valide os campos
        if (tecnicoResponsavel == null) {
            throw new ConsertoComputadorException("Técnico responsável não pode ser nulo.");
        }
        if (clienteAtendido == null) {
            throw new ConsertoComputadorException("Cliente atendido não pode ser nulo.");
        }
        if (valor < 0) {
            throw new ConsertoComputadorException("O valor deve ser maior que zero.");
        }
        if (descricaoServico == null || descricaoServico.isEmpty()) {
            throw new ConsertoComputadorException("A descrição do serviço não pode ser vazia.");
        }
        if (dataServico == null || dataServico.isEmpty()) {
            throw new ConsertoComputadorException("A data do serviço não pode ser vazia.");
        }
        
        // Crie a instância de ConsertoComputador
        ConsertoComputador consertoComputador = new ConsertoComputador();
        consertoComputador.setTecnicoResponsavel(tecnicoResponsavel);
        consertoComputador.setClienteAtendido(clienteAtendido);
        consertoComputador.setValor(valor);
        consertoComputador.setDescricaoServico(descricaoServico);
        consertoComputador.setDataServico(dataServico);
        consertoComputador.setConcluido(concluido);
        consertoComputador.setPecasSubstituidas(pecasSubstituidas);

        return consertoComputador;
    }
}

