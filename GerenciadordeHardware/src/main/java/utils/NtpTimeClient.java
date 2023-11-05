package utils;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import java.net.InetAddress;
import java.util.Date;

public class NtpTimeClient {
    public static String dataAtualToString (){
        try {
            String ntpServer = "pool.ntp.org"; // Servidor NTP de acesso gratuito
            NTPUDPClient client = new NTPUDPClient();
            InetAddress host = InetAddress.getByName(ntpServer);
            TimeInfo info = client.getTime(host);
            info.computeDetails(); // Calcula os detalhes da hora

            // Obtém a hora do servidor NTP
            Date date = new Date(info.getMessage().getTransmitTimeStamp().getTime());

            // Exibe a hora obtida do servidor NTP
            client.close();
            return ""+date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
