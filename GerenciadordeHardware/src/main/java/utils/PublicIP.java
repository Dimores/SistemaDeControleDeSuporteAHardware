/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ruiz
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PublicIP{
    public static String getPublicIpAdress() {
        try {
            URL url = new URL("https://ipinfo.io");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            String publicIPAddress = response.toString();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(publicIPAddress);
            
            
            objectMapper.readTree(publicIPAddress);
            String country = jsonNode.get("country").asText();
            String region = jsonNode.get("region").asText();
            String city = jsonNode.get("city").asText();

           
           return country + " " + region + " "+ city;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}