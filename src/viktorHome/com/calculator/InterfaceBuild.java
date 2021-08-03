package viktorHome.com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceBuild extends JFrame {
    JButton[] button = new JButton[15];
    private String[] number = {
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "0",
            "+", "-", "*", "/", "="
    };

    JTextField textField;
    JButton bClear;
    JLabel readLine;

    int numOne = 0;
    int numTwo = 0;
    String str;
    Choice choice;

    Logical listener = new Logical();

    public InterfaceBuild() {
    }

    /**
     * Program interface.
     * Constructor
     *
     * @param s
     */
    public InterfaceBuild(String s) {
        super(s);
        setLayout(new FlowLayout());
        textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.BOLD, 12));
        add(textField);
        readLine = new JLabel("<=====================>");
        add(readLine);
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton(number[i]);
            add(button[i]);
            button[i].addActionListener(listener);
        }
        bClear = new JButton("Clear");
        add(bClear);
        bClear.addActionListener(listener);
    }
//-------------------------------------------------------------------------

    /**
     * Program logic
     */
    public class Logical implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();
            try {
                /**
                 * Pressing numbers 1-0
                 */
                if (button[0].equals(source)) {
                    textField.setText(textField.getText() + "1");
                } else if (button[1].equals(source)) {
                    textField.setText(textField.getText() + "2");
                } else if (button[2].equals(source)) {
                    textField.setText(textField.getText() + "3");
                } else if (button[3].equals(source)) {
                    textField.setText(textField.getText() + "4");
                } else if (button[4].equals(source)) {
                    textField.setText(textField.getText() + "5");
                } else if (button[5].equals(source)) {
                    textField.setText(textField.getText() + "6");
                } else if (button[6].equals(source)) {
                    textField.setText(textField.getText() + "7");
                } else if (button[7].equals(source)) {
                    textField.setText(textField.getText() + "8");
                } else if (button[8].equals(source)) {
                    textField.setText(textField.getText() + "9");
                } else if (button[9].equals(source)) {
                    textField.setText(textField.getText() + "0");
                }
                //////////////////////////////////////////////////////
                /**
                 * Button press "Clear"
                 */
                if (bClear.equals(source)) {
                    numOne = 0;
                    numTwo = 0;
                    textField.setText(null);
                }
                ///////////////////////////////////////////////////////
                /**
                 * Button press {'+' '-' '*' '/'}
                 */
                if (button[10].equals(source)) {
                    numOne = Integer.parseInt(textField.getText());
                    textField.setText(null);
                    choice = Choice.PLUS;
                } else if (button[11].equals(source)) {
                    numOne = Integer.parseInt(textField.getText());
                    textField.setText(null);
                    choice = Choice.MINUS;
                } else if (button[12].equals(source)) {
                    numOne = Integer.parseInt(textField.getText());
                    textField.setText(null);
                    choice = Choice.MULTIPLY;
                } else if (button[13].equals(source)) {
                    numOne = Integer.parseInt(textField.getText());
                    textField.setText(null);
                    choice = Choice.DIVIDE;
                }
                ///////////////////////////////////////////////////////
                /**
                 * buttom press '='
                 */
                if (button[14].equals(source)) {
                    numTwo = Integer.parseInt(textField.getText());
                    switch (choice) {
                        case PLUS:
                            str = "" + InputFieldUtils.plus(numOne, numTwo);
                            textField.setText(str.trim());
                            numOne = 0;
                            numTwo = 0;
                            break;
                        case MINUS:
                            str = "" + InputFieldUtils.minus(numOne, numTwo);
                            textField.setText(str.trim());
                            numOne = 0;
                            numTwo = 0;
                            break;
                        case MULTIPLY:
                            str = "" + InputFieldUtils.multiply(numOne, numTwo);
                            textField.setText(str.trim());
                            numOne = 0;
                            numTwo = 0;
                            break;
                        case DIVIDE:
                            str = "" + InputFieldUtils.divide(numOne, numTwo);
                            textField.setText(str.trim());
                            numOne = 0;
                            numTwo = 0;
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Please enter a number");
            }
        }
    }
}

