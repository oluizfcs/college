package mtp.projetofinal.utils;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author luizf
 */
public class FrameUtils {

    /**
     * Coloca o ícone num JFrame
     *
     * @param frame
     */
    public static void setFrameIcon(JFrame frame) {
        frame.setIconImage(new ImageIcon(frame.getClass().getResource("/carrinho.png")).getImage());
    }
}
