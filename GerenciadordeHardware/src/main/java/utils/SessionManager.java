/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ruiz
 */
public class SessionManager {
   public static Long idUsuarioLogado = Long.valueOf(-1);
   public static int codePrivilegio = -1;
   
   public static void close(){
        idUsuarioLogado = Long.valueOf(-1);
        codePrivilegio = -1;
   }
}
