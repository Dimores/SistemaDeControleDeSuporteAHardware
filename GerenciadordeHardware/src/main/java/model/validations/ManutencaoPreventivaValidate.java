/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.Cliente;
import model.ManutencaoPreventiva;
import model.Tecnico;

/**
 *
 * @author diego
 */
public class ManutencaoPreventivaValidate {

    public ManutencaoPreventivaValidate() {
        
    }
    
    public ManutencaoPreventiva validaCamposEntrada(Long idServico, Tecnico tecnicoResponsavel, Cliente clienteAtendido, float valor, String descricaoServico,
                            String dataServico, String dataConclusao, boolean concluido, String equipamentos, String descricaoManutencao){
        ManutencaoPreventiva manutencaoPreventiva = new ManutencaoPreventiva();
        
        // Validar aqui
        
        return manutencaoPreventiva;
    }
    
}
