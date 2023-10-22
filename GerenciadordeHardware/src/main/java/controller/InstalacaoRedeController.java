/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Calendar;
import javax.swing.JTable;
import model.*;
import lombok.*;
import model.exceptions.InstalacaoRedeException;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class InstalacaoRedeController extends ServicoController {
    //InstalacaoRedeDAO repositorio;
    
    public InstalacaoRedeController() {
        //repositorio = new InstalacaoRedeDAO();
    }
    
    public void atualizarInstalacaoRede(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                          String dataServico, String dataConclusao, boolean concluido, String tipoRede, String enderecoRede){
        
        //InstalacaoRedeValidate valid = new InstalacaoRedeValidate(); 
        /*InstalacaoRede novaInstalacaoRede = valid.validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                String dataServico, String dataConclusao, boolean concluido, String tipoRede, String enderecoRede); */
        //novaInstalacaoRede.setIdServico(idServico); 
        
        //repositorio.update(novaInstalacaoRede);
        
    }
    
    public void cadastrarInstalacaoRede(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                          String dataServico, String dataConclusao, boolean concluido, String tipoRede, String enderecoRede){
        //InstalacaoRedeValidate valid = new InstalacaoRedeValidate(); 
        /*InstalacaoRede novaInstalacaoRede = valid.validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                String dataServico, String dataConclusao, boolean concluido, String tipoRede, String enderecoRede); */
        
        //repositorio.save(novaInstalacaoRede);
    }
    
    public void buscarInstalacaoRede(){
        
    }
    
    @Override
    public void atualizarTabela(JTable grd){
        
    }
    
    public void excluirInstalacaoRede(InstalacaoRede instalacaoRede){
        if(instalacaoRede != null){
            //repositorio.save(instalacaoRede);
        }else{
            throw new InstalacaoRedeException("Error - Instalacao de Rede inexistente."); // Alterado de AlunoException para TecnicoException
        }
    }
}
