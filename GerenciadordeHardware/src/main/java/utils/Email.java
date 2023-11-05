/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import org.apache.commons.mail.HtmlEmail;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.mail.SimpleEmail;
/**
 *
 * @author ruiz
 */
public class Email {
    String emailRemetente = "ruizsilva15@gmail.com";
    String senhaEmailRemetente = "zjee rmtq qkwn ertw ";
   
     public Email(String nome, String emailUsuario, String subject, String msg, String tipoEmail) {
         Thread emailThread = new Thread(() ->{
             try {
            String template = getTemplate(tipoEmail);
            String emailContent = template.replace("$nome", nome).replace("$msg", msg);

            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthentication(emailRemetente, senhaEmailRemetente);
            email.setSSLOnConnect(true);

            email.setFrom(emailRemetente);
            email.addTo(emailUsuario);
            email.setSubject(subject);
            email.setHtmlMsg(emailContent);

            email.send();
        
        }catch (Exception e) {
            e.printStackTrace();
        }             
         });
         emailThread.start();
         
         try {
            emailThread.join(); // Aguarda a thread terminar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getTemplate(String tipoEmail) {
          // Define o caminho do arquivo HTML no diretório de recursos
        // Define o caminho do arquivo HTML no diretório de recursos
        String filePath = "EmailTemplates/" + tipoEmail;

        try {
            // Carrega o conteúdo do arquivo a partir do diretório de recursos
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if (inputStream != null) {
                try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
                    return scanner.useDelimiter("\\A").next();
                }
            } else {
                throw new IOException("Arquivo não encontrado: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ""; // Retorna uma string vazia em caso de erro
        }
    }
}




