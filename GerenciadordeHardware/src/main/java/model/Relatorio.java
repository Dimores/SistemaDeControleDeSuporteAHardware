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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Relatorio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelatorio;
    private String dataRelatorio;
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")  // Nome da coluna que faz referência ao cliente na tabela Relatorio
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "tecnico_id")  // Nome da coluna que faz referência ao cliente na tabela Relatorio
    private Tecnico tecnico;

    public Relatorio() {
        this.dataRelatorio = "";
        this.descricao = "";
        this.cliente = new Cliente();
        this.tecnico = new Tecnico();
    }

    public Relatorio(Long idRelatorio, String dataRelatorio, String descricao, Cliente clienteRelacionado, Tecnico tecnicoResponsavel) {
        this.idRelatorio = idRelatorio;
        this.dataRelatorio = dataRelatorio;
        this.descricao = descricao;
        this.cliente = clienteRelacionado;
        this.tecnico = tecnicoResponsavel;
    }
    
    public Relatorio(String dataRelatorio, String descricao, Cliente nomeClienteRelacionado, Tecnico nomeTecnicoResponsavel) {
        this.dataRelatorio = dataRelatorio;
        this.descricao = descricao;
        this.cliente = nomeClienteRelacionado;
        this.tecnico = nomeTecnicoResponsavel;
    }
    
    


    @Override
    public String toString() {
        //String clienteNome = (clienteRelacionado != null) ? getNomeClienteRelacionado() : "N/A";
        //String tecnicoNome = (tecnicoResponsavel != null) ? getNomeTecnicoResponsavel() : "N/A";

        return "ID do Relatório: " + idRelatorio + "\n" +
                "Data do Relatório: " + dataRelatorio + "\n" +
                "Descrição: " + descricao;
    }
}

