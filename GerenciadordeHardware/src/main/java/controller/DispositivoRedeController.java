/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.JTable;
import model.*;
import lombok.*;
import model.dao.DispositivoDeRedeDAO;
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
    
    public void cadastrarDispositivoRede(){
        DispositivoRedeValidate valid = new DispositivoRedeValidate(); 
        DispositivoDeRede novoDispositivo = valid.validaCamposEntrada(); 
        repositorio.save(novoDispositivo);

    }
    
    public void atualizarDispositivoRede(){
        
    }
    
    public void excluirDispositivoRede(){
        
    }
    
    public void atualizarTabela(JTable grd){
        
    }
    
    
    
    
}
