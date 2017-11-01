package Swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    JButton button = new JButton("press");
    JTextField input = new JTextField("", 5);
    JLabel label = new JLabel("input");
    JRadioButton a = new JRadioButton("select a");
    JRadioButton b = new JRadioButton("select b");
    JCheckBox c = new JCheckBox("check me", false);
    public SimpleGUI() {
        super("Simple example");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = new Container();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);
        ButtonGroup group = new ButtonGroup();
        group.add(a);
        group.add(b);
        container.add(a);
        a.setSelected(true);
        container.add(b);
        container.add(c);
        button.addActionListener(new ButtonEventListener());
    }

    class ButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String msg = "";
            msg += "Button was pressed!\n";
            msg += "Text is " + input.getText() + "\n";
            msg += (a.isSelected()) ? "a selected" : "b selected";
            msg += "\nCheck c is" + (c.isSelected() ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null, msg, "Output", JOptionPane.PLAIN_MESSAGE);

        }
    }
}
