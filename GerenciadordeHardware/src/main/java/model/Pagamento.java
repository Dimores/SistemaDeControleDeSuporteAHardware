/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import model.interfaces.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

// Provavelmente remover essa classe
public class Pagamento implements IPagamento{
    private List<Servico> lstServico;
    private List<Produto>lstProduto;
    private Double dinheiro;
    private Cliente clientePagante;
    private Tecnico tecnicoResponsavel;
    
    
    
    @Override
    public void pagar(Double valorEmDinheiro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void dadosToPDF(){
        
    }
    
}
