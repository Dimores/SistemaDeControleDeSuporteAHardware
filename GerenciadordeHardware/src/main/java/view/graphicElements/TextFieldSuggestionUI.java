package view.graphicElements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalTextFieldUI;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class TextFieldSuggestionUI extends MetalTextFieldUI {

    private JTextField textfield;
    private Border border;
    private int round = 15;
    private List<String> items = new ArrayList<>();
    private Color nonEditableBorderColor = new Color(229, 9, 20); // Cor da borda quando não é editável
    
    public List<String> getItems() {
        return items;
    }
    
    public void setItems(List<String> items) {
        this.items = items;
    }
    
    public int getRound() {
        return round;
    }
    
    public void setRound(int round) {
        this.round = round;
        border.setRound(round);
        textfield.repaint();
    }
    

    public TextFieldSuggestionUI(JTextField textfield) {
        this.textfield = textfield;
        border = new Border(10);
        border.setRound(round);
        textfield.setBorder(border);
        textfield.setOpaque(false);
        textfield.setSelectedTextColor(Color.WHITE);
        textfield.setSelectionColor(new Color(229, 9, 20));
        textfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                border.setColor(new Color(229, 9, 20));
                textfield.repaint();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (textfield.isEditable()) {
                    border.setColor(new Color(229, 9, 20));
                } else {
                    border.setColor(nonEditableBorderColor); // Define a cor da borda não editável
                }
                textfield.repaint();
            }
        });

        // Adicione um PropertyChangeListener para monitorar a propriedade "editable"
        textfield.addPropertyChangeListener("editable", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (!textfield.isEditable()) {
                    border.setColor(new Color(229, 9, 20)); // Define a cor da borda não editável
                    textfield.repaint();
                }
            }
        });

        AutoCompleteDecorator.decorate(textfield, items, false);
    }

    @Override
    protected void paintBackground(Graphics grphcs) {
        if (textfield.isOpaque()) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(textfield.getBackground());
            g2.fillRoundRect(0, 0, textfield.getWidth(), textfield.getHeight(), round, round);
            g2.dispose();
        }
    }

    private class Border extends EmptyBorder {
        private Color focusColor = new Color(229, 9, 20);
        private Color color = new Color(229, 9, 20);
        private int round;

        public Border(int border) {
            super(border, border, border, border);
        }

        public void paintBorder(Component cmpnt, Graphics grphcs, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (cmpnt.isFocusOwner()) {
                g2.setColor(focusColor);
            } else {
                g2.setColor(color);
            }
            g2.drawRoundRect(x, y, width - 1, height - 1, round, round);
            g2.dispose();
        }

        public int getRound() {
            return round;
        }

        public void setRound(int round) {
            this.round = round;
        }

        public Color getFocusColor() {
            return focusColor;
        }

        public void setFocusColor(Color focusColor) {
            this.focusColor = focusColor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }
}
