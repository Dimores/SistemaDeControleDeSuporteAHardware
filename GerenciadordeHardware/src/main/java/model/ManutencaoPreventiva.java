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


public class ManutencaoPreventiva extends Servico {
    private String equipamentos;
    private String descricaoManutencao;

    public ManutencaoPreventiva() {
        super();
        this.equipamentos = "";
        this.descricaoManutencao = "";
    }

    public ManutencaoPreventiva(String idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                String dataServico, String dataConclusao, boolean concluido, String equipamentos, String descricaoManutencao, String tipoServico) {
        super(idServico, tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido, tipoServico);
        this.equipamentos = equipamentos;
        this.descricaoManutencao = descricaoManutencao;
    }

    @Override
    public String toString() {
        String txt = super.toString() +
                "Equipamentos: " + this.equipamentos + "\n" +
                "Descrição da Manutenção: " + this.descricaoManutencao + "\n";
        return txt;
    }

    @Override
    public String cabecalho() {
        return super.cabecalho() + "Equipamentos;Descrição da Manutenção\n";
    }

    @Override
    public String atributoToCSV() {
        return super.atributoToCSV() + this.equipamentos + ";" + this.descricaoManutencao + "\n";
    }

    @Override
    public void CSVToAtributo(String csv, Tecnico tecnico, Cliente cliente) {
        super.CSVToAtributo(csv, tecnico, cliente);
        String[] vetor = csv.split(";");
        this.equipamentos = vetor[8]; // Suponha que equipamentos sejam o nono elemento no CSV
        this.descricaoManutencao = vetor[9]; // Suponha que a descrição da manutenção seja o décimo elemento no CSV
    }
}

