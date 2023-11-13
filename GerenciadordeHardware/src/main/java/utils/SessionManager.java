/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ruiz
 */

public class SessionManager {
   private static Long idUsuarioLogado = Long.valueOf(-1);
   public static int codePrivilegio = -1;
   
   public static void close(){
        idUsuarioLogado = Long.valueOf(-1);
        codePrivilegio = -1;
   }
   
   public static void setId(Long id){
       idUsuarioLogado= id;
   }
   public static Long getId(){
       return idUsuarioLogado;
   }
}
