/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Calendar;
import lombok.*;
@Getter //constroi os metodos get
@Setter //constroi os metodos set
/**
 *
 * @author ruiz
 */
public class RelatorioRede extends Relatorio {
    private String tipoRede;

    public RelatorioRede() {
        super();
        this.tipoRede = "";
    }

    public RelatorioRede(int idRelatorio, Calendar dataRelatorio, String descricao, String tipoRede, Cliente clienteRelacionado, Tecnico tecnicoResponsavel) {
        super(idRelatorio,dataRelatorio, descricao, clienteRelacionado, tecnicoResponsavel);
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
