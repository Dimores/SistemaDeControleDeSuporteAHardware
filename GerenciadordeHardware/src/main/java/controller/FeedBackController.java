/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.tableModel.TMCadFeedBack;
import java.util.List;
import javax.swing.JTable;
import model.FeedBack;
import model.Servico;
import model.dao.FeedBackDAO;

/**
 *
 * @author ruiz
 */
public class FeedBackController {

    ServicoController servicoController;
    FeedBackDAO feedBackDao;

    public FeedBackController() {
        servicoController = new ServicoController();
        feedBackDao = new FeedBackDAO();
    }

    public void atualizarTabelaHistórico(JTable grd, Long idCliente) {
        List<Object> lst = feedBackDao.findAllByClient(idCliente);
        TMCadFeedBack tmFeedBack = new TMCadFeedBack(lst);
        grd.setModel(tmFeedBack);
    }

    public void excluir(FeedBack feedback) {
        feedBackDao.delete(feedback);
    }

    public void salvar(int nota, String comentario, String data, Servico servico, Long client_id) {
        FeedBack feedback;
        feedback = new FeedBack();
        feedback.setServico(servico);
        feedback.setComentário(comentario);
        feedback.setNotaServico(nota);
        feedback.setDataFeedBack(data);
        feedback.setClientID(client_id);
        feedBackDao.save(feedback);
    }

    public void atualizar(Long id, int nota, String comentario, String data, Servico servico, Long client_id) {
        FeedBack feedback;
        feedback = new FeedBack();
        feedback.setServico(servico);
        feedback.setId(id);
        feedback.setComentário(comentario);
        feedback.setNotaServico(nota);
        feedback.setDataFeedBack(data);
        feedback.setClientID(client_id);
        feedBackDao.update(feedback);
    }

}
