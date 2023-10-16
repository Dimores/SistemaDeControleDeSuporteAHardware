/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import javax.persistence.Entity;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
@AllArgsConstructor
/**
 *
 * @author ruiz
 */
@Entity
public class RelatorioRede extends Relatorio {
    private String tipoRede;

    public RelatorioRede() {
        super();
        this.tipoRede = "";
    }

    public RelatorioRede(Long idRelatorio, String dataRelatorio, String descricao, String tipoRede, String nomeCliente, String nomeTecnico) {
        super(idRelatorio,dataRelatorio, descricao, nomeCliente, nomeTecnico);
        this.tipoRede = tipoRede;
    }
    
    public RelatorioRede(String dataRelatorio, String descricao, String tipoRede, String nomeCliente, String nomeTecnico){
        super(dataRelatorio, descricao, nomeCliente, nomeTecnico);
        this.tipoRede = tipoRede;
    }

    public String getTipoRede() {
        return tipoRede;
    }

    public void setTipoRede(String tipoRede) {
        this.tipoRede = tipoRede;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Tipo de Rede: " + tipoRede + "\n";
    }
}
