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
}
