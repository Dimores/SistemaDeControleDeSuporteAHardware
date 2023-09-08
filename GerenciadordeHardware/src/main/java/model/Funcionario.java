/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import lombok.*;
/**
 *
 * @author diegomorelo
 */
@Setter
@Getter

public class Funcionario {
    private String matricula;
    private float salario;
    
    public Funcionario(){
        this.matricula = "";
        this.salario = 0;
    }
}
