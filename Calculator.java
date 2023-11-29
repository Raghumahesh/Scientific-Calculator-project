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

     private void handleDigitClick(String digit) {
        if (currentInput.length() < 8) {
            currentInput.append(digit);
            display.setText(currentInput.toString());
        }

        add(panel);

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

}
