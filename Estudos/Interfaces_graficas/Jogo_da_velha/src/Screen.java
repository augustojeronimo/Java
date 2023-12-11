import javax.swing.*;
import javax.swing.border.LineBorder;
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

        fieldPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        /* - Botões - */

        int buttonSize = fieldPanel.getHeight()/3 - 4; // Tamanho do botão
        int[] pos = {0, fieldPanel.getHeight()/2 - buttonSize/2, fieldPanel.getHeight() - buttonSize};

        buttons = new JButton[3][3];

        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {

                buttons[l][c] = new JButton("X");

                buttons[l][c].setBounds(pos[l],pos[c],buttonSize,buttonSize);

                buttons[l][c].setBackground(SPOT_COLOR);
                buttons[l][c].setForeground(new Color(255,255,255));
                buttons[l][c].setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
                buttons[l][c].setBorder(new LineBorder(new Color(0), 0));

                fieldPanel.add(buttons[l][c]);

            }
        }

        /* - Ação dos botões - */

        turn = 0;

        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {

                final int y = l;
                final int x = c;

                buttons[y][x].addActionListener(e -> {

                    if (buttons[y][x].getText().isEmpty()) {

                        String player = turn % 2 == 0? "X" : "O";

                        buttons[y][x].setText("O");
                        System.out.println(y+"-"+x);

                        turn++;
                    }

                });

            }
        }

        /* -  - */
    }

    /* Jogo */

    private int turn;

    /* Medidas */
    private final int HEIGHT = 500;
    private final int WIDTH = 800;

    /* Cores */

    private final Color BACKGROUND_COLOR = new Color(100,100,200);
    private final Color FIELD_COLOR = new Color(0,0,0);
    private final Color SPOT_COLOR = new Color(15, 42, 110);

    /* Elementos */

    private JPanel backgroundPanel;
    private JPanel fieldPanel;

    private JButton[][] buttons;

    public static void main(String[] args) {
        Screen game = new Screen();
    }
}
