import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora extends JFrame{
    private JTextField numero1;
    private JTextField numero2;
    private JButton suma;
    private JButton resta;
    private JButton division;
    private JButton multiplicar;
    private JLabel resultado;


    public calculadora() {
        setTitle("Calculadora Básica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        // Crear componentes
        numero1 = new JTextField();
        numero2 = new JTextField();
        resultado = new JLabel("Resultado: ");

        JButton suma = new JButton("+");
        JButton resta = new JButton("-");
        JButton multiplicacion = new JButton("*");
        JButton division = new JButton("/");

        numero1.setBounds(50, 30, 120, 30);
        numero2.setBounds(200, 30, 120, 30);
        suma.setBounds(50, 80, 50, 30);
        resta.setBounds(110, 80, 50, 30);
        multiplicacion.setBounds(170, 80, 50, 30);
        division.setBounds(230, 80, 50, 30);
        resultado.setBounds(50, 130, 300, 30);

        numero1.setBackground(Color.YELLOW);
        numero2.setBackground(Color.YELLOW);
        suma.setBackground(Color.YELLOW);
        resta.setBackground(Color.YELLOW);
        multiplicacion.setBackground(Color.YELLOW);
        division.setBackground(Color.YELLOW);
        resultado.setForeground(Color.BLACK);

        suma.addActionListener(new OperacionListener("+"));
        resta.addActionListener(new OperacionListener("-"));
        multiplicacion.addActionListener(new OperacionListener("*"));
        division.addActionListener(new OperacionListener("/"));

        add(numero1);
        add(numero2);
        add(suma);
        add(resta);
        add(multiplicacion);
        add(division);
        add(resultado);
        setVisible(true);
    }

    private class OperacionListener implements ActionListener {
        private String operacion;

        public OperacionListener(String operacion) {
            this.operacion = operacion;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(numero1.getText());
                double num2 = Double.parseDouble(numero2.getText());
                double res = 0;

                switch (operacion) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) throw new ArithmeticException("División por cero");
                        res = num1 / num2;
                        break;
                }
                resultado.setText("RESULTADO: " + res);
            } catch (NumberFormatException ex) {
                resultado.setText("Error: Entrada inválida");
            } catch (ArithmeticException ex) {
                resultado.setText("Error: " + ex.getMessage());
            }
        }
    }
}
