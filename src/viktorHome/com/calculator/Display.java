package viktorHome.com.calculator;

import javax.swing.*;

public class Display {
    public static void showDisplay() {
        InterfaceBuild show = new InterfaceBuild("Calculator");
        show.setVisible(true);                               // для отображения
        show.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // для выключения программы
        show.setResizable(false);                            // фиксирую окно
        show.setSize(250, 300);
    }
}
