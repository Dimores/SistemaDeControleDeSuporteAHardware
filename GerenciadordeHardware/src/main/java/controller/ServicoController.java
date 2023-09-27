/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import lombok.*;
import model.*;
import model.dao.ServicoDAO;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class ServicoController {
    private ServicoDAO servico;
    
    public ServicoController(){
        servico = new ServicoDAO();
    }
    
    public void cadastrarServico(String idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico, String dataServico, boolean concluido, String tipoSevico){

    }
    

    
    
}
