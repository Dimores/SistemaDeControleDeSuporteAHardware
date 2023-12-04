/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMCadCabo;
import java.awt.Color;
import java.util.List;
import javax.swing.JTable;
import lombok.Getter;
import lombok.*;
import model.Cabo;
import model.dao.CaboDAO;
import model.exceptions.CaboException;
import model.validations.CaboValidate;

@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString

/**
 *
 * @author ruiz
 */
public class CaboController extends PecaController {

    CaboDAO repositorio;
    Cabo novoCabo;

    public CaboController() {
        repositorio = new CaboDAO();
    }

    @Override
    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findAll();
        TMCadCabo tmCabo = new TMCadCabo(lst);
        grd.setModel(tmCabo);
    }

    public void cadastrarCabo(Long id, String codigo, String nome, String descricao, double preco,
            int estoque, String categoria, String dataFabricacao, int comprimento, Color cor, int bitola, String tipoDeCabo) {
        CaboValidate valid = new CaboValidate();
        novoCabo = valid.validaCamposEntrada(id, codigo, nome, descricao, preco,
                estoque, categoria, dataFabricacao, comprimento, cor, bitola, tipoDeCabo);

        if (repositorio.findByCodigo(codigo) == null) {
            repositorio.save(novoCabo);
        } else {
            throw new CaboException("Error - Já existe um cabo com este 'Codigo'.");
        }

    }

    public void atualizarCabo(Long id, String codigo, String nome, String descricao, double preco,
            int estoque, String categoria, String dataFabricacao, int comprimento, Color cor, int bitola, String tipoDeCabo) {

        CaboValidate valid = new CaboValidate();
        novoCabo = valid.validaCamposEntrada(id, codigo, nome, descricao, preco,
                estoque, categoria, dataFabricacao, comprimento, cor, bitola, tipoDeCabo);

        novoCabo.setId(id);
        repositorio.update(novoCabo);
    }

    public void excluirCabo(Cabo cabo) {
        if (cabo != null) {
            repositorio.delete(cabo);
        } else {
            throw new CaboException("Error - Cabo inexistente.");
        }
    }

    public Cabo buscarCabo(Long id) {
        return (Cabo) this.repositorio.findById(id);
    }

}
