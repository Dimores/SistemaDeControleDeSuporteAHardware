/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import lombok.*;
import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter //constroi os metodos get
@Setter //constroi os metodos set 

/**
 *
 * @author ruiz
 */

@Entity
@DiscriminatorValue("MANUTENCAOPREVENTIVA")
public class ManutencaoPreventiva extends Servico {
    private String equipamentos;

    public ManutencaoPreventiva() {
        super();
        this.equipamentos = "";
    }

    public ManutencaoPreventiva(Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                                String dataServico, boolean concluido, String equipamentos, String descricaoManutencao, boolean isPago) {
        super(tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido, isPago);
    }

    @Override
    public String toString() {
        String txt = super.toString() +
                "Equipamentos: " + this.equipamentos + "\n";
        return txt;
    }

    @Override
    public String cabecalho() {
        return super.cabecalho() + "Equipamentos;Descrição da Manutenção\n";
    }

    @Override
    public String atributoToCSV() {
        return super.atributoToCSV() + this.equipamentos + ";";
    }

    @Override
    public void CSVToAtributo(String csv, Tecnico tecnico, Cliente cliente) {
        super.CSVToAtributo(csv, tecnico, cliente);
        String[] vetor = csv.split(";");
        this.equipamentos = vetor[8]; // Suponha que equipamentos sejam o nono elemento no CSV
    }
}

