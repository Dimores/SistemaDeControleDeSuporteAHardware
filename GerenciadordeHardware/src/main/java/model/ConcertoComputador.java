/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.awt.List;
import java.util.ArrayList;
import lombok.*;
import java.util.Calendar;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */


public class ConcertoComputador extends Servico {
    private String descricaoProblema;
    private ArrayList<Peca> pecasSubstituidas;

    public ConcertoComputador() {
        super();
        this.descricaoProblema = "";
        this.pecasSubstituidas = null;
    }

    public ConcertoComputador(String idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                              String dataServico, boolean concluido, String descricaoProblema, ArrayList pecasSubstituidas) {
        super(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido);
        this.descricaoProblema = descricaoProblema;
        this.pecasSubstituidas = pecasSubstituidas;
    }



    @Override
    public String toString() {
        StringBuilder pecas = new StringBuilder();
        for (Peca peca : pecasSubstituidas) {
            pecas.append(peca.getNome()).append(", ");
        }

        String txt = super.toString() +
                "Descrição do Problema: " + this.descricaoProblema + "\n" +
                "Peças Substituídas: " + (pecas.length() > 0 ? pecas.substring(0, pecas.length() - 2) : "Nenhuma") + "\n";
        return txt;
    }

    @Override
    public String cabecalho() {
        return super.cabecalho() + "Descrição do Problema;Peças Substituídas\n";
    }

    @Override
    public String atributoToCSV() {
        StringBuilder pecas = new StringBuilder();
        for (Peca peca : pecasSubstituidas) {
            pecas.append(peca.getNome()).append(", ");
        }

        return super.atributoToCSV() + this.descricaoProblema + ";" + (pecas.length() > 0 ? pecas.substring(0, pecas.length() - 2) : "") + "\n";
    }

    @Override
    public void CSVToAtributo(String csv, Tecnico tecnico, Cliente cliente) {
        super.CSVToAtributo(csv, tecnico, cliente);
        String[] vetor = csv.split(";");
        this.descricaoProblema = vetor[8]; // Suponha que a descrição do problema seja o nono elemento no CSV

        // Suponha que o décimo elemento no CSV seja uma lista de peças separadas por vírgula
        String pecasCSV = vetor[9];
        String[] pecasArray = pecasCSV.split(",");
        this.pecasSubstituidas = new ArrayList<Peca>();

        for (String pecaNome : pecasArray) {
            Peca peca = new Peca();
            peca.setNome(pecaNome.trim());
            this.pecasSubstituidas.add(peca);
        }
    }
}

