/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import controller.tableModel.TMCadCliente;
import controller.tableModel.TMCadServico;
import controller.tableModel.TMCadTecnico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import lombok.*;
import model.*;
import model.dao.ClienteDAO;
import model.dao.ServicoDAO;
import model.dao.TecnicoDAO;
import model.validations.ServicoValidate;
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
    private TecnicoDAO tecnicoRepositorio;
    private ClienteDAO clienteRepositorio;
    
    public ServicoController(){
        servico = new ServicoDAO();
        tecnicoRepositorio = new TecnicoDAO();
        clienteRepositorio = new ClienteDAO();
        
    }
    
    public void cadastrarServico(String idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico, String dataServico, boolean concluido, String tipoSevico){
        ServicoValidate valid = new ServicoValidate(); 
        Servico novoServico = valid.validaCamposEntrada(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido, tipoSevico); 
        servico.save(novoServico);
    }
    
    public void atualizarServico(String idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico, String dataServico, boolean concluido, String tipoSevico){
        ServicoValidate valid = new ServicoValidate(); 
        Servico novoServico = valid.validaCamposEntrada(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido, tipoSevico); 
        novoServico.setIdServico(idServico);
        servico.update(novoServico);

    }
    
    public void excluirServico(Servico s){
        
    }
    
    // Essa e a tabela de servicos
    public void atualizarTabela(JTable grd){
        List<Object> lst = servico.findAll();
        
        TMCadServico tmServico = new TMCadServico(lst);
        grd.setModel(tmServico);
    }
    
    // Tabela de cliente na tela de cadastro de servicos
    public void atualizarTabelaCliente(JTable grd, Cliente clientePesquisado){
        // Crie uma lista temporária para armazenar o cliente
        List<Object> clienteUnico = new ArrayList<>();

        Cliente cliente = (Cliente) clienteRepositorio.findByEmail(clientePesquisado.getEmail());
        if (cliente != null) 
            clienteUnico.add(cliente);

        // Crie o modelo da tabela com a lista temporária
        TMCadCliente tmCliente = new TMCadCliente(clienteUnico); 
        grd.setModel(tmCliente);
    }

    
    public void atualizarTabelaTecnico(JTable grd, Tecnico tecnicoPesquisado){
        List<Object> tecnicoUnico = new ArrayList<>();

        Tecnico tecnico = (Tecnico) tecnicoRepositorio.findByEmail(tecnicoPesquisado.getEmail());
        if (tecnico != null) 
            tecnicoUnico.add(tecnico);

        // Crie o modelo da tabela com a lista temporária
        TMCadTecnico tmTecnico = new TMCadTecnico(tecnicoUnico); 
        grd.setModel(tmTecnico);
    }
    
    

    public Tecnico buscarTecnico(String email) { // Alterado de buscarAluno para buscarTecnico
        return (Tecnico) this.tecnicoRepositorio.findByEmail(email); // Alterado de Aluno para Tecnico
    }
    
    public Cliente buscarCliente(String email){
        return (Cliente) this.clienteRepositorio.findByEmail(email);
    }
    
}
