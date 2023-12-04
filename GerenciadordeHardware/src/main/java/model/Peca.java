/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@DiscriminatorValue("PECA")
public class Peca extends Produto implements Serializable {

    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conserto_id") // Especifica o nome da coluna de chave estrangeira
    private ConsertoComputador conserto;

    @OneToMany(mappedBy = "peca", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PecaExemplar> exemplares = new ArrayList<>();

    public Peca() {
        super();
    }

    public Peca(String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao, boolean isPago) {
        super(codigo, nome, descricao, preco, estoque, categoria, dataFabricacao, isPago);
        this.id = id;
    }

    public String cabecalho() {
        return super.cabecalho() + "Tipo\n";
    }

}
