package telas;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MeuSegundoComponente extends JFrame {
    public MeuSegundoComponente() {
        setLayout(new GridLayout(4, 6, 10, 10));
        setSize(600, 200);

        add(new JLabel("Button -->"));
        add(new JButton("clique aqui"));
        
        add(new JLabel("Checkbox -->"));
        add(new JCheckBox("opcao", false));

        add(new JLabel("TextField -->"));
        add(new JTextField());

        // add(new JLabel("List -->"));

        // List list = new List(3, true);
        // list.add("Opção1");
        // list.add("Opção2");
        // list.add("Opção3");
        // add(list);

        
        // add(new JLabel("Choice -->"));
        // Choice choice = new Choice();
        // choice.add("Opção1");
        // choice.add("Opção2");
        // choice.add("Opção3");

        // add(choice);

        setVisible(true);
    }
}
