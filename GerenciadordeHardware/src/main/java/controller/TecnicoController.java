package controller;

import controller.tableModel.TMCadTecnico;
import java.util.List;
import javax.swing.JTable;
import model.Tecnico;
import model.dao.TecnicoDAO;
import model.exceptions.TecnicoException;
import model.validations.TecnicoValidate;


/**
 *
 * @author diego
 */
public class TecnicoController  extends UsuarioController{ 

    private TecnicoDAO repositorio; 

    public TecnicoController() {
        repositorio = new TecnicoDAO(); 
    }

    public void cadastrarTecnico(String id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone) { 
        TecnicoValidate valid = new TecnicoValidate(); 
        Tecnico novoTecnico = valid.validaCamposEntrada(id, salario, nome, CPF, dataNasc, senha, email, telefone); 
            if(repositorio.findByEmail(email) == null){
                repositorio.save(novoTecnico);
            }else{
                 throw new TecnicoException("Error - Já existe um tecnico com esta 'Email'.");
            }


    }
    
    public void atualizarTecnico(String id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone) { 
        TecnicoValidate valid = new TecnicoValidate(); 
        Tecnico novoTecnico = valid.validaCamposEntrada(id, salario, nome, CPF, dataNasc, senha, email, telefone); 
        novoTecnico.setId(id);

        repositorio.update(novoTecnico);
    }

    public Tecnico buscarTecnico(String email) { // Alterado de buscarAluno para buscarTecnico
        return (Tecnico) this.repositorio.findByEmail(email); // Alterado de Aluno para Tecnico
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
