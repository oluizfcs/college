package telas;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class MeuPrimeiroComponente extends Frame {
    public MeuPrimeiroComponente() {
        setLayout(new GridLayout(4, 6, 10, 10));
        setSize(600, 200);
        setFont(new Font("Helvetica", Font.BOLD, 28));

        add(new Label("Button -->"));
        add(new Button("clique aqui"));
        
        add(new Label("Checkbox -->"));
        add(new Checkbox("opcao", false));

        add(new Label("TextField -->"));
        add(new TextField());

        // add(new Label("List -->"));

        // List list = new List(3, true);
        // list.add("Opção1");
        // list.add("Opção2");
        // list.add("Opção3");
        // add(list);

        // add(new Label("Choice -->"));
        // Choice choice = new Choice();
        // choice.add("Opção1");
        // choice.add("Opção2");
        // choice.add("Opção3");

        // add(choice);

        setVisible(true);
    }
}
