/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import javax.persistence.*;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString 

/**
 *
 * @author ruiz
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Relatorio {


    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRelatorio;
    private String dataRelatorio;
    private String descricao;
    private String nomeClienteRelacionado;
    private String nomeTecnicoResponsavel;

    public Relatorio() {
        this.dataRelatorio = "";
        this.descricao = "";
        this.nomeClienteRelacionado = "";
        this.nomeTecnicoResponsavel = "";
    }

    public Relatorio(Long idRelatorio, String dataRelatorio, String descricao, String clienteRelacionado, String tecnicoResponsavel) {
        this.idRelatorio = idRelatorio;
        this.dataRelatorio = dataRelatorio;
        this.descricao = descricao;
        this.nomeClienteRelacionado = clienteRelacionado;
        this.nomeTecnicoResponsavel = tecnicoResponsavel;
    }
    
    public Relatorio(String dataRelatorio, String descricao, String nomeClienteRelacionado, String nomeTecnicoResponsavel) {
        this.dataRelatorio = dataRelatorio;
        this.descricao = descricao;
        this.nomeClienteRelacionado = nomeClienteRelacionado;
        this.nomeTecnicoResponsavel = nomeTecnicoResponsavel;
    }
    
    


    @Override
    public String toString() {
        String clienteNome = (nomeClienteRelacionado != null) ? getNomeClienteRelacionado() : "N/A";
        String tecnicoNome = (nomeTecnicoResponsavel != null) ? getNomeTecnicoResponsavel() : "N/A";

        return "ID do Relatório: " + idRelatorio + "\n" +
                "Data do Relatório: " + dataRelatorio + "\n" +
                "Descrição: " + descricao + "\n" +
                "Cliente Relacionado: " + clienteNome + "\n" +
                "Técnico Responsável: " + tecnicoNome + "\n";
    }
}

