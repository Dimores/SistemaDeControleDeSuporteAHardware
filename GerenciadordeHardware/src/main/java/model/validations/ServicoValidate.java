/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.util.HashSet;
import java.util.Set;
import model.Cliente;
import model.Servico;
import model.Tecnico;
import model.exceptions.ServicoException;

/**
 *
 * @author diegomorelo
 */
public class ServicoValidate {
    
    public Servico validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico, String dataServico, boolean concluido){
        Servico servico = new Servico();
        
        // Verificando se o técnico é nulo
        if(tecnicoResponsavel == null){
            throw new ServicoException("Error - Campo vazio - 'Tecnico'");
        }
        servico.setTecnicoResponsavel(tecnicoResponsavel);
        
        // Verificando se o cliente é nulo
        if(clienteAtendido == null){
            throw new ServicoException("Error - Campo vazio - 'Cliente'");
        }
        servico.setClienteAtendido(clienteAtendido);
        
        // Verificando se o preço não é negativo e 0
        if(valor <= 0){
            throw new ServicoException("Error - Numero negativo - 'valor'");
        }
        servico.setValor(valor);
        
        // Verificando se a descrição do servico esta em branco
        if(descricaoServico.isBlank()){
            throw new ServicoException("Error - Campo vazio - 'descricao'");
        }
        servico.setDescricaoServico(descricaoServico);
        
        // Verificando se a data é válida
        String[] dataFormatada = dataServico.split("/"); // Tirando as / e colocando dia, mes e ano em um vetor de 3 posições
        
        int dia = Integer.parseInt(dataFormatada[0]);
        int mes = Integer.parseInt(dataFormatada[1]);
        int ano = Integer.parseInt(dataFormatada[2]);
        
        // Verificando se o dia é inválido
        if(dia > 31){
            throw new ServicoException("Error - Data inválida - 'dia'");
        }
        
        // Verificando se o mês é inválido
        if(mes > 12){
            throw new ServicoException("Error - Data inválida - 'mes'");
        }
        
        // Verificando se o ano é inválido(tolerância de 100 anos)
        if(ano <= 1923){
            throw new ServicoException("Error - Data inválida - 'ano'");
        }        
        // Setando a data correta
        servico.setDataServico(dataServico);
        
        
        return servico;
    }
    
}
