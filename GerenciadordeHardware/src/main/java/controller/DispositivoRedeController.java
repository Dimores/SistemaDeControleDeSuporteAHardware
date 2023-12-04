/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMCadDispositivoRede;
import java.util.List;
import javax.swing.JTable;
import model.*;
import lombok.*;
import model.dao.DispositivoDeRedeDAO;
import model.exceptions.DispositivoRedeException;
import model.validations.DispositivoRedeValidate;

@Getter //constroi os metodos get
@Setter //constroi os metodos set
@EqualsAndHashCode //constroi os metodos equals e hashCode 
@ToString

/**
 *
 * @author ruiz
 */
public class DispositivoRedeController {

    private DispositivoDeRedeDAO repositorio;

    public DispositivoRedeController() {
        repositorio = new DispositivoDeRedeDAO();
    }

    public void cadastrarDispositivoRede(Long id, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao,
            String enderecoIP, String fabricante, String modelo) {
        DispositivoRedeValidate valid = new DispositivoRedeValidate();
        DispositivoDeRede novoDispositivo = valid.validaCamposEntrada(id, codigo, nome, descricao, preco, estoque, categoria, dataFabricacao, enderecoIP, fabricante, modelo);

        if (repositorio.findByCodigo(codigo) == null) {
            repositorio.save(novoDispositivo);
        } else {
            throw new DispositivoRedeException("Error - Já existe um dispositivo com este 'Codigo'.");
        }

    }

    public void atualizarDispositivoRede(Long id, String codigo, String nome, String descricao, double preco, int estoque, String categoria, String dataFabricacao,
            String enderecoIP, String fabricante, String modelo) {

        DispositivoRedeValidate valid = new DispositivoRedeValidate();
        DispositivoDeRede novoDispositivo = valid.validaCamposEntrada(id, codigo, nome, descricao, preco, estoque, categoria, dataFabricacao, enderecoIP, fabricante, modelo);
        novoDispositivo.setId(id);

        repositorio.update(novoDispositivo);

    }

    public void excluirDispositivoRede(DispositivoDeRede dispositivoDeRede) {
        if (dispositivoDeRede != null) {
            repositorio.delete(dispositivoDeRede);
        } else {
            throw new DispositivoRedeException("Error - Dispositivo de rede inexistente."); // Alterado de AlunoException para TecnicoException
        }
    }

    public void atualizarTabela(JTable grd) {
        List<Object> lst = repositorio.findAll();
        TMCadDispositivoRede tmDispositivoRede = new TMCadDispositivoRede(lst);
        grd.setModel(tmDispositivoRede);
    }

}
