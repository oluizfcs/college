
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20241070130005
 */
public class PanelDemo extends Panel {
    
    public PanelDemo() {
        setBackground(new Color(117, 217, 142));
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("Helvetica", Font.PLAIN, 16));
        g.drawString("Teste", 0, 0);
    }
}
