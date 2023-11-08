/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils.interfaces;

/**
 *
 * @author ruiz
 */
public interface ICriptografia {
    public String encrypt(String password) throws Exception;
    public String decrypt(String hascode) throws Exception;
}
