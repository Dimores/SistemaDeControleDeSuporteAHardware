/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import lombok.*;

@Getter //constroi os metodos get
@Setter //constroi os metodos set

/**
 *
 * @author ruiz
 */

public class Servico {
    private int idServico;
    private Tecnico tecnicoResponsavel;
    private Cliente clienteAtendido;
    private float valor;
    private String descricaoServico;
    private Calendar dataServico;
    private boolean concluido;

    public Servico() {
        this.idServico = 0;
        this.tecnicoResponsavel = null;
        this.clienteAtendido = null;
        this.valor = 0.0f;
        this.descricaoServico = "";
        this.dataServico = Calendar.getInstance();
        this.concluido = false;
    }

    public Servico(int idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico, Calendar dataServico, boolean concluido) {
        this.idServico = idServico;
        this.tecnicoResponsavel = tecnicoResponsavel;
        this.clienteAtendido = clienteAtendido;
        this.valor = valor;
        this.descricaoServico = descricaoServico;
        this.dataServico = dataServico;
        this.concluido = concluido;
    }

    @Override
    public String toString() {
        String txt = "ID do Serviço: " + this.idServico + "\n"
                + "Técnico Responsável: " + this.tecnicoResponsavel.getNome() + "\n"
                + "Cliente Atendido: " + this.clienteAtendido.getNome() + "\n"
                + "Valor: " + this.valor + "\n"
                + "Descrição do Serviço: " + this.descricaoServico + "\n"
                + "Data do Serviço: " + this.dataServico.getTime() + "\n"
                + "Concluído: " + (this.concluido ? "Sim" : "Não") + "\n";
        return txt;
    }

    public void copiar(Servico outro) {
        this.idServico = outro.getIdServico();
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
        return this.idServico + ";" +
                this.tecnicoResponsavel.getId() + ";" +
                this.clienteAtendido.getIdCliente() + ";" +
                this.valor + ";" +
                this.descricaoServico + ";" +
                this.dataServico.getTime() + ";" +
                (this.concluido ? "Sim" : "Não") + "\n";
    }

    public void CSVToAtributo(String csv, Tecnico tecnico, Cliente cliente) {
        String[] vetor = csv.split(";");
        this.idServico = Integer.parseInt(vetor[0]);
        this.tecnicoResponsavel = tecnico;
        this.clienteAtendido = cliente;
        this.valor = Float.parseFloat(vetor[3]);
        this.descricaoServico = vetor[4];
        // Converter a string de data para um objeto Calendar, se necessário
        // Exemplo: this.dataServico = converterStringParaCalendar(vetor[5]);
        this.concluido = vetor[7].equalsIgnoreCase("Sim");
}


}

