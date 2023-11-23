import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    Screen() {
        /* - Tela - */
        setTitle("Jogo da velha");

        setSize(WIDTH, HEIGHT+40);
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        /* - Painel de fundo - */
        backgroundPanel = new JPanel();
        add(backgroundPanel);

        backgroundPanel.setBackground(BACKGROUND_COLOR);

        /* - Campo - */

        fieldPanel = new JPanel();
        fieldPanel.setLayout(getLayout());
        backgroundPanel.add(fieldPanel);

        fieldPanel.setBackground(FIELD_COLOR);
        fieldPanel.setBounds((WIDTH/2)-(HEIGHT/2),1,HEIGHT,HEIGHT);

        /* - Botões - */

        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        /* -  - */

        /* -  - */
    }

    /* Medidas */
    private final int HEIGHT = 500;
    private final int WIDTH = 800;

    /* Cores */

    private Color BACKGROUND_COLOR = new Color(100,100,200);
    private Color FIELD_COLOR = new Color(8, 28, 59);

    /* Elementos */

    private JPanel backgroundPanel;
    private JPanel fieldPanel;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    public static void main(String[] args) {
        Screen game = new Screen();
    }
}
