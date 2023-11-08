/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import lombok.*;
import model.interfaces.IUsuario;

import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;



@Getter //constroi os metodos get
@Setter //constroi os metodos set

/**
 *
 * @author ruiz
 */


@Entity
@DiscriminatorValue("GERENTE")
public class Gerente extends Usuario implements IUsuario {
    private Long id;
    private double salario;
    private String departamento;

    public Gerente() {
        super();
        this.id = 0L;
        this.salario = 0.0;
        this.departamento = "";
    }

    public Gerente(Long id, double salario, String nome, String CPF, String dataNasc, String senha, String email, String telefone, String departamento) {
        super(nome, CPF, dataNasc, senha, email, telefone);
        this.id = 0L;
        this.salario = salario;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        String txt = "Nome: " + this.nome + "\n"
                + "CPF: " + this.CPF + "\n"
                + "Data de Nascimento: " + this.dataNasc+ "\n"
                + "Senha: " + this.senha + "\n"
                + "Email: " + this.email + "\n"
                + "Telefone: " + this.telefone + "\n"
                + "ID: " + this.id + "\n"
                + "Salário: " + this.salario + "\n"
                + "Departamento: " + this.departamento + "\n";
        return txt;
    }

    public void copiar(Gerente outro) {
        super.setNome(outro.getNome());
        super.setCPF(outro.getCPF());
        super.setDataNasc(outro.getDataNasc());
        super.setSenha(outro.getSenha());
        super.setEmail(outro.getEmail());
        super.setTelefone(outro.getTelefone());
        this.setId(outro.getId());
        this.setSalario(outro.getSalario());
        this.setDepartamento(outro.getDepartamento());
    }

    public String cabecalho() {
        return "Nome;CPF;Data de Nascimento;Senha;Email;Telefone;ID;Salário;Departamento\n";
    }

    public String atributoToCSV() {
        String aux = this.nome + ";" +
                this.CPF + ";" +
                this.dataNasc + ";" +
                this.senha + ";" +
                this.email + ";" +
                this.telefone + ";" +
                this.id + ";" +
                this.salario + ";" +
                this.departamento + "\n";
        return aux;
    }

    public void CSVToAtributo(String csv) {
        String vetor[] = csv.split(";");

        this.nome = vetor[0];
        this.CPF = vetor[1];
        // Converter a string de data para um objeto Calendar, se necessário
        // Exemplo: this.dataNasc = converterStringParaCalendar(vetor[2]);
        this.senha = vetor[3];
        this.email = vetor[4];
        this.telefone = vetor[5];
        this.id = Long.parseLong(vetor[6]);
        this.salario = Double.parseDouble(vetor[7]);
        this.departamento = vetor[8];
    }
}


