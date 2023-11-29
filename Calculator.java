import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JTextField display;
    private StringBuilder currentInput;
    private String lastOperation;
    private double result;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        currentInput = new StringBuilder();
        lastOperation = "";
        result = 0;

        setupUI();
    }
    private void setupUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        display = new JTextField();
        display.setEditable(false);
        panel.add(display);

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "AC", "+/-", "C"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        add(panel);
    }
     private void handleDigitClick(String digit) {
        if (currentInput.length() < 8) {
            currentInput.append(digit);
            display.setText(currentInput.toString());
        }
    }

    private void handleDecimalClick() {
        if (!currentInput.toString().contains(".")) {
            currentInput.append(".");
            display.setText(currentInput.toString());
        }
    }
}
