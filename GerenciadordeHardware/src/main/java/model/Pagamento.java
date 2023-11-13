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
    private float totalPagamento;
    
    
    @Override
    public void pagar(Double valorEmDinheiro) {
    
    
    }
    
    public void dadosToPDF(){
        
    }
    
    public void AdicionarAoPagamento(Object obj){
        
        try{
            if (obj instanceof Servico) {
                lstServico.add((Servico) obj);
            } else if (obj instanceof Produto) {
                lstProduto.add((Produto) obj);
            }
        }catch (RuntimeException e){
            throw new RuntimeException("Produto ou servico invalido" + e);
        }
     
        
    }
    
    
    public float getTotalPagamento(){
        float total = 0;
        for (int i =0; i < lstServico.size(); i++){
            total += lstServico.get(i).getValor();
        }for(int i=0; i<lstProduto.size(); i++){
            total += lstProduto.get(i).getPreco();
        }
        totalPagamento = total;
        return totalPagamento;
    }
}
