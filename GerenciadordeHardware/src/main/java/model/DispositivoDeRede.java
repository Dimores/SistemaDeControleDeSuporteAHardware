/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
public class DispositivoDeRede extends Produto {
    private Long id;
    private String nome;
    private String enderecoIP;
    private String tipo;
    private String fabricante;
    private String modelo;
    private double preco;

    public DispositivoDeRede() {
        this.id = 0L;
        this.nome = "";
        this.enderecoIP = "";
        this.tipo = "";
        this.fabricante = "";
        this.modelo = "";
        this.preco = 0.0;
    }

    public DispositivoDeRede(Long id,String nome, String enderecoIP, String tipo, String fabricante, String modelo, double preco) {
        this.id = id;
        this.nome = nome;
        this.enderecoIP = enderecoIP;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.preco = preco;
    }

    @Override
    public String toString() {
        String txt = "Nome: " + this.nome + "\n"
                + "Endereço IP: " + this.enderecoIP + "\n"
                + "Tipo: " + this.tipo + "\n"
                + "Fabricante: " + this.fabricante + "\n"
                + "Modelo: " + this.modelo + "\n";
        return txt;
    }

    public void copiar(DispositivoDeRede outro) {
        this.nome = outro.getNome();
        this.enderecoIP = outro.getEnderecoIP();
        this.tipo = outro.getTipo();
        this.fabricante = outro.getFabricante();
        this.modelo = outro.getModelo();
    }

    public String cabecalho() {
        return "Nome;Endereço IP;Tipo;Fabricante;Modelo\n";
    }

    public String atributoToCSV() {
        return this.nome + ";" +
                this.enderecoIP + ";" +
                this.tipo + ";" +
                this.fabricante + ";" +
                this.modelo + "\n";
    }

    public void CSVToAtributo(String csv) {
        String[] vetor = csv.split(";");
        this.nome = vetor[0];
        this.enderecoIP = vetor[1];
        this.tipo = vetor[2];
        this.fabricante = vetor[3];
        this.modelo = vetor[4];
    }
}

