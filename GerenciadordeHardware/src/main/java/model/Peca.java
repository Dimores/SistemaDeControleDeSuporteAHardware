/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set

/**
 *
 * @author ruiz
 */
@Entity
@DiscriminatorValue("PECA")
public class Peca extends Produto implements Serializable {
    
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "produto_id") // Especifica o nome da coluna de chave estrangeira
    private Produto produto;
    
    public Peca(){
        super();
    }

    public Peca(String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao) {
        super(codigo, nome, descricao, preco, estoque, categoria, dataFabricacao);
        this.id = id;
    }



    public String cabecalho() {
        return super.cabecalho() + "Tipo\n";
    }


}

