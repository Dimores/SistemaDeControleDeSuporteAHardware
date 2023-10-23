/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set

/**
 *
 * @author ruiz
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Produto {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int estoque;
    private String categoria;
    private String dataFabricacao;
    
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Peca> pecas;
    
    public Produto(){
        this.codigo = "";
        this.nome = "";
        this.descricao = "";
        this.preco = 0.0;
        this.estoque = 0;
        this.categoria = "";
        this.dataFabricacao = "";
    }
    
    
   public Produto(String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String toString() {
        String txt = "Código: " + this.codigo + "\n"
                + "Nome: " + this.nome + "\n"
                + "Descrição: " + this.descricao + "\n"
                + "Preço: " + this.preco + "\n"
                + "Estoque: " + this.estoque + "\n"
                + "Categoria: " + this.categoria + "\n"
                + "Data de Fabricação: " + this.dataFabricacao + "\n";
        return txt;
    }

    public void copiar(Produto outro) {
        this.codigo = outro.getCodigo();
        this.nome = outro.getNome();
        this.descricao = outro.getDescricao();
        this.preco = outro.getPreco();
        this.estoque = outro.getEstoque();
        this.categoria = outro.getCategoria();
        this.dataFabricacao = outro.getDataFabricacao();
    }

    public String cabecalho() {
        return "Código;Nome;Descrição;Preço;Estoque;Categoria;Data de Fabricação\n";
    }

    public String atributoToCSV() {
        String aux = this.codigo + ";" +
                this.nome + ";" +
                this.descricao + ";" +
                this.preco + ";" +
                this.estoque + ";" +
                this.categoria + ";" +
                this.dataFabricacao + "\n";
        return aux;
    }

    public void CSVToAtributo(String csv) {
        String vetor[] = csv.split(";");

        this.codigo = vetor[0];
        this.nome = vetor[1];
        this.descricao = vetor[2];
        this.preco = Double.parseDouble(vetor[3]);
        this.estoque = Integer.parseInt(vetor[4]);
        this.categoria = vetor[5];
        // Converter a string de data para um objeto Calendar, se necessário
        // Exemplo: this.dataFabricacao = converterStringParaCalendar(vetor[6]);
    }
}

