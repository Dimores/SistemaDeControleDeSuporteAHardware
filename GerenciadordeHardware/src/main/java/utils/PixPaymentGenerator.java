/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author ruiz
 */
//Classe falsa, por enquanto ela faz um qrCode pro www.google.com
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;

import javax.swing.*;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class PixPaymentGenerator {

    private static String urlBase;
    private static String urlPix;

    private static void generateQRCode(String chavePix, double valor, String outputPath) throws Exception {
        // Construir a URL do Pix com os parâmetros necessários
        String urlPix = buildPixUrl(chavePix, valor);

        // Gerar o QR Code usando a biblioteca zxing
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(urlPix, BarcodeFormat.QR_CODE, 300, 300, hints);

            // Salvar o QR Code como imagem
            Path path = FileSystems.getDefault().getPath(outputPath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    private static String buildPixUrl(String chavePix, double valor) throws Exception {
        // Construir a URL do Pix com os parâmetros necessários
        urlBase = "www.google.com";
        /*urlPix = urlBase +
                "?chave=" + URLEncoder.encode(chavePix, "UTF-8") +
                "&solicitacao=" +
                "&txid=" +
                "&valor=" + valor;*/
        urlPix = "00020126330014BR.GOV.BCB.PIX0111130454816395204000053039865802BR5921Ruiz da Silva Pereira6009SAO PAULO61080540900062250521k66KuxWKsxrV0y91dzowc63047E7F";

        return urlPix;
    }

    private static void displayQRCode(JLabel label, String imagePath) {
        // Adicionar o QR Code ao JPanel
        ImageIcon icon = new ImageIcon(imagePath);
        label.setIcon(icon);
    }

    public static void generatePagamentoPix(String chave, double valor, JLabel label) throws Exception {
        String outputPath = System.getProperty("user.home") + File.separator + "qrcode.png";
        generateQRCode(chave, valor, outputPath);
        displayQRCode(label, outputPath);
    }
}
