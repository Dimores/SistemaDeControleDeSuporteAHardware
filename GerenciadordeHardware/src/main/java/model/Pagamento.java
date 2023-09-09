/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.interfaces.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class Pagamento implements IPagamento{
    private Double dinheiro;

    @Override
    public void pagar(Double valorEmDinheiro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
