/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import lombok.*;
import model.interfaces.IUsuario;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
 

/**
 *
 * @author ruiz
 */
public class Usuario implements IUsuario{
    String nome;
    String CPF;
    String dataNasc;
    String senha;
    String email;
    String telefone;

    public Usuario() {
        this.nome = "";
        this.CPF = "";
        this.dataNasc = " ";
        this.senha = "";
        this.email = "";
        this.telefone = "";
    }

    public Usuario(String nome, String CPF, String dataNasc, String senha, String email, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNasc = dataNasc;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        String txt = "Nome: " + this.nome + "\n"
                + "CPF: " + this.CPF + "\n"
                + "Data de Nascimento: " + this.dataNasc + "\n"
                + "Senha: " + this.senha + "\n"
                + "Email: " + this.email + "\n"
                + "Telefone: " + this.telefone + "\n";
        return txt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Usuario usuario = (Usuario) obj;

        if (!nome.equals(usuario.nome)) return false;
        if (!CPF.equals(usuario.CPF)) return false;
        if (!dataNasc.equals(usuario.dataNasc)) return false;
        if (!senha.equals(usuario.senha)) return false;
        if (!email.equals(usuario.email)) return false;
        return telefone.equals(usuario.telefone);
    }

    @Override
    public void copiar(Usuario outro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}