/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Cliente;
import model.Relatorio;
import model.Tecnico;
import model.exceptions.RelatorioException;

/**
 *
 * @author diegomorelo
 */
public class RelatorioValidate {
    
    public Relatorio validaCamposEntrada(Relatorio relatorio, Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado, Tecnico tecnicoResponsavel){        
 

        // Verificando se a data é válida
        String[] dataFormatada = dataRelatorio.split("/"); // Tirando as / e colocando dia, mes e ano em um vetor de 3 posições
        
        int dia = Integer.parseInt(dataFormatada[0]);
        int mes = Integer.parseInt(dataFormatada[1]);
        int ano = Integer.parseInt(dataFormatada[2]);
        
        // Verificando se o dia é inválido
        if(dia > 31){
            throw new RelatorioException("Error - Data inválida - 'dia'");
        }
        
        // Verificando se o mês é inválido
        if(mes > 12){
            throw new RelatorioException("Error - Data inválida - 'mes'");
        }
        
        // Verificando se o ano é inválido(tolerância de 100 anos)
        if(ano <= 1923){
            throw new RelatorioException("Error - Data inválida - 'ano'");
        }        
        // Setando a data correta
        relatorio.setDataRelatorio(dataRelatorio);
        
        if(descricao.isBlank()){
            throw new RelatorioException("Error - Campo vazio - 'descricao'");
        }
        relatorio.setDescricao(descricao);
        
        if(clienteRelacionado == null){
            throw new RelatorioException("Error - Campo nulo - 'cliente'");
        }
        relatorio.setCliente(clienteRelacionado);
        
        if(tecnicoResponsavel == null){
            throw new RelatorioException("Error - Campo nulo - 'tecnico'");
        }
        relatorio.setTecnico(tecnicoResponsavel);
        
        return relatorio;
    }
    
}
