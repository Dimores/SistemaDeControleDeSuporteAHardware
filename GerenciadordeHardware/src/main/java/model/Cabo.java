/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.*;

@Getter //constroi os metodos get
@Setter //constroi os metodos set 

/**
 *
 * @author ruiz
 */
@Entity
@DiscriminatorValue("CABO")
public class Cabo extends Peca {

    private Long idCabo;
    private int comprimento;
    private Color cor;
    private int bitola;
    private String tipoDeCabo;

    public Cabo() {
        super();
        this.comprimento = 0;
        this.cor = Color.BLACK; // Valor padrão
        this.bitola = 0;
        this.tipoDeCabo = "";
    }

    public Cabo(Long id, String codigo, String nome, String descricao, double preco, int estoque, String categoria,
            String dataFabricacao, int comprimento, Color cor, int bitola, String tipoDeCabo, boolean isPago) {
        super(codigo, nome, descricao, preco, estoque, categoria, dataFabricacao, isPago);
        this.comprimento = comprimento;
        this.cor = cor;
        this.bitola = bitola;
        this.tipoDeCabo = tipoDeCabo;

    }

    @Override
    public String toString() {
        String txt = super.toString()
                + "Comprimento: " + this.comprimento + " metros\n"
                + "Cor: " + this.cor.toString() + "\n"
                + "Bitola: " + this.bitola + " mm\n"
                + "Tipo de Cabo: " + this.tipoDeCabo + "\n";
        return txt;
    }

    public void copiar(Cabo outro) {
        super.copiar(outro);
        this.comprimento = outro.getComprimento();
        this.cor = outro.getCor();
        this.bitola = outro.getBitola();
        this.tipoDeCabo = outro.getTipoDeCabo();
    }

    public String cabecalho() {
        return super.cabecalho() + "Comprimento;Cor;Bitola;Tipo de Cabo\n";
    }

    public String atributoToCSV() {
        return super.atributoToCSV() + this.comprimento + ";" + this.cor + ";" + this.bitola + ";" + this.tipoDeCabo + "\n";
    }

    public void CSVToAtributo(String csv) {
        String[] vetor = csv.split(";");
        super.CSVToAtributo(csv);
        this.comprimento = Integer.parseInt(vetor[vetor.length - 4]);
        this.cor = new Color(Integer.parseInt(vetor[vetor.length - 3]));
        this.bitola = Integer.parseInt(vetor[vetor.length - 2]);
        this.tipoDeCabo = vetor[vetor.length - 1];
    }
}
