/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;
import model.interfaces.IUsuario;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
/**
 *
 * @author ruiz
 */
@Entity

public class Cliente extends Usuario implements IUsuario{
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //String Id;
    
    public Cliente() {
        super();
        this.id = "";
    }

    public Cliente(String idCliente, String nome, String CPF, String dataNasc, String senha, String email, String telefone) {
        super(nome, CPF, dataNasc, senha, email, telefone);
        this.id = idCliente;
    }


    @Override
    public String toString() {
        String txt = "Nome: " + this.nome + "\n"
                + "CPF: " + this.CPF + "\n"
                + "Data de Nascimento: " + this.dataNasc + "\n"
                + "Senha: " + this.senha + "\n"
                + "Email: " + this.email + "\n"
                + "Telefone: " + this.telefone + "\n"
                + "ID do Cliente: " + this.id + "\n";
        return txt;
    }
    
public void copiar(Cliente outro) {
    super.setNome(outro.getNome());
    super.setCPF(outro.getCPF());
    super.setDataNasc(outro.getDataNasc());
    super.setSenha(outro.getSenha());
    super.setEmail(outro.getEmail());
    super.setTelefone(outro.getTelefone());
    this.setId(outro.getId());
}

    
    
    public String cabecalho() {
        return "Nome;CPF;Data de Nascimento;Senha;Email;Telefone;ID do Cliente\n";
    }

    public String atributoToCSV() {
        String aux = this.nome + ";" +
                this.CPF + ";" +
                this.dataNasc+ ";" +
                this.senha + ";" +
                this.email + ";" +
                this.telefone + ";" +
                this.id + "\n";
        return aux;
    }

    /**
     * Preenche os campos do objeto com uma linha CSV
     *
     * @param csv
     */
    public void CSVToAtributo(String csv) {
        String vetor[] = csv.split(";");

        this.nome = vetor[0];
        this.CPF = vetor[1];
        // Converter a string de data para um objeto Calendar, se necessário
        // Exemplo: this.dataNasc = converterStringParaCalendar(vetor[2]);
        this.senha = vetor[3];
        this.email = vetor[4];
        this.telefone = vetor[5];
        this.id = vetor[6];
    }

}

