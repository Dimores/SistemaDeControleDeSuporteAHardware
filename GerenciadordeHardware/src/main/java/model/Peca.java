/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@NoArgsConstructor

/**
 *
 * @author ruiz
 */

public class Peca extends Produto {
    private Long idPeca;
    private String tipo;


    public Peca(Long idPeca, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, String tipo) {
        super(codigo, nome, descricao, preco, estoque, categoria, dataFabricacao);
        this.idPeca = idPeca;
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        String txt = super.toString() +
                "Tipo: " + this.tipo + "\n";
        return txt;
    }

    public void copiar(Peca outra) {
        super.copiar(outra);
        this.tipo = outra.getTipo();
    }

    public String cabecalho() {
        return super.cabecalho() + "Tipo\n";
    }

    public String atributoToCSV() {
        return super.atributoToCSV() + this.tipo + "\n";
    }

    public void CSVToAtributo(String csv) {
        String[] vetor = csv.split(";");
        super.CSVToAtributo(csv);
        this.tipo = vetor[vetor.length - 1];
    }
}

