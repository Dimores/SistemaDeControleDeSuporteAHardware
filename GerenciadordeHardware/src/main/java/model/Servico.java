/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.*;

@Getter //constroi os metodos get
@Setter //constroi os metodos set

/**
 *
 * @author ruiz
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tecnico_id")  // Nome da coluna que faz referência ao tecnico na tabela Servico
    private Tecnico tecnicoResponsavel;
    @ManyToOne
    @JoinColumn(name = "cliente_id")  // Nome da coluna que faz referência ao cliente na tabela Servico
    private Cliente clienteAtendido;
    private float valor;
    private String descricaoServico;
    private String dataServico;
    private boolean concluido;
    


    public Servico() {
        this.tecnicoResponsavel = new Tecnico();
        this.clienteAtendido = new Cliente();
        this.valor = 0.0f;
        this.descricaoServico = "";
        this.dataServico = "";
        this.concluido = false;
    }

    public Servico(Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico, String dataServico, boolean concluido) {
        this.tecnicoResponsavel = tecnicoResponsavel;
        this.clienteAtendido = clienteAtendido;
        this.valor = valor;
        this.descricaoServico = descricaoServico;
        this.dataServico = dataServico;
        this.concluido = concluido;
    }

    @Override
    public String toString() {
        String txt = "ID do Serviço: " + this.id + "\n"
                + "Técnico Responsável: " + this.tecnicoResponsavel.getNome() + "\n"
                + "Cliente Atendido: " + this.clienteAtendido.getNome() + "\n"
                + "Valor: " + this.valor + "\n"
                + "Descrição do Serviço: " + this.descricaoServico + "\n"
                + "Data do Serviço: " + this.dataServico + "\n"
                + "Concluído: " + (this.concluido ? "Sim" : "Não") + "\n";
        return txt;
    }

    public void copiar(Servico outro) {
        this.id = outro.getId();
        this.tecnicoResponsavel = outro.getTecnicoResponsavel();
        this.clienteAtendido = outro.getClienteAtendido();
        this.valor = outro.getValor();
        this.descricaoServico = outro.getDescricaoServico();
        this.dataServico = outro.getDataServico();
        this.concluido = outro.isConcluido();
    }

    public String cabecalho() {
        return "ID do Serviço;Técnico Responsável;Cliente Atendido;Valor;Descrição do Serviço;Data do Serviço;Concluído\n";
    }

    public String atributoToCSV() {
        return this.id + ";" +
                this.tecnicoResponsavel.getId() + ";" +
                this.clienteAtendido.getId() + ";" +
                this.valor + ";" +
                this.descricaoServico + ";" +
                this.dataServico + ";" +
                (this.concluido ? "Sim" : "Não") + "\n";
    }

    public void CSVToAtributo(String csv, Tecnico tecnico, Cliente cliente) {
        String[] vetor = csv.split(";");
        this.id = (Long.parseLong(vetor[0]));
        this.tecnicoResponsavel = tecnico;
        this.clienteAtendido = cliente;
        this.valor = Float.parseFloat(vetor[3]);
        this.descricaoServico = vetor[4];
        // Converter a string de data para um objeto Calendar, se necessário
        // Exemplo: this.dataServico = converterStringParaCalendar(vetor[5]);
        this.concluido = vetor[7].equalsIgnoreCase("Sim");
}


}

