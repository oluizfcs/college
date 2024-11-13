package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

public class PanelDemo extends Panel {
    
    public PanelDemo() {
        setBackground(new Color(117, 217, 142));
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Helvetica", Font.PLAIN, 16));
        g.drawString("Teste", 150, 30);

        g.setColor(Color.black);
        g.fillRect(150, 100, 50, 25);
    }
}
