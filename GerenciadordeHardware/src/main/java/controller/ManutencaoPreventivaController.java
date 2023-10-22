/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JTable;
import model.*;
import lombok.*;
import model.exceptions.ManutencaoPreventivaException;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class ManutencaoPreventivaController extends ServicoController{
    //ManutencaoPreventivaDAO repositorio;
    
    public ManutencaoPreventivaController() {
        //repositorio = new ManutencaoPreventivaDAO();
    }

    
    public void atualizarManutencaoPreventiva(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                            String dataServico, String dataConclusao, boolean concluido, String equipamentos, String descricaoManutencao){
        
        //ManutencaoPreventivaValidate valid = new ManutencaoRedeValidate(); 
        /*ManutencaoPreventivaValidate novaManutencaoPreventiva = valid.validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                String dataServico, String dataConclusao, boolean concluido, String tipoRede, String enderecoRede); */
        //novaManutencaoPreventiva.setIdServico(idServico); 
        
        //repositorio.update(novaManutencaoPreventiva);
        
    }
    
    public void cadastrarManutencaoPreventiva(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                            String dataServico, String dataConclusao, boolean concluido, String equipamentos, String descricaoManutencao){
        
        
        //ManutencaoPreventivaValidate valid = new ManutencaoPreventivaValidate(); 
        /*ManutencaoPreventivaValidate novaManutencaoPreventiva = valid.validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                                String dataServico, String dataConclusao, boolean concluido, String tipoRede, String enderecoRede); */
        
        //repositorio.save(novaManutencaoPreventiva);
        
    }
    
    @Override
    public void atualizarTabela(JTable grd){
        
    }
    
    public void excluirManutencaoPreventiva(ManutencaoPreventiva manutencaoPreventiva){
        if(manutencaoPreventiva != null){
            //repositorio.save(manutencaoPreventiva);
        }else{
            throw new ManutencaoPreventivaException("Error - Manutencao preventiva inexistente.");
        }
        
    }
    
}
