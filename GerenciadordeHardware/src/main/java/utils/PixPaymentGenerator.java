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

    public static void generateQRCode(String chavePix, double valor, String outputPath) throws Exception {
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
        urlPix = urlBase +
                "?chave=" + URLEncoder.encode(chavePix, "UTF-8") +
                "&solicitacao=" +
                "&txid=" +
                "&valor=" + valor;

        return urlPix;
    }

    private static void displayQRCode(JPanel panel, String imagePath) {
        // Adicionar o QR Code ao JPanel
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(icon);
        panel.add(label);
    }

    public static void generatePagamentoPix(String chave, double valor, JPanel panel) throws Exception {
        String outputPath = System.getProperty("user.home") + File.separator + "qrcode.png";
        generateQRCode(chave, valor, outputPath);
        displayQRCode(panel, outputPath);
    }
}
