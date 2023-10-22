/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import model.*;

import lombok.*;
import model.exceptions.ConsertoComputadorException;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class ConsertoComputadorController extends ServicoController{
    //ConsertoComputadorDAO repositorio;
    
    public ConsertoComputadorController(){
        //repositorio = new ConsertoComputadorDAO();
    }
    
    public void atualizarConsertoComputador(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                        String dataServico, boolean concluido, ArrayList pecasSubstituidas){
        
        //ConsertoComputadorValidate valid = new ConsertoComputadorValidate(); 
        /*ConsertoComputador novoConsertoComputador = valid.validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                        String dataServico, boolean concluido, String descricaoProblema, ArrayList pecasSubstituidas); */
        //novoConsertoComputador.setIdServico(idServico); 
        
        //repositorio.update(novoConsertoComputador);
        
        
    }
    
    public void cadastrarConsertoComputador(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                        String dataServico, boolean concluido, ArrayList pecasSubstituidas){
        //ConsertoComputadorValidate valid = new ConsertoComputadorValidate(); 
        /*ConsertoComputador novoConsertoComputador = valid.validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                        String dataServico, boolean concluido, String descricaoProblema, ArrayList pecasSubstituidas); */
        //repositorio.save(novoConsertoComputador);
    }
    
    public void buscarConsertoComputador(){
        
    }
    
    @Override
    public void atualizarTabela(JTable grd){
        
    }
    
    public void excluirConsertoComputador(ConsertoComputador consertoComputador){
        if(consertoComputador != null){
            //repositorio.save(consertoComputador);
        }else{
            throw new ConsertoComputadorException("Error - ConsertoComputador inexistente."); // Alterado de AlunoException para TecnicoException
        }
        
    }
    
}
