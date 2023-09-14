/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */


public class Relatorio {
    private String idRelatorio;
    private Calendar dataRelatorio;
    private String descricao;
    private Cliente clienteRelacionado;
    private Tecnico tecnicoResponsavel;

    public Relatorio() {
        this.idRelatorio = "";
        this.dataRelatorio = Calendar.getInstance();
        this.descricao = "";
        this.clienteRelacionado = null;
        this.tecnicoResponsavel = null;
    }

    public Relatorio(String idRelatorio, Calendar dataRelatorio, String descricao, Cliente clienteRelacionado, Tecnico tecnicoResponsavel) {
        this.idRelatorio = idRelatorio;
        this.dataRelatorio = dataRelatorio;
        this.descricao = descricao;
        this.clienteRelacionado = clienteRelacionado;
        this.tecnicoResponsavel = tecnicoResponsavel;
    }



    @Override
    public String toString() {
        String clienteNome = (clienteRelacionado != null) ? clienteRelacionado.getNome() : "N/A";
        String tecnicoNome = (tecnicoResponsavel != null) ? tecnicoResponsavel.getNome() : "N/A";

        return "ID do Relatório: " + idRelatorio + "\n" +
                "Data do Relatório: " + dataRelatorio.getTime() + "\n" +
                "Descrição: " + descricao + "\n" +
                "Cliente Relacionado: " + clienteNome + "\n" +
                "Técnico Responsável: " + tecnicoNome + "\n";
    }
}

