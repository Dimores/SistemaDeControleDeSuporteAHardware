/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import lombok.*;
import java.util.Calendar;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
 

/**
 *
 * @author ruiz
 */


public class InstalacaoRede extends Servico {
    private String tipoRede;
    private String enderecoRede;

    public InstalacaoRede() {
        super();
        this.tipoRede = "";
        this.enderecoRede = "";
    }

    public InstalacaoRede(String idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                          String dataServico, Calendar dataConclusao, boolean concluido, String tipoRede, String enderecoRede) {
        super(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido, "Instalacao de Rede");
        this.tipoRede = tipoRede;
        this.enderecoRede = enderecoRede;
    }
    @Override
    public String toString() {
        String txt = super.toString() +
                "Tipo de Rede: " + this.tipoRede + "\n" +
                "Endereço da Rede: " + this.enderecoRede + "\n";
        return txt;
    }

    @Override
    public String cabecalho() {
        return super.cabecalho() + "Tipo de Rede;Endereço da Rede\n";
    }

    @Override
    public String atributoToCSV() {
        return super.atributoToCSV() + this.tipoRede + ";" + this.enderecoRede + "\n";
    }

    @Override
    public void CSVToAtributo(String csv, Tecnico tecnico, Cliente cliente) {
        super.CSVToAtributo(csv, tecnico ,cliente);
        String[] vetor = csv.split(";");
        this.tipoRede = vetor[8]; // Suponha que tipo de rede seja o nono elemento no CSV
        this.enderecoRede = vetor[9]; // Suponha que o endereço da rede seja o décimo elemento no CSV
    }
}

