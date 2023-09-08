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
public class RelatorioManutencao extends Relatorio {
    private String equipamentos;

    public RelatorioManutencao() {
        super();
        this.equipamentos = "";
    }

    public RelatorioManutencao(int idRelatorio, Calendar dataRelatorio, String descricao, String equipamentos, Cliente cliente, Tecnico tecnico) {
        super(idRelatorio, dataRelatorio, descricao, cliente, tecnico);
        this.equipamentos = equipamentos;
    }

    public String getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(String equipamentos) {
        this.equipamentos = equipamentos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Equipamentos: " + equipamentos + "\n";
    }
}
