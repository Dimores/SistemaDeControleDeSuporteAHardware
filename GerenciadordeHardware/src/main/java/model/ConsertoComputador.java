/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import lombok.*;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 * @author diego
 */
@Entity
@DiscriminatorValue("CONSERTOCOMPUTADOR")
public class ConsertoComputador extends Servico {
    

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "peca_conserto",
        joinColumns = @JoinColumn(name = "conserto_id"),
        inverseJoinColumns = @JoinColumn(name = "peca_id")
    )
    private List<Peca> pecasSubstituidas;
    

    public ConsertoComputador() {
        super();
        this.pecasSubstituidas = new ArrayList();
    }

    public ConsertoComputador(Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                              String dataServico, boolean concluido, ArrayList pecasSubstituidas, boolean isPago) {
        super(tecnicoResponsavel, clienteAtendido, valor, descricaoServico, dataServico, concluido, isPago);
        this.pecasSubstituidas = pecasSubstituidas;
    }



    @Override
    public String toString() {
        StringBuilder pecas = new StringBuilder();


        String txt = super.toString() +
                "Descrição do Problema: " + super.getDescricaoServico() + "\n" +
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


        return super.atributoToCSV() + super.getDescricaoServico() + ";" + (pecas.length() > 0 ? pecas.substring(0, pecas.length() - 2) : "") + "\n";
    }

    @Override
    public void CSVToAtributo(String csv, Tecnico tecnico, Cliente cliente) {
        super.CSVToAtributo(csv, tecnico, cliente);
        String[] vetor = csv.split(";");
        //this.descricaoProblema = vetor[8]; // Suponha que a descrição do problema seja o nono elemento no CSV

        // Suponha que o décimo elemento no CSV seja uma lista de peças separadas por vírgula
        String pecasCSV = vetor[9];
        String[] pecasArray = pecasCSV.split(",");


    }
}

