package view.graphicElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BotaoVermelho extends JButton {

    private static BotaoVermelho botaoSelecionado = null;

    public BotaoVermelho() {
        colorOver = new Color(229, 9, 20);
        setContentAreaFilled(false);
        setFocusPainted(false);

        // Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //super.mouseEntered(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (botaoSelecionado != null) {
                    botaoSelecionado.setBordaPadrao();
                }
                botaoSelecionado = BotaoVermelho.this;
                setBordaVermelha();
            }
        });
    }

    private boolean over;
    private Color cor;
    private Color colorOver;
    private Color borderColor = new Color(51, 51, 51); // Cor padrão
    private int radius = 0;

    private void setBordaVermelha() {
        borderColor = new Color(229, 9, 20);
        repaint();
    }

    private void setBordaPadrao() {
        borderColor = new Color(51, 51, 51); // Cor #333333
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Paint border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());

        // Border set 2Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);

        super.paintComponent(g);
    }
}
