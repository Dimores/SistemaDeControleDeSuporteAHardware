package controller;

import controller.tableModel.TMCadTecnico;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import model.Tecnico;
import model.dao.TecnicoDAO;
import model.exceptions.TecnicoException;
import model.validations.TecnicoValidate;
import utils.Criptografia;


/**
 *
 * @author diego
 */
public class TecnicoController  extends UsuarioController{ 
    private Criptografia crip;
    private TecnicoDAO repositorio; 

    public TecnicoController() {
        repositorio = new TecnicoDAO(); 
    }

    public void cadastrarTecnico(Long id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone) throws NoSuchAlgorithmException, Exception { 
        TecnicoValidate valid = new TecnicoValidate(); 
        this.crip = new Criptografia();
        Tecnico novoTecnico = valid.validaCamposEntrada(id, salario, nome, CPF, dataNasc, senha, email, telefone); 
        novoTecnico.setSenha(crip.encrypt(senha));
        if(repositorio.findByEmail(email) == null){
            repositorio.save(novoTecnico);
        }else{
             throw new TecnicoException("Error - Já existe um tecnico com esta 'Email'.");
        }
    }
    
    public void atualizarTecnico(Long id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone) throws NoSuchAlgorithmException { 
        TecnicoValidate valid = new TecnicoValidate(); 
        this.crip = new Criptografia();
        Tecnico novoTecnico = valid.validaCamposEntrada(id, salario, nome, CPF, dataNasc, senha, email, telefone); 
        novoTecnico.setId(id);
        System.out.println("Senha: "+ senha );
        
        try {
            
            novoTecnico.setSenha(crip.encrypt(senha));
            
        } catch (Exception ex) {
            Logger.getLogger(TecnicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        repositorio.update(novoTecnico);
    }

    public Tecnico buscarTecnico(String email) { // Alterado de buscarAluno para buscarTecnico
        return (Tecnico) this.repositorio.findByEmail(email); // Alterado de Aluno para Tecnico
    }
    
    public Tecnico buscarTecnico(Long id) {
        return (Tecnico) this.repositorio.findbyId(id);   
    }

    public void atualizarTabela(JTable grd) { // Alterado de atualizarTabela para atualizarTabela
        List<Object> lst = repositorio.findAll();

        TMCadTecnico tmTecnico = new TMCadTecnico(lst); // Alterado de TMCadAluno para TMCadTecnico
        grd.setModel(tmTecnico);
    }

    public void excluirTecnico(Tecnico tecnico) { // Alterado de excluirAluno para excluirTecnico
        if (tecnico != null) {
            repositorio.delete(tecnico);
        } else {
            throw new TecnicoException("Error - Técnico inexistente."); // Alterado de AlunoException para TecnicoException
        }
    }    

}
