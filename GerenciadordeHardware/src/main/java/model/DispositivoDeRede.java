/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */
@Entity
@DiscriminatorValue("DISPOSITIVODEREDE")
public class DispositivoDeRede extends Produto {
    
    
    private Long id;
    private String enderecoIP;
    private String fabricante;
    private String modelo;

    public DispositivoDeRede() {
        this.id = 0L;
        this.enderecoIP = "";
        this.fabricante = "";
        this.modelo = "";
    }

    public DispositivoDeRede(Long id, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, 
                                            String enderecoIP, String fabricante, String modelo, boolean isPago) { // Atributos de dispositivo de rede
        super(codigo, nome, descricao, preco, estoque, categoria, dataFabricacao, isPago);
        this.id = id;
        this.enderecoIP = enderecoIP;
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        String txt = "Nome: " + this.getNome() + "\n"
                + "Endereço IP: " + this.enderecoIP + "\n"
                + "Fabricante: " + this.fabricante + "\n"
                + "Modelo: " + this.modelo + "\n";
        return txt;
    }

    public void copiar(DispositivoDeRede outro) {
        this.setNome(outro.getNome());
        this.enderecoIP = outro.getEnderecoIP();
        this.fabricante = outro.getFabricante();
        this.modelo = outro.getModelo();
    }

    public String cabecalho() {
        return "Nome;Endereço IP;Tipo;Fabricante;Modelo\n";
    }

    public String atributoToCSV() {
        return this.getNome() + ";" +
                this.enderecoIP + ";" +
                this.fabricante + ";" +
                this.modelo + "\n";
    }

    public void CSVToAtributo(String csv) {
        String[] vetor = csv.split(";");
        this.setNome(vetor[0]);
        this.enderecoIP = vetor[1];
        this.fabricante = vetor[2];
        this.modelo = vetor[3];
    }
}

