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

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (buttonText.matches("[0-9]")) {
                handleDigitClick(buttonText);
            } else if (buttonText.equals(".")) {
                handleDecimalClick();
            } else if (buttonText.equals("=")) {
                handleEqualClick();
            } else if (buttonText.equals("AC")) {
                handleAllClearClick();
            } else if (buttonText.equals("+/-")) {
                handleChangeSignClick();
            } else if (buttonText.equals("C")) {
                handleClearClick();
            } else {
                handleOperationClick(buttonText);
            }
        }
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

    private void handleChangeSignClick() {
        if (currentInput.length() > 0 && !currentInput.toString().equals("0")) {
            if (currentInput.charAt(0) == '-') {
                currentInput.deleteCharAt(0);
            } else {
                currentInput.insert(0, '-');
            }
            display.setText(currentInput.toString());
        }
    }

    private void handleAllClearClick() {
        currentInput = new StringBuilder();
        lastOperation = "";
        result = 0;
        display.setText("0");
    }

    private void handleEqualClick() {
        try {
            double currentNumber = Double.parseDouble(currentInput.toString());
            switch (lastOperation) {
                case "+":
                    result += currentNumber;
                    break;
                case "-":
                    result -= currentNumber;
                    break;
                case "*":
                    result *= currentNumber;
                    break;
                case "/":
                    if (currentNumber == 0) {
                        display.setText("ERR");
                        return;
                    }
                    result /= currentNumber;
                    break;
                default:
                    result = currentNumber;
            }

            if (Double.isInfinite(result) || Double.isNaN(result) || String.valueOf(result).length() > 8) {
                display.setText("ERR");
                result = 0;
            } else {
                display.setText(String.valueOf(result));
            }

            currentInput = new StringBuilder();
            lastOperation = "";
        } catch (NumberFormatException ex) {
            display.setText("ERR");
            currentInput = new StringBuilder();
            lastOperation = "";
        }
    }
}
